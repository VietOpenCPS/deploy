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

import org.opencps.processmgt.model.WorkflowOutput;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WorkflowOutput in entity cache.
 *
 * @author khoavd
 * @see WorkflowOutput
 * @generated
 */
public class WorkflowOutputCacheModel implements CacheModel<WorkflowOutput>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{workflowOutputId=");
		sb.append(workflowOutputId);
		sb.append(", processWorkflowId=");
		sb.append(processWorkflowId);
		sb.append(", dossierPartId=");
		sb.append(dossierPartId);
		sb.append(", required=");
		sb.append(required);
		sb.append(", esign=");
		sb.append(esign);
		sb.append(", postback=");
		sb.append(postback);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkflowOutput toEntityModel() {
		WorkflowOutputImpl workflowOutputImpl = new WorkflowOutputImpl();

		workflowOutputImpl.setWorkflowOutputId(workflowOutputId);
		workflowOutputImpl.setProcessWorkflowId(processWorkflowId);
		workflowOutputImpl.setDossierPartId(dossierPartId);
		workflowOutputImpl.setRequired(required);
		workflowOutputImpl.setEsign(esign);
		workflowOutputImpl.setPostback(postback);

		workflowOutputImpl.resetOriginalValues();

		return workflowOutputImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowOutputId = objectInput.readLong();
		processWorkflowId = objectInput.readLong();
		dossierPartId = objectInput.readLong();
		required = objectInput.readBoolean();
		esign = objectInput.readBoolean();
		postback = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workflowOutputId);
		objectOutput.writeLong(processWorkflowId);
		objectOutput.writeLong(dossierPartId);
		objectOutput.writeBoolean(required);
		objectOutput.writeBoolean(esign);
		objectOutput.writeBoolean(postback);
	}

	public long workflowOutputId;
	public long processWorkflowId;
	public long dossierPartId;
	public boolean required;
	public boolean esign;
	public boolean postback;
}