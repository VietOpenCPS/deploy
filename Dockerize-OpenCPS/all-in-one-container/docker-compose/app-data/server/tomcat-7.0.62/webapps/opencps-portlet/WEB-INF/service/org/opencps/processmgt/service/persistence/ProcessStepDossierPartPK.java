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

package org.opencps.processmgt.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author khoavd
 * @generated
 */
public class ProcessStepDossierPartPK implements Comparable<ProcessStepDossierPartPK>,
	Serializable {
	public long processStepId;
	public long dossierPartId;

	public ProcessStepDossierPartPK() {
	}

	public ProcessStepDossierPartPK(long processStepId, long dossierPartId) {
		this.processStepId = processStepId;
		this.dossierPartId = dossierPartId;
	}

	public long getProcessStepId() {
		return processStepId;
	}

	public void setProcessStepId(long processStepId) {
		this.processStepId = processStepId;
	}

	public long getDossierPartId() {
		return dossierPartId;
	}

	public void setDossierPartId(long dossierPartId) {
		this.dossierPartId = dossierPartId;
	}

	@Override
	public int compareTo(ProcessStepDossierPartPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (processStepId < pk.processStepId) {
			value = -1;
		}
		else if (processStepId > pk.processStepId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (dossierPartId < pk.dossierPartId) {
			value = -1;
		}
		else if (dossierPartId > pk.dossierPartId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessStepDossierPartPK)) {
			return false;
		}

		ProcessStepDossierPartPK pk = (ProcessStepDossierPartPK)obj;

		if ((processStepId == pk.processStepId) &&
				(dossierPartId == pk.dossierPartId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(processStepId) + String.valueOf(dossierPartId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("processStepId");
		sb.append(StringPool.EQUAL);
		sb.append(processStepId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("dossierPartId");
		sb.append(StringPool.EQUAL);
		sb.append(dossierPartId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}