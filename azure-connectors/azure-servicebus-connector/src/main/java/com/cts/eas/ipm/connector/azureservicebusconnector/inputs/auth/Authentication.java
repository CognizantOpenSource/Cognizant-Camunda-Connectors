package com.cts.eas.ipm.connector.azureservicebusconnector.inputs.auth;

import com.cts.eas.ipm.connector.azureservicebusconnector.inputs.ServiceBusRequest;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConnectionStringAuth.class, name = "connectionStringAuth"),
        @JsonSubTypes.Type(value = SharedKeyAuth.class, name = "sharedKeyAuth"),
        @JsonSubTypes.Type(value = ClientSecretAuth.class, name = "clientSecretAuth")

})
public abstract sealed class Authentication permits ConnectionStringAuth, SharedKeyAuth, ClientSecretAuth {
    public abstract Endpoint getEndpoint(ServiceBusRequest serviceBusRequest, CamelContext camelContext);
}
