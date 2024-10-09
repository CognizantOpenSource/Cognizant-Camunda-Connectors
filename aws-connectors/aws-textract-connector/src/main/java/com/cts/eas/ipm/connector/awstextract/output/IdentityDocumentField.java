
package com.cts.eas.ipm.connector.awstextract.output;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Type",
    "ValueDetection"
})
@Generated("jsonschema2pojo")
public class IdentityDocumentField {

    @JsonProperty("Type")
    private Type type;
    @JsonProperty("ValueDetection")
    private ValueDetection valueDetection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Type")
    public Type getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(Type type) {
        this.type = type;
    }

    public IdentityDocumentField withType(Type type) {
        this.type = type;
        return this;
    }

    @JsonProperty("ValueDetection")
    public ValueDetection getValueDetection() {
        return valueDetection;
    }

    @JsonProperty("ValueDetection")
    public void setValueDetection(ValueDetection valueDetection) {
        this.valueDetection = valueDetection;
    }

    public IdentityDocumentField withValueDetection(ValueDetection valueDetection) {
        this.valueDetection = valueDetection;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public IdentityDocumentField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IdentityDocumentField.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("valueDetection");
        sb.append('=');
        sb.append(((this.valueDetection == null)?"<null>":this.valueDetection));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.valueDetection == null)? 0 :this.valueDetection.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdentityDocumentField) == false) {
            return false;
        }
        IdentityDocumentField rhs = ((IdentityDocumentField) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.valueDetection == rhs.valueDetection)||((this.valueDetection!= null)&&this.valueDetection.equals(rhs.valueDetection))));
    }

}