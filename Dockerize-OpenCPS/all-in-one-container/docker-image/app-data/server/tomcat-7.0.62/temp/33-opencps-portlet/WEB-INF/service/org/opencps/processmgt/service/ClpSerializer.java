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

package org.opencps.processmgt.service;

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

import org.opencps.processmgt.model.ActionHistoryClp;
import org.opencps.processmgt.model.ProcessOrderClp;
import org.opencps.processmgt.model.ProcessStepClp;
import org.opencps.processmgt.model.ProcessStepDossierPartClp;
import org.opencps.processmgt.model.ProcessWorkflowClp;
import org.opencps.processmgt.model.ServiceInfoProcessClp;
import org.opencps.processmgt.model.ServiceProcessClp;
import org.opencps.processmgt.model.StepAllowanceClp;
import org.opencps.processmgt.model.WorkflowOutputClp;

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

		if (oldModelClassName.equals(ActionHistoryClp.class.getName())) {
			return translateInputActionHistory(oldModel);
		}

		if (oldModelClassName.equals(ProcessOrderClp.class.getName())) {
			return translateInputProcessOrder(oldModel);
		}

		if (oldModelClassName.equals(ProcessStepClp.class.getName())) {
			return translateInputProcessStep(oldModel);
		}

		if (oldModelClassName.equals(ProcessStepDossierPartClp.class.getName())) {
			return translateInputProcessStepDossierPart(oldModel);
		}

		if (oldModelClassName.equals(ProcessWorkflowClp.class.getName())) {
			return translateInputProcessWorkflow(oldModel);
		}

		if (oldModelClassName.equals(ServiceInfoProcessClp.class.getName())) {
			return translateInputServiceInfoProcess(oldModel);
		}

		if (oldModelClassName.equals(ServiceProcessClp.class.getName())) {
			return translateInputServiceProcess(oldModel);
		}

		if (oldModelClassName.equals(StepAllowanceClp.class.getName())) {
			return translateInputStepAllowance(oldModel);
		}

		if (oldModelClassName.equals(WorkflowOutputClp.class.getName())) {
			return translateInputWorkflowOutput(oldModel);
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

	public static Object translateInputActionHistory(BaseModel<?> oldModel) {
		ActionHistoryClp oldClpModel = (ActionHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getActionHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProcessOrder(BaseModel<?> oldModel) {
		ProcessOrderClp oldClpModel = (ProcessOrderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProcessOrderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProcessStep(BaseModel<?> oldModel) {
		ProcessStepClp oldClpModel = (ProcessStepClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProcessStepRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProcessStepDossierPart(
		BaseModel<?> oldModel) {
		ProcessStepDossierPartClp oldClpModel = (ProcessStepDossierPartClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProcessStepDossierPartRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProcessWorkflow(BaseModel<?> oldModel) {
		ProcessWorkflowClp oldClpModel = (ProcessWorkflowClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProcessWorkflowRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputServiceInfoProcess(BaseModel<?> oldModel) {
		ServiceInfoProcessClp oldClpModel = (ServiceInfoProcessClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getServiceInfoProcessRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputServiceProcess(BaseModel<?> oldModel) {
		ServiceProcessClp oldClpModel = (ServiceProcessClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getServiceProcessRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStepAllowance(BaseModel<?> oldModel) {
		StepAllowanceClp oldClpModel = (StepAllowanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStepAllowanceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkflowOutput(BaseModel<?> oldModel) {
		WorkflowOutputClp oldClpModel = (WorkflowOutputClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkflowOutputRemoteModel();

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
					"org.opencps.processmgt.model.impl.ActionHistoryImpl")) {
			return translateOutputActionHistory(oldModel);
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
					"org.opencps.processmgt.model.impl.ProcessOrderImpl")) {
			return translateOutputProcessOrder(oldModel);
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
					"org.opencps.processmgt.model.impl.ProcessStepImpl")) {
			return translateOutputProcessStep(oldModel);
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
					"org.opencps.processmgt.model.impl.ProcessStepDossierPartImpl")) {
			return translateOutputProcessStepDossierPart(oldModel);
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
					"org.opencps.processmgt.model.impl.ProcessWorkflowImpl")) {
			return translateOutputProcessWorkflow(oldModel);
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
					"org.opencps.processmgt.model.impl.ServiceInfoProcessImpl")) {
			return translateOutputServiceInfoProcess(oldModel);
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
					"org.opencps.processmgt.model.impl.ServiceProcessImpl")) {
			return translateOutputServiceProcess(oldModel);
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
					"org.opencps.processmgt.model.impl.StepAllowanceImpl")) {
			return translateOutputStepAllowance(oldModel);
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
					"org.opencps.processmgt.model.impl.WorkflowOutputImpl")) {
			return translateOutputWorkflowOutput(oldModel);
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

		if (className.equals("org.opencps.processmgt.EmptyProcessNameException")) {
			return new org.opencps.processmgt.EmptyProcessNameException();
		}

		if (className.equals("org.opencps.processmgt.EmptyProcessNoException")) {
			return new org.opencps.processmgt.EmptyProcessNoException();
		}

		if (className.equals("org.opencps.processmgt.EmptyStepNameException")) {
			return new org.opencps.processmgt.EmptyStepNameException();
		}

		if (className.equals("org.opencps.processmgt.EmptyStepNoException")) {
			return new org.opencps.processmgt.EmptyStepNoException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchActionHistoryException")) {
			return new org.opencps.processmgt.NoSuchActionHistoryException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchProcessOrderException")) {
			return new org.opencps.processmgt.NoSuchProcessOrderException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchProcessStepException")) {
			return new org.opencps.processmgt.NoSuchProcessStepException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchProcessStepDossierPartException")) {
			return new org.opencps.processmgt.NoSuchProcessStepDossierPartException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchProcessWorkflowException")) {
			return new org.opencps.processmgt.NoSuchProcessWorkflowException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchServiceInfoProcessException")) {
			return new org.opencps.processmgt.NoSuchServiceInfoProcessException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchServiceProcessException")) {
			return new org.opencps.processmgt.NoSuchServiceProcessException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchStepAllowanceException")) {
			return new org.opencps.processmgt.NoSuchStepAllowanceException();
		}

		if (className.equals(
					"org.opencps.processmgt.NoSuchWorkflowOutputException")) {
			return new org.opencps.processmgt.NoSuchWorkflowOutputException();
		}

		return throwable;
	}

	public static Object translateOutputActionHistory(BaseModel<?> oldModel) {
		ActionHistoryClp newModel = new ActionHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setActionHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProcessOrder(BaseModel<?> oldModel) {
		ProcessOrderClp newModel = new ProcessOrderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProcessOrderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProcessStep(BaseModel<?> oldModel) {
		ProcessStepClp newModel = new ProcessStepClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProcessStepRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProcessStepDossierPart(
		BaseModel<?> oldModel) {
		ProcessStepDossierPartClp newModel = new ProcessStepDossierPartClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProcessStepDossierPartRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProcessWorkflow(BaseModel<?> oldModel) {
		ProcessWorkflowClp newModel = new ProcessWorkflowClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProcessWorkflowRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputServiceInfoProcess(
		BaseModel<?> oldModel) {
		ServiceInfoProcessClp newModel = new ServiceInfoProcessClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setServiceInfoProcessRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputServiceProcess(BaseModel<?> oldModel) {
		ServiceProcessClp newModel = new ServiceProcessClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setServiceProcessRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStepAllowance(BaseModel<?> oldModel) {
		StepAllowanceClp newModel = new StepAllowanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStepAllowanceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkflowOutput(BaseModel<?> oldModel) {
		WorkflowOutputClp newModel = new WorkflowOutputClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkflowOutputRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}