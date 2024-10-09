
package com.cts.eas.ipm.connector.awstextract.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "ValueDetections",
    "KeyDetection"
})
@Generated("jsonschema2pojo")
public class LendingField {

    @JsonProperty("Type")
    private String type;
    @JsonProperty("ValueDetections")
    private List<ValueDetection> valueDetections = new ArrayList<ValueDetection>();
    @JsonProperty("KeyDetection")
    private KeyDetection keyDetection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    public LendingField withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("ValueDetections")
    public List<ValueDetection> getValueDetections() {
        return valueDetections;
    }

    @JsonProperty("ValueDetections")
    public void setValueDetections(List<ValueDetection> valueDetections) {
        this.valueDetections = valueDetections;
    }

    public LendingField withValueDetections(List<ValueDetection> valueDetections) {
        this.valueDetections = valueDetections;
        return this;
    }

    @JsonProperty("KeyDetection")
    public KeyDetection getKeyDetection() {
        return keyDetection;
    }

    @JsonProperty("KeyDetection")
    public void setKeyDetection(KeyDetection keyDetection) {
        this.keyDetection = keyDetection;
    }

    public LendingField withKeyDetection(KeyDetection keyDetection) {
        this.keyDetection = keyDetection;
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

    public LendingField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LendingField.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("valueDetections");
        sb.append('=');
        sb.append(((this.valueDetections == null)?"<null>":this.valueDetections));
        sb.append(',');
        sb.append("keyDetection");
        sb.append('=');
        sb.append(((this.keyDetection == null)?"<null>":this.keyDetection));
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
        result = ((result* 31)+((this.keyDetection == null)? 0 :this.keyDetection.hashCode()));
        result = ((result* 31)+((this.valueDetections == null)? 0 :this.valueDetections.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LendingField) == false) {
            return false;
        }
        LendingField rhs = ((LendingField) other);
        return (((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.keyDetection == rhs.keyDetection)||((this.keyDetection!= null)&&this.keyDetection.equals(rhs.keyDetection))))&&((this.valueDetections == rhs.valueDetections)||((this.valueDetections!= null)&&this.valueDetections.equals(rhs.valueDetections))));
    }

}
