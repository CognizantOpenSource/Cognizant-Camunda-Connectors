
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
    "LendingDocument",
    "IdentityDocument"
})
@Generated("jsonschema2pojo")
public class Extraction {

    @JsonProperty("LendingDocument")
    private LendingDocument lendingDocument;
    @JsonProperty("IdentityDocument")
    private IdentityDocument identityDocument;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LendingDocument")
    public LendingDocument getLendingDocument() {
        return lendingDocument;
    }

    @JsonProperty("LendingDocument")
    public void setLendingDocument(LendingDocument lendingDocument) {
        this.lendingDocument = lendingDocument;
    }

    public Extraction withLendingDocument(LendingDocument lendingDocument) {
        this.lendingDocument = lendingDocument;
        return this;
    }

    @JsonProperty("IdentityDocument")
    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    @JsonProperty("IdentityDocument")
    public void setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }

    public Extraction withIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
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

    public Extraction withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Extraction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lendingDocument");
        sb.append('=');
        sb.append(((this.lendingDocument == null)?"<null>":this.lendingDocument));
        sb.append(',');
        sb.append("identityDocument");
        sb.append('=');
        sb.append(((this.identityDocument == null)?"<null>":this.identityDocument));
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
        result = ((result* 31)+((this.lendingDocument == null)? 0 :this.lendingDocument.hashCode()));
        result = ((result* 31)+((this.identityDocument == null)? 0 :this.identityDocument.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Extraction) == false) {
            return false;
        }
        Extraction rhs = ((Extraction) other);
        return ((((this.lendingDocument == rhs.lendingDocument)||((this.lendingDocument!= null)&&this.lendingDocument.equals(rhs.lendingDocument)))&&((this.identityDocument == rhs.identityDocument)||((this.identityDocument!= null)&&this.identityDocument.equals(rhs.identityDocument))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
