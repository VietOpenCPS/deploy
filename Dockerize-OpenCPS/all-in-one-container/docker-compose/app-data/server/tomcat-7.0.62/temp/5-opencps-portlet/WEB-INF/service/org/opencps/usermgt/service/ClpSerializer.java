/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.usermgt.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.opencps.usermgt.model.EmployeeClp;
import org.opencps.usermgt.model.JobPosClp;
import org.opencps.usermgt.model.WorkingUnitClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author khoavd
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"opencps-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"opencps-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "opencps-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EmployeeClp.class.getName())) {
			return translateInputEmployee(oldModel);
		}

		if (oldModelClassName.equals(JobPosClp.class.getName())) {
			return translateInputJobPos(oldModel);
		}

		if (oldModelClassName.equals(WorkingUnitClp.class.getName())) {
			return translateInputWorkingUnit(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputEmployee(BaseModel<?> oldModel) {
		EmployeeClp oldClpModel = (EmployeeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmployeeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobPos(BaseModel<?> oldModel) {
		JobPosClp oldClpModel = (JobPosClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobPosRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkingUnit(BaseModel<?> oldModel) {
		WorkingUnitClp oldClpModel = (WorkingUnitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkingUnitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"org.opencps.usermgt.model.impl.EmployeeImpl")) {
			return translateOutputEmployee(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.opencps.usermgt.model.impl.JobPosImpl")) {
			return translateOutputJobPos(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.opencps.usermgt.model.impl.WorkingUnitImpl")) {
			return translateOutputWorkingUnit(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"org.opencps.usermgt.DuplicatEgovAgencyCodeException")) {
			return new org.opencps.usermgt.DuplicatEgovAgencyCodeException();
		}

		if (className.equals(
					"org.opencps.usermgt.DuplicatWorkingUnitEmailException")) {
			return new org.opencps.usermgt.DuplicatWorkingUnitEmailException();
		}

		if (className.equals(
					"org.opencps.usermgt.DuplicateEmployeeEmailException")) {
			return new org.opencps.usermgt.DuplicateEmployeeEmailException();
		}

		if (className.equals("org.opencps.usermgt.DuplicateEmployeeNoException")) {
			return new org.opencps.usermgt.DuplicateEmployeeNoException();
		}

		if (className.equals("org.opencps.usermgt.DuplicateJobPosException")) {
			return new org.opencps.usermgt.DuplicateJobPosException();
		}

		if (className.equals(
					"org.opencps.usermgt.DuplicateWorkingUnitException")) {
			return new org.opencps.usermgt.DuplicateWorkingUnitException();
		}

		if (className.equals("org.opencps.usermgt.EmptyEmployeeEmailException")) {
			return new org.opencps.usermgt.EmptyEmployeeEmailException();
		}

		if (className.equals("org.opencps.usermgt.EmptyEmployeeNameException")) {
			return new org.opencps.usermgt.EmptyEmployeeNameException();
		}

		if (className.equals("org.opencps.usermgt.EmptyEmployeeNoException")) {
			return new org.opencps.usermgt.EmptyEmployeeNoException();
		}

		if (className.equals("org.opencps.usermgt.EmptyJobPosTitleException")) {
			return new org.opencps.usermgt.EmptyJobPosTitleException();
		}

		if (className.equals(
					"org.opencps.usermgt.EmptyWorkingUnitNameException")) {
			return new org.opencps.usermgt.EmptyWorkingUnitNameException();
		}

		if (className.equals(
					"org.opencps.usermgt.OutOfLengthDescriptionException")) {
			return new org.opencps.usermgt.OutOfLengthDescriptionException();
		}

		if (className.equals("org.opencps.usermgt.OutOfLengthEmployNoException")) {
			return new org.opencps.usermgt.OutOfLengthEmployNoException();
		}

		if (className.equals(
					"org.opencps.usermgt.OutOfLengthEmployeeEmailException")) {
			return new org.opencps.usermgt.OutOfLengthEmployeeEmailException();
		}

		if (className.equals("org.opencps.usermgt.OutOfLengthFullNameException")) {
			return new org.opencps.usermgt.OutOfLengthFullNameException();
		}

		if (className.equals("org.opencps.usermgt.OutOfLengthJobTitleException")) {
			return new org.opencps.usermgt.OutOfLengthJobTitleException();
		}

		if (className.equals("org.opencps.usermgt.OutOfLengthMobileException")) {
			return new org.opencps.usermgt.OutOfLengthMobileException();
		}

		if (className.equals("org.opencps.usermgt.OutOfLengthTelNoException")) {
			return new org.opencps.usermgt.OutOfLengthTelNoException();
		}

		if (className.equals(
					"org.opencps.usermgt.OutOfLengthUnitEmailException")) {
			return new org.opencps.usermgt.OutOfLengthUnitEmailException();
		}

		if (className.equals(
					"org.opencps.usermgt.OutOfLengthUnitEnNameException")) {
			return new org.opencps.usermgt.OutOfLengthUnitEnNameException();
		}

		if (className.equals("org.opencps.usermgt.OutOfLengthUnitNameException")) {
			return new org.opencps.usermgt.OutOfLengthUnitNameException();
		}

		if (className.equals("org.opencps.usermgt.OutOfScopeException")) {
			return new org.opencps.usermgt.OutOfScopeException();
		}

		if (className.equals("org.opencps.usermgt.NoSuchEmployeeException")) {
			return new org.opencps.usermgt.NoSuchEmployeeException();
		}

		if (className.equals("org.opencps.usermgt.NoSuchJobPosException")) {
			return new org.opencps.usermgt.NoSuchJobPosException();
		}

		if (className.equals("org.opencps.usermgt.NoSuchWorkingUnitException")) {
			return new org.opencps.usermgt.NoSuchWorkingUnitException();
		}

		return throwable;
	}

	public static Object translateOutputEmployee(BaseModel<?> oldModel) {
		EmployeeClp newModel = new EmployeeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmployeeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobPos(BaseModel<?> oldModel) {
		JobPosClp newModel = new JobPosClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobPosRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkingUnit(BaseModel<?> oldModel) {
		WorkingUnitClp newModel = new WorkingUnitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkingUnitRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}