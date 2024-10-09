package com.cts.eas.ipm.connector.drools.output;

import com.cts.eas.ipm.connector.drools.config.RuleData;

public class Response {
	
	private RuleData ruleData;
//	private Boolean isAgendaexecuted;
	public RuleData getRuleData() {
		return ruleData;
	}
	public void setRuleData(RuleData ruleData) {
		this.ruleData = ruleData;
	}
//	public Boolean getIsAgendaexecuted() {
//		return isAgendaexecuted;
//	}
//	public void setIsAgendaexecuted(Boolean isAgendaexecuted) {
//		this.isAgendaexecuted = isAgendaexecuted;
//	}
}
