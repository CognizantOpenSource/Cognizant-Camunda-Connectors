package com.cts.eas.ipm.connector.drools.config;

import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;

public class DroolConfig {
    private static final String[] RULES_DRL = {"rules/sample-rule1.drl","rules/sample-rule2.drl"};
    private static final KieServices kieServices = KieServices.Factory.get();
    private static  KieModule kieModule;
    private static KieContainer kieContainer;
    
    static {
    	KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    	
    	Arrays.asList(RULES_DRL).forEach(rule -> {
    		kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
    	});
        
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        kieModule = kb.getKieModule();
        kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
    }

    public static KieContainer getKieContainer() {
        return kieContainer;
    }
}
