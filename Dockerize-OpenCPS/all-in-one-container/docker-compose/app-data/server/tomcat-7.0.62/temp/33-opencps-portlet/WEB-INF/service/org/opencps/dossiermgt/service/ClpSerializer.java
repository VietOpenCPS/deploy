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

package org.opencps.dossiermgt.service;

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

import org.opencps.dossiermgt.model.DossierClp;
import org.opencps.dossiermgt.model.DossierFileClp;
import org.opencps.dossiermgt.model.DossierLogClp;
import org.opencps.dossiermgt.model.DossierPartClp;
import org.opencps.dossiermgt.model.DossierStatusClp;
import org.opencps.dossiermgt.model.DossierTemplateClp;
import org.opencps.dossiermgt.model.FileGroupClp;
import org.opencps.dossiermgt.model.ServiceConfigClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author trungnt
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

		if (oldModelClassName.equals(DossierClp.class.getName())) {
			return translateInputDossier(oldModel);
		}

		if (oldModelClassName.equals(DossierFileClp.class.getName())) {
			return translateInputDossierFile(oldModel);
		}

		if (oldModelClassName.equals(DossierLogClp.class.getName())) {
			return translateInputDossierLog(oldModel);
		}

		if (oldModelClassName.equals(DossierPartClp.class.getName())) {
			return translateInputDossierPart(oldModel);
		}

		if (oldModelClassName.equals(DossierStatusClp.class.getName())) {
			return translateInputDossierStatus(oldModel);
		}

		if (oldModelClassName.equals(DossierTemplateClp.class.getName())) {
			return translateInputDossierTemplate(oldModel);
		}

		if (oldModelClassName.equals(FileGroupClp.class.getName())) {
			return translateInputFileGroup(oldModel);
		}

		if (oldModelClassName.equals(ServiceConfigClp.class.getName())) {
			return translateInputServiceConfig(oldModel);
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

	public static Object translateInputDossier(BaseModel<?> oldModel) {
		DossierClp oldClpModel = (DossierClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDossierRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDossierFile(BaseModel<?> oldModel) {
		DossierFileClp oldClpModel = (DossierFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDossierFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDossierLog(BaseModel<?> oldModel) {
		DossierLogClp oldClpModel = (DossierLogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDossierLogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDossierPart(BaseModel<?> oldModel) {
		DossierPartClp oldClpModel = (DossierPartClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDossierPartRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDossierStatus(BaseModel<?> oldModel) {
		DossierStatusClp oldClpModel = (DossierStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDossierStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDossierTemplate(BaseModel<?> oldModel) {
		DossierTemplateClp oldClpModel = (DossierTemplateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDossierTemplateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFileGroup(BaseModel<?> oldModel) {
		FileGroupClp oldClpModel = (FileGroupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFileGroupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputServiceConfig(BaseModel<?> oldModel) {
		ServiceConfigClp oldClpModel = (ServiceConfigClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getServiceConfigRemoteModel();

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
					"org.opencps.dossiermgt.model.impl.DossierImpl")) {
			return translateOutputDossier(oldModel);
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
					"org.opencps.dossiermgt.model.impl.DossierFileImpl")) {
			return translateOutputDossierFile(oldModel);
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
					"org.opencps.dossiermgt.model.impl.DossierLogImpl")) {
			return translateOutputDossierLog(oldModel);
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
					"org.opencps.dossiermgt.model.impl.DossierPartImpl")) {
			return translateOutputDossierPart(oldModel);
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
					"org.opencps.dossiermgt.model.impl.DossierStatusImpl")) {
			return translateOutputDossierStatus(oldModel);
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
					"org.opencps.dossiermgt.model.impl.DossierTemplateImpl")) {
			return translateOutputDossierTemplate(oldModel);
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
					"org.opencps.dossiermgt.model.impl.FileGroupImpl")) {
			return translateOutputFileGroup(oldModel);
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
					"org.opencps.dossiermgt.model.impl.ServiceConfigImpl")) {
			return translateOutputServiceConfig(oldModel);
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
					"org.opencps.dossiermgt.CreateDossierFolderException")) {
			return new org.opencps.dossiermgt.CreateDossierFolderException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.DuplicateDossierPartNumberException")) {
			return new org.opencps.dossiermgt.DuplicateDossierPartNumberException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.DuplicateDossierPartSiblingException")) {
			return new org.opencps.dossiermgt.DuplicateDossierPartSiblingException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.DuplicateDossierTemplateNumberException")) {
			return new org.opencps.dossiermgt.DuplicateDossierTemplateNumberException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierAddressException")) {
			return new org.opencps.dossiermgt.EmptyDossierAddressException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierCityCodeException")) {
			return new org.opencps.dossiermgt.EmptyDossierCityCodeException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierContactNameException")) {
			return new org.opencps.dossiermgt.EmptyDossierContactNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierDistrictCodeException")) {
			return new org.opencps.dossiermgt.EmptyDossierDistrictCodeException();
		}

		if (className.equals("org.opencps.dossiermgt.EmptyDossierFileException")) {
			return new org.opencps.dossiermgt.EmptyDossierFileException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierSubjectIdException")) {
			return new org.opencps.dossiermgt.EmptyDossierSubjectIdException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierSubjectNameException")) {
			return new org.opencps.dossiermgt.EmptyDossierSubjectNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.EmptyDossierWardCodeException")) {
			return new org.opencps.dossiermgt.EmptyDossierWardCodeException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.InvalidDossierObjectException")) {
			return new org.opencps.dossiermgt.InvalidDossierObjectException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.InvalidInWorkingUnitException")) {
			return new org.opencps.dossiermgt.InvalidInWorkingUnitException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.InvalidServiceConfigGovCodeException")) {
			return new org.opencps.dossiermgt.InvalidServiceConfigGovCodeException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.InvalidServiceConfigGovNameException")) {
			return new org.opencps.dossiermgt.InvalidServiceConfigGovNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.InvalidServiceDomainException")) {
			return new org.opencps.dossiermgt.InvalidServiceDomainException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierAddressException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierAddressException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierContactEmailException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierContactEmailException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierContactNameException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierContactNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierContactTelNoException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierContactTelNoException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierNoteException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierNoteException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierPartNameException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierPartNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierPartNumberException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierPartNumberException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierSubjectIdException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierSubjectIdException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierSubjectNameException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierSubjectNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierTemplateFileNumberException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierTemplateFileNumberException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierTemplateNameException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierTemplateNameException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthDossierTemplateNumberException")) {
			return new org.opencps.dossiermgt.OutOfLengthDossierTemplateNumberException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthServiceConfigGovCodeException")) {
			return new org.opencps.dossiermgt.OutOfLengthServiceConfigGovCodeException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.OutOfLengthServiceConfigGovNameException")) {
			return new org.opencps.dossiermgt.OutOfLengthServiceConfigGovNameException();
		}

		if (className.equals("org.opencps.dossiermgt.NoSuchDossierException")) {
			return new org.opencps.dossiermgt.NoSuchDossierException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.NoSuchDossierFileException")) {
			return new org.opencps.dossiermgt.NoSuchDossierFileException();
		}

		if (className.equals("org.opencps.dossiermgt.NoSuchDossierLogException")) {
			return new org.opencps.dossiermgt.NoSuchDossierLogException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.NoSuchDossierPartException")) {
			return new org.opencps.dossiermgt.NoSuchDossierPartException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.NoSuchDossierStatusException")) {
			return new org.opencps.dossiermgt.NoSuchDossierStatusException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.NoSuchDossierTemplateException")) {
			return new org.opencps.dossiermgt.NoSuchDossierTemplateException();
		}

		if (className.equals("org.opencps.dossiermgt.NoSuchFileGroupException")) {
			return new org.opencps.dossiermgt.NoSuchFileGroupException();
		}

		if (className.equals(
					"org.opencps.dossiermgt.NoSuchServiceConfigException")) {
			return new org.opencps.dossiermgt.NoSuchServiceConfigException();
		}

		return throwable;
	}

	public static Object translateOutputDossier(BaseModel<?> oldModel) {
		DossierClp newModel = new DossierClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDossierRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDossierFile(BaseModel<?> oldModel) {
		DossierFileClp newModel = new DossierFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDossierFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDossierLog(BaseModel<?> oldModel) {
		DossierLogClp newModel = new DossierLogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDossierLogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDossierPart(BaseModel<?> oldModel) {
		DossierPartClp newModel = new DossierPartClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDossierPartRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDossierStatus(BaseModel<?> oldModel) {
		DossierStatusClp newModel = new DossierStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDossierStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDossierTemplate(BaseModel<?> oldModel) {
		DossierTemplateClp newModel = new DossierTemplateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDossierTemplateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFileGroup(BaseModel<?> oldModel) {
		FileGroupClp newModel = new FileGroupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFileGroupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputServiceConfig(BaseModel<?> oldModel) {
		ServiceConfigClp newModel = new ServiceConfigClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setServiceConfigRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}