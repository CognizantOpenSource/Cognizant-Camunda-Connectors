
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
    "DocumentMetadata",
    "JobStatus",
    "Results",
    "AnalyzeLendingModelVersion"
})
@Generated("jsonschema2pojo")
public class AnalyzeLendingResponse {

    @JsonProperty("DocumentMetadata")
    private DocumentMetadata documentMetadata;
    @JsonProperty("JobStatus")
    private String jobStatus;
    @JsonProperty("Results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("AnalyzeLendingModelVersion")
    private String analyzeLendingModelVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DocumentMetadata")
    public DocumentMetadata getDocumentMetadata() {
        return documentMetadata;
    }

    @JsonProperty("DocumentMetadata")
    public void setDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
    }

    public AnalyzeLendingResponse withDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
        return this;
    }

    @JsonProperty("JobStatus")
    public String getJobStatus() {
        return jobStatus;
    }

    @JsonProperty("JobStatus")
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public AnalyzeLendingResponse withJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
        return this;
    }

    @JsonProperty("Results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("Results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public AnalyzeLendingResponse withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    @JsonProperty("AnalyzeLendingModelVersion")
    public String getAnalyzeLendingModelVersion() {
        return analyzeLendingModelVersion;
    }

    @JsonProperty("AnalyzeLendingModelVersion")
    public void setAnalyzeLendingModelVersion(String analyzeLendingModelVersion) {
        this.analyzeLendingModelVersion = analyzeLendingModelVersion;
    }

    public AnalyzeLendingResponse withAnalyzeLendingModelVersion(String analyzeLendingModelVersion) {
        this.analyzeLendingModelVersion = analyzeLendingModelVersion;
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

    public AnalyzeLendingResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnalyzeLendingResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentMetadata");
        sb.append('=');
        sb.append(((this.documentMetadata == null)?"<null>":this.documentMetadata));
        sb.append(',');
        sb.append("jobStatus");
        sb.append('=');
        sb.append(((this.jobStatus == null)?"<null>":this.jobStatus));
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        sb.append("analyzeLendingModelVersion");
        sb.append('=');
        sb.append(((this.analyzeLendingModelVersion == null)?"<null>":this.analyzeLendingModelVersion));
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
        result = ((result* 31)+((this.jobStatus == null)? 0 :this.jobStatus.hashCode()));
        result = ((result* 31)+((this.analyzeLendingModelVersion == null)? 0 :this.analyzeLendingModelVersion.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.results == null)? 0 :this.results.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnalyzeLendingResponse) == false) {
            return false;
        }
        AnalyzeLendingResponse rhs = ((AnalyzeLendingResponse) other);
        return ((((((this.documentMetadata == rhs.documentMetadata)||((this.documentMetadata!= null)&&this.documentMetadata.equals(rhs.documentMetadata)))&&((this.jobStatus == rhs.jobStatus)||((this.jobStatus!= null)&&this.jobStatus.equals(rhs.jobStatus))))&&((this.analyzeLendingModelVersion == rhs.analyzeLendingModelVersion)||((this.analyzeLendingModelVersion!= null)&&this.analyzeLendingModelVersion.equals(rhs.analyzeLendingModelVersion))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.results == rhs.results)||((this.results!= null)&&this.results.equals(rhs.results))));
    }

}
