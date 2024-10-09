
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
    "SplitDocuments",
    "DetectedSignatures",
    "UndetectedSignatures"
})
@Generated("jsonschema2pojo")
public class DocumentGroup {

    @JsonProperty("Type")
    private String type;
    @JsonProperty("SplitDocuments")
    private List<SplitDocument> splitDocuments = new ArrayList<SplitDocument>();
    @JsonProperty("DetectedSignatures")
    private List<DetectedSignature> detectedSignatures = new ArrayList<DetectedSignature>();
    @JsonProperty("UndetectedSignatures")
    private List<Object> undetectedSignatures = new ArrayList<Object>();
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

    public DocumentGroup withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("SplitDocuments")
    public List<SplitDocument> getSplitDocuments() {
        return splitDocuments;
    }

    @JsonProperty("SplitDocuments")
    public void setSplitDocuments(List<SplitDocument> splitDocuments) {
        this.splitDocuments = splitDocuments;
    }

    public DocumentGroup withSplitDocuments(List<SplitDocument> splitDocuments) {
        this.splitDocuments = splitDocuments;
        return this;
    }

    @JsonProperty("DetectedSignatures")
    public List<DetectedSignature> getDetectedSignatures() {
        return detectedSignatures;
    }

    @JsonProperty("DetectedSignatures")
    public void setDetectedSignatures(List<DetectedSignature> detectedSignatures) {
        this.detectedSignatures = detectedSignatures;
    }

    public DocumentGroup withDetectedSignatures(List<DetectedSignature> detectedSignatures) {
        this.detectedSignatures = detectedSignatures;
        return this;
    }

    @JsonProperty("UndetectedSignatures")
    public List<Object> getUndetectedSignatures() {
        return undetectedSignatures;
    }

    @JsonProperty("UndetectedSignatures")
    public void setUndetectedSignatures(List<Object> undetectedSignatures) {
        this.undetectedSignatures = undetectedSignatures;
    }

    public DocumentGroup withUndetectedSignatures(List<Object> undetectedSignatures) {
        this.undetectedSignatures = undetectedSignatures;
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

    public DocumentGroup withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("splitDocuments");
        sb.append('=');
        sb.append(((this.splitDocuments == null)?"<null>":this.splitDocuments));
        sb.append(',');
        sb.append("detectedSignatures");
        sb.append('=');
        sb.append(((this.detectedSignatures == null)?"<null>":this.detectedSignatures));
        sb.append(',');
        sb.append("undetectedSignatures");
        sb.append('=');
        sb.append(((this.undetectedSignatures == null)?"<null>":this.undetectedSignatures));
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
        result = ((result* 31)+((this.undetectedSignatures == null)? 0 :this.undetectedSignatures.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.splitDocuments == null)? 0 :this.splitDocuments.hashCode()));
        result = ((result* 31)+((this.detectedSignatures == null)? 0 :this.detectedSignatures.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentGroup) == false) {
            return false;
        }
        DocumentGroup rhs = ((DocumentGroup) other);
        return ((((((this.undetectedSignatures == rhs.undetectedSignatures)||((this.undetectedSignatures!= null)&&this.undetectedSignatures.equals(rhs.undetectedSignatures)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.splitDocuments == rhs.splitDocuments)||((this.splitDocuments!= null)&&this.splitDocuments.equals(rhs.splitDocuments))))&&((this.detectedSignatures == rhs.detectedSignatures)||((this.detectedSignatures!= null)&&this.detectedSignatures.equals(rhs.detectedSignatures))));
    }

}
