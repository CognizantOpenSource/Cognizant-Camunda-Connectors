package com.cts.eas.ipm.connector.drools.input;

import java.io.Serializable;
import java.util.Objects;

public class DroolsConnectorInputs implements Serializable {

	private static final long serialVersionUID = 1L;

	private String agendaName;
	private String ruleInput;

	public String getAgendaName() {
		return agendaName;
	}

	public void setAgendaName(String agendaName) {
		this.agendaName = agendaName;
	}

	public String getRuleInput() {
		return ruleInput;
	}

	public void setRuleInput(String ruleInput) {
		this.ruleInput = ruleInput;
	}

	@Override
	public String toString() {
		return "DroolsConnectorInputs [ruleName=" + agendaName + ", input=" + ruleInput + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ruleInput, agendaName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DroolsConnectorInputs other = (DroolsConnectorInputs) obj;
		return Objects.equals(ruleInput, other.ruleInput) && Objects.equals(agendaName, other.agendaName);
	}

}
