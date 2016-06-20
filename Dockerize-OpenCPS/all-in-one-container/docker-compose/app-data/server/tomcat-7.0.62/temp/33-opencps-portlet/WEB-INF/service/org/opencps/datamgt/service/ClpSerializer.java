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

package org.opencps.datamgt.service;

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

import org.opencps.datamgt.model.DictCollectionClp;
import org.opencps.datamgt.model.DictItemClp;
import org.opencps.datamgt.model.DictVersionClp;

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

		if (oldModelClassName.equals(DictCollectionClp.class.getName())) {
			return translateInputDictCollection(oldModel);
		}

		if (oldModelClassName.equals(DictItemClp.class.getName())) {
			return translateInputDictItem(oldModel);
		}

		if (oldModelClassName.equals(DictVersionClp.class.getName())) {
			return translateInputDictVersion(oldModel);
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

	public static Object translateInputDictCollection(BaseModel<?> oldModel) {
		DictCollectionClp oldClpModel = (DictCollectionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDictCollectionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDictItem(BaseModel<?> oldModel) {
		DictItemClp oldClpModel = (DictItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDictItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDictVersion(BaseModel<?> oldModel) {
		DictVersionClp oldClpModel = (DictVersionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDictVersionRemoteModel();

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
					"org.opencps.datamgt.model.impl.DictCollectionImpl")) {
			return translateOutputDictCollection(oldModel);
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
					"org.opencps.datamgt.model.impl.DictItemImpl")) {
			return translateOutputDictItem(oldModel);
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
					"org.opencps.datamgt.model.impl.DictVersionImpl")) {
			return translateOutputDictVersion(oldModel);
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

		if (className.equals("org.opencps.datamgt.DuplicateCollectionException")) {
			return new org.opencps.datamgt.DuplicateCollectionException();
		}

		if (className.equals("org.opencps.datamgt.DuplicateItemException")) {
			return new org.opencps.datamgt.DuplicateItemException();
		}

		if (className.equals("org.opencps.datamgt.DuplicateVersionException")) {
			return new org.opencps.datamgt.DuplicateVersionException();
		}

		if (className.equals("org.opencps.datamgt.EmptyCollectionCodeException")) {
			return new org.opencps.datamgt.EmptyCollectionCodeException();
		}

		if (className.equals(
					"org.opencps.datamgt.EmptyDictCollectionNameException")) {
			return new org.opencps.datamgt.EmptyDictCollectionNameException();
		}

		if (className.equals("org.opencps.datamgt.EmptyDictItemNameException")) {
			return new org.opencps.datamgt.EmptyDictItemNameException();
		}

		if (className.equals("org.opencps.datamgt.EmptyItemCodeException")) {
			return new org.opencps.datamgt.EmptyItemCodeException();
		}

		if (className.equals("org.opencps.datamgt.ExistDraftException")) {
			return new org.opencps.datamgt.ExistDraftException();
		}

		if (className.equals(
					"org.opencps.datamgt.OutOfLengthCollectionCodeException")) {
			return new org.opencps.datamgt.OutOfLengthCollectionCodeException();
		}

		if (className.equals(
					"org.opencps.datamgt.OutOfLengthCollectionDescriptionException")) {
			return new org.opencps.datamgt.OutOfLengthCollectionDescriptionException();
		}

		if (className.equals(
					"org.opencps.datamgt.OutOfLengthCollectionNameException")) {
			return new org.opencps.datamgt.OutOfLengthCollectionNameException();
		}

		if (className.equals("org.opencps.datamgt.OutOfLengthItemCodeException")) {
			return new org.opencps.datamgt.OutOfLengthItemCodeException();
		}

		if (className.equals(
					"org.opencps.datamgt.OutOfLengthItemDescriptionException")) {
			return new org.opencps.datamgt.OutOfLengthItemDescriptionException();
		}

		if (className.equals("org.opencps.datamgt.OutOfLengthItemNameException")) {
			return new org.opencps.datamgt.OutOfLengthItemNameException();
		}

		if (className.equals(
					"org.opencps.datamgt.OutOfLengthVesionDescriptionException")) {
			return new org.opencps.datamgt.OutOfLengthVesionDescriptionException();
		}

		if (className.equals(
					"org.opencps.datamgt.NoSuchDictCollectionException")) {
			return new org.opencps.datamgt.NoSuchDictCollectionException();
		}

		if (className.equals("org.opencps.datamgt.NoSuchDictItemException")) {
			return new org.opencps.datamgt.NoSuchDictItemException();
		}

		if (className.equals("org.opencps.datamgt.NoSuchDictVersionException")) {
			return new org.opencps.datamgt.NoSuchDictVersionException();
		}

		return throwable;
	}

	public static Object translateOutputDictCollection(BaseModel<?> oldModel) {
		DictCollectionClp newModel = new DictCollectionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDictCollectionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDictItem(BaseModel<?> oldModel) {
		DictItemClp newModel = new DictItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDictItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDictVersion(BaseModel<?> oldModel) {
		DictVersionClp newModel = new DictVersionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDictVersionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}