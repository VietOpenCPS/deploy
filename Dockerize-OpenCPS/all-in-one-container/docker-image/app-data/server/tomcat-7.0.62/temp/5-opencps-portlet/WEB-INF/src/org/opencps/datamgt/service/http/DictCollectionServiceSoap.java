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

package org.opencps.datamgt.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.opencps.datamgt.service.DictCollectionServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.opencps.datamgt.service.DictCollectionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.opencps.datamgt.model.DictCollectionSoap}.
 * If the method in the service utility returns a
 * {@link org.opencps.datamgt.model.DictCollection}, that is translated to a
 * {@link org.opencps.datamgt.model.DictCollectionSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author khoavd
 * @see DictCollectionServiceHttp
 * @see org.opencps.datamgt.model.DictCollectionSoap
 * @see org.opencps.datamgt.service.DictCollectionServiceUtil
 * @generated
 */
public class DictCollectionServiceSoap {
	/**
	* <p> Get DictCollection </p>
	*
	* @param groupId
	là mã UserGroup của người đăng nhập
	* @param collectionCode
	là mã của DictCollection
	* @return trả về đối tượng DictCollection theo dictCollectionId
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	* @throws NoSuchDictCollectionException
	Khi xảy ra lỗi không tìm thấy DictCollection
	*/
	public static org.opencps.datamgt.model.DictCollectionSoap getDictCollection(
		long groupId, java.lang.String collectionCode)
		throws RemoteException {
		try {
			org.opencps.datamgt.model.DictCollection returnValue = DictCollectionServiceUtil.getDictCollection(groupId,
					collectionCode);

			return org.opencps.datamgt.model.DictCollectionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DictCollectionServiceSoap.class);
}