
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
    "IdentityDocuments",
    "DocumentMetadata",
    "AnalyzeIDModelVersion"
})
@Generated("jsonschema2pojo")
public class AnalyzeIDResponse {

    @JsonProperty("IdentityDocuments")
    private List<IdentityDocument> identityDocuments = new ArrayList<IdentityDocument>();
    @JsonProperty("DocumentMetadata")
    private DocumentMetadata documentMetadata;
    @JsonProperty("AnalyzeIDModelVersion")
    private String analyzeIDModelVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IdentityDocuments")
    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    @JsonProperty("IdentityDocuments")
    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }

    public AnalyzeIDResponse withIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
        return this;
    }

    @JsonProperty("DocumentMetadata")
    public DocumentMetadata getDocumentMetadata() {
        return documentMetadata;
    }

    @JsonProperty("DocumentMetadata")
    public void setDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
    }

    public AnalyzeIDResponse withDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
        return this;
    }

    @JsonProperty("AnalyzeIDModelVersion")
    public String getAnalyzeIDModelVersion() {
        return analyzeIDModelVersion;
    }

    @JsonProperty("AnalyzeIDModelVersion")
    public void setAnalyzeIDModelVersion(String analyzeIDModelVersion) {
        this.analyzeIDModelVersion = analyzeIDModelVersion;
    }

    public AnalyzeIDResponse withAnalyzeIDModelVersion(String analyzeIDModelVersion) {
        this.analyzeIDModelVersion = analyzeIDModelVersion;
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

    public AnalyzeIDResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnalyzeIDResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("identityDocuments");
        sb.append('=');
        sb.append(((this.identityDocuments == null)?"<null>":this.identityDocuments));
        sb.append(',');
        sb.append("documentMetadata");
        sb.append('=');
        sb.append(((this.documentMetadata == null)?"<null>":this.documentMetadata));
        sb.append(',');
        sb.append("analyzeIDModelVersion");
        sb.append('=');
        sb.append(((this.analyzeIDModelVersion == null)?"<null>":this.analyzeIDModelVersion));
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
        result = ((result* 31)+((this.documentMetadata == null)? 0 :this.documentMetadata.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.identityDocuments == null)? 0 :this.identityDocuments.hashCode()));
        result = ((result* 31)+((this.analyzeIDModelVersion == null)? 0 :this.analyzeIDModelVersion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnalyzeIDResponse) == false) {
            return false;
        }
        AnalyzeIDResponse rhs = ((AnalyzeIDResponse) other);
        return (((((this.documentMetadata == rhs.documentMetadata)||((this.documentMetadata!= null)&&this.documentMetadata.equals(rhs.documentMetadata)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.identityDocuments == rhs.identityDocuments)||((this.identityDocuments!= null)&&this.identityDocuments.equals(rhs.identityDocuments))))&&((this.analyzeIDModelVersion == rhs.analyzeIDModelVersion)||((this.analyzeIDModelVersion!= null)&&this.analyzeIDModelVersion.equals(rhs.analyzeIDModelVersion))));
    }

}
