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

package org.opencps.processmgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.opencps.processmgt.model.ProcessStepDossierPart;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProcessStepDossierPart in entity cache.
 *
 * @author khoavd
 * @see ProcessStepDossierPart
 * @generated
 */
public class ProcessStepDossierPartCacheModel implements CacheModel<ProcessStepDossierPart>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{processStepId=");
		sb.append(processStepId);
		sb.append(", dossierPartId=");
		sb.append(dossierPartId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcessStepDossierPart toEntityModel() {
		ProcessStepDossierPartImpl processStepDossierPartImpl = new ProcessStepDossierPartImpl();

		processStepDossierPartImpl.setProcessStepId(processStepId);
		processStepDossierPartImpl.setDossierPartId(dossierPartId);

		processStepDossierPartImpl.resetOriginalValues();

		return processStepDossierPartImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		processStepId = objectInput.readLong();
		dossierPartId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(processStepId);
		objectOutput.writeLong(dossierPartId);
	}

	public long processStepId;
	public long dossierPartId;
}