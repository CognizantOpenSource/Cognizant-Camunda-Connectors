
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
    "Text",
    "Confidence",
    "NormalizedValue"
})
@Generated("jsonschema2pojo")
public class ValueDetection {

    @JsonProperty("Text")
    private String text;
    @JsonProperty("Confidence")
    private Double confidence;
    @JsonProperty("NormalizedValue")
    private NormalizedValue normalizedValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Text")
    public String getText() {
        return text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        this.text = text;
    }

    public ValueDetection withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("Confidence")
    public Double getConfidence() {
        return confidence;
    }

    @JsonProperty("Confidence")
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public ValueDetection withConfidence(Double confidence) {
        this.confidence = confidence;
        return this;
    }

    @JsonProperty("NormalizedValue")
    public NormalizedValue getNormalizedValue() {
        return normalizedValue;
    }

    @JsonProperty("NormalizedValue")
    public void setNormalizedValue(NormalizedValue normalizedValue) {
        this.normalizedValue = normalizedValue;
    }

    public ValueDetection withNormalizedValue(NormalizedValue normalizedValue) {
        this.normalizedValue = normalizedValue;
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

    public ValueDetection withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ValueDetection.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("confidence");
        sb.append('=');
        sb.append(((this.confidence == null)?"<null>":this.confidence));
        sb.append(',');
        sb.append("normalizedValue");
        sb.append('=');
        sb.append(((this.normalizedValue == null)?"<null>":this.normalizedValue));
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
        result = ((result* 31)+((this.text == null)? 0 :this.text.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.normalizedValue == null)? 0 :this.normalizedValue.hashCode()));
        result = ((result* 31)+((this.confidence == null)? 0 :this.confidence.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ValueDetection) == false) {
            return false;
        }
        ValueDetection rhs = ((ValueDetection) other);
        return (((((this.text == rhs.text)||((this.text!= null)&&this.text.equals(rhs.text)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.normalizedValue == rhs.normalizedValue)||((this.normalizedValue!= null)&&this.normalizedValue.equals(rhs.normalizedValue))))&&((this.confidence == rhs.confidence)||((this.confidence!= null)&&this.confidence.equals(rhs.confidence))));
    }

}
