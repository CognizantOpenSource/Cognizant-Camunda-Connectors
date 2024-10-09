package com.cts.eas.ipm.connector.drools.outbound;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.eas.ipm.connector.drools.config.DroolConfig;
import com.cts.eas.ipm.connector.drools.config.RuleData;
import com.cts.eas.ipm.connector.drools.input.DroolsConnectorInput;
import com.cts.eas.ipm.connector.drools.output.Response;
import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
import com.google.gson.Gson;

import io.camunda.connector.api.outbound.OutboundConnectorContext;

public class DroolsConnector implements CoreOutboundConnector {

	Logger LOGGER = LoggerFactory.getLogger(DroolsConnector.class);

	@Override
	public Object executeContext(OutboundConnectorContext context) {
		LOGGER.info("DroolsConnector executeContext is started ");
		var input = context.bindVariables(DroolsConnectorInput.class);
		LOGGER.info("DroolsConnector executeContext is ended ");
		return executeConnector(input);
	}

	private Object executeConnector(DroolsConnectorInput input) {

		LOGGER.info("DroolsConnector executeConnector is started ");
		
		RuleData ruleInput = null;
		try {
			ruleInput = convertJson(input.getInData().getRuleInput());
			LOGGER.info("ruleInput:{}",ruleInput);
		}
		catch (Exception e) {
			LOGGER.error("Input parsing error: {}",e);
			return "Invalid Input Json";
		}
		
		RuleData ruleData = null;
		if(null != ruleInput) {
			Response response = executeRules(ruleInput, input.getInData().getAgendaName());
			Gson gson = new Gson();
			return gson.toJson(response);
		
		}
		else {
			return "ERROR: Null input";
		}
	}
	
	private RuleData convertJson(String json) {
		Gson gson = new Gson();
		 return gson.fromJson(json, RuleData.class);
	}
	
    private  Response executeRules(RuleData ruleData, String agenda) {
    	LOGGER.info("DroolsConnector executeRules start ");
    	KieSession session = null;
    	Response response = new Response();
    	try {
    		KieContainer kieContainer = DroolConfig.getKieContainer();
            session = kieContainer.newKieSession();
            if(null != agenda && null != session.getAgenda().getAgendaGroup(agenda)) {
            	session.getAgenda().getAgendaGroup(agenda).setFocus();
            }

            session.insert(ruleData);
            session.fireAllRules();
            //setRule Data after execution of rules
            response.setRuleData(ruleData);
            LOGGER.info("rule data after execution:{}",ruleData);
    	}
    	catch (Exception e) {
    		LOGGER.error("Error occured in executing Rule: {}",e);
		}
    	finally {
    		if(null != session) {
    			session.dispose();
    			LOGGER.info("DroolsConnector executeRules end ");
    		}
    	}
        return response;
    }
}
