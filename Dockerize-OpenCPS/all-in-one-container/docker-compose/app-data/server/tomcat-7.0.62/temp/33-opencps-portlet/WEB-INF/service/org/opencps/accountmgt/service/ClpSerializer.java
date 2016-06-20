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

package org.opencps.accountmgt.service;

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

import org.opencps.accountmgt.model.BusinessAccountClp;
import org.opencps.accountmgt.model.BusinessClp;
import org.opencps.accountmgt.model.BusinessDomainClp;
import org.opencps.accountmgt.model.CitizenClp;

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

		if (oldModelClassName.equals(BusinessClp.class.getName())) {
			return translateInputBusiness(oldModel);
		}

		if (oldModelClassName.equals(BusinessAccountClp.class.getName())) {
			return translateInputBusinessAccount(oldModel);
		}

		if (oldModelClassName.equals(BusinessDomainClp.class.getName())) {
			return translateInputBusinessDomain(oldModel);
		}

		if (oldModelClassName.equals(CitizenClp.class.getName())) {
			return translateInputCitizen(oldModel);
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

	public static Object translateInputBusiness(BaseModel<?> oldModel) {
		BusinessClp oldClpModel = (BusinessClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBusinessRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBusinessAccount(BaseModel<?> oldModel) {
		BusinessAccountClp oldClpModel = (BusinessAccountClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBusinessAccountRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBusinessDomain(BaseModel<?> oldModel) {
		BusinessDomainClp oldClpModel = (BusinessDomainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBusinessDomainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCitizen(BaseModel<?> oldModel) {
		CitizenClp oldClpModel = (CitizenClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCitizenRemoteModel();

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
					"org.opencps.accountmgt.model.impl.BusinessImpl")) {
			return translateOutputBusiness(oldModel);
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
					"org.opencps.accountmgt.model.impl.BusinessAccountImpl")) {
			return translateOutputBusinessAccount(oldModel);
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
					"org.opencps.accountmgt.model.impl.BusinessDomainImpl")) {
			return translateOutputBusinessDomain(oldModel);
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
					"org.opencps.accountmgt.model.impl.CitizenImpl")) {
			return translateOutputCitizen(oldModel);
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
					"org.opencps.accountmgt.DuplicateBusinessEmailException")) {
			return new org.opencps.accountmgt.DuplicateBusinessEmailException();
		}

		if (className.equals(
					"org.opencps.accountmgt.DuplicateCitizenEmailException")) {
			return new org.opencps.accountmgt.DuplicateCitizenEmailException();
		}

		if (className.equals("org.opencps.accountmgt.FileTypeFailException")) {
			return new org.opencps.accountmgt.FileTypeFailException();
		}

		if (className.equals("org.opencps.accountmgt.InvalidCityCodeException")) {
			return new org.opencps.accountmgt.InvalidCityCodeException();
		}

		if (className.equals(
					"org.opencps.accountmgt.InvalidDistricCodeException")) {
			return new org.opencps.accountmgt.InvalidDistricCodeException();
		}

		if (className.equals(
					"org.opencps.accountmgt.InvalidFileUploadException")) {
			return new org.opencps.accountmgt.InvalidFileUploadException();
		}

		if (className.equals("org.opencps.accountmgt.InvalidWardCodeException")) {
			return new org.opencps.accountmgt.InvalidWardCodeException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthBusinessEmailException")) {
			return new org.opencps.accountmgt.OutOfLengthBusinessEmailException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthBusinessEnNameException")) {
			return new org.opencps.accountmgt.OutOfLengthBusinessEnNameException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthBusinessNameException")) {
			return new org.opencps.accountmgt.OutOfLengthBusinessNameException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthBusinessRepresentativeNameException")) {
			return new org.opencps.accountmgt.OutOfLengthBusinessRepresentativeNameException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthBusinessRepresentativeRoleException")) {
			return new org.opencps.accountmgt.OutOfLengthBusinessRepresentativeRoleException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthBusinessShortNameException")) {
			return new org.opencps.accountmgt.OutOfLengthBusinessShortNameException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthCitizenAddressException")) {
			return new org.opencps.accountmgt.OutOfLengthCitizenAddressException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthCitizenEmailException")) {
			return new org.opencps.accountmgt.OutOfLengthCitizenEmailException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfLengthCitizenNameException")) {
			return new org.opencps.accountmgt.OutOfLengthCitizenNameException();
		}

		if (className.equals(
					"org.opencps.accountmgt.OutOfSizeFileUploadException")) {
			return new org.opencps.accountmgt.OutOfSizeFileUploadException();
		}

		if (className.equals("org.opencps.accountmgt.NoSuchBusinessException")) {
			return new org.opencps.accountmgt.NoSuchBusinessException();
		}

		if (className.equals(
					"org.opencps.accountmgt.NoSuchBusinessAccountException")) {
			return new org.opencps.accountmgt.NoSuchBusinessAccountException();
		}

		if (className.equals(
					"org.opencps.accountmgt.NoSuchBusinessDomainException")) {
			return new org.opencps.accountmgt.NoSuchBusinessDomainException();
		}

		if (className.equals("org.opencps.accountmgt.NoSuchCitizenException")) {
			return new org.opencps.accountmgt.NoSuchCitizenException();
		}

		return throwable;
	}

	public static Object translateOutputBusiness(BaseModel<?> oldModel) {
		BusinessClp newModel = new BusinessClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBusinessRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBusinessAccount(BaseModel<?> oldModel) {
		BusinessAccountClp newModel = new BusinessAccountClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBusinessAccountRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBusinessDomain(BaseModel<?> oldModel) {
		BusinessDomainClp newModel = new BusinessDomainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBusinessDomainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCitizen(BaseModel<?> oldModel) {
		CitizenClp newModel = new CitizenClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCitizenRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}