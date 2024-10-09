
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
    "LendingFields",
    "SignatureDetections"
})
@Generated("jsonschema2pojo")
public class LendingDocument {

    @JsonProperty("LendingFields")
    private List<LendingField> lendingFields = new ArrayList<LendingField>();
    @JsonProperty("SignatureDetections")
    private List<SignatureDetection> signatureDetections = new ArrayList<SignatureDetection>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LendingFields")
    public List<LendingField> getLendingFields() {
        return lendingFields;
    }

    @JsonProperty("LendingFields")
    public void setLendingFields(List<LendingField> lendingFields) {
        this.lendingFields = lendingFields;
    }

    public LendingDocument withLendingFields(List<LendingField> lendingFields) {
        this.lendingFields = lendingFields;
        return this;
    }

    @JsonProperty("SignatureDetections")
    public List<SignatureDetection> getSignatureDetections() {
        return signatureDetections;
    }

    @JsonProperty("SignatureDetections")
    public void setSignatureDetections(List<SignatureDetection> signatureDetections) {
        this.signatureDetections = signatureDetections;
    }

    public LendingDocument withSignatureDetections(List<SignatureDetection> signatureDetections) {
        this.signatureDetections = signatureDetections;
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

    public LendingDocument withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LendingDocument.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lendingFields");
        sb.append('=');
        sb.append(((this.lendingFields == null)?"<null>":this.lendingFields));
        sb.append(',');
        sb.append("signatureDetections");
        sb.append('=');
        sb.append(((this.signatureDetections == null)?"<null>":this.signatureDetections));
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
        result = ((result* 31)+((this.lendingFields == null)? 0 :this.lendingFields.hashCode()));
        result = ((result* 31)+((this.signatureDetections == null)? 0 :this.signatureDetections.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LendingDocument) == false) {
            return false;
        }
        LendingDocument rhs = ((LendingDocument) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.lendingFields == rhs.lendingFields)||((this.lendingFields!= null)&&this.lendingFields.equals(rhs.lendingFields))))&&((this.signatureDetections == rhs.signatureDetections)||((this.signatureDetections!= null)&&this.signatureDetections.equals(rhs.signatureDetections))));
    }

}
