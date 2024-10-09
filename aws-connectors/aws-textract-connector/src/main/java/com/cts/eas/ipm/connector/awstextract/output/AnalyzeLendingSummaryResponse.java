
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
    "DocumentMetadata",
    "JobStatus",
    "Summary",
    "AnalyzeLendingModelVersion"
})
@Generated("jsonschema2pojo")
public class AnalyzeLendingSummaryResponse {

    @JsonProperty("DocumentMetadata")
    private DocumentMetadata documentMetadata;
    @JsonProperty("JobStatus")
    private String jobStatus;
    @JsonProperty("Summary")
    private Summary summary;
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

    public AnalyzeLendingSummaryResponse withDocumentMetadata(DocumentMetadata documentMetadata) {
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

    public AnalyzeLendingSummaryResponse withJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
        return this;
    }

    @JsonProperty("Summary")
    public Summary getSummary() {
        return summary;
    }

    @JsonProperty("Summary")
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public AnalyzeLendingSummaryResponse withSummary(Summary summary) {
        this.summary = summary;
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

    public AnalyzeLendingSummaryResponse withAnalyzeLendingModelVersion(String analyzeLendingModelVersion) {
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

    public AnalyzeLendingSummaryResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnalyzeLendingSummaryResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentMetadata");
        sb.append('=');
        sb.append(((this.documentMetadata == null)?"<null>":this.documentMetadata));
        sb.append(',');
        sb.append("jobStatus");
        sb.append('=');
        sb.append(((this.jobStatus == null)?"<null>":this.jobStatus));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
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
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.documentMetadata == null)? 0 :this.documentMetadata.hashCode()));
        result = ((result* 31)+((this.jobStatus == null)? 0 :this.jobStatus.hashCode()));
        result = ((result* 31)+((this.analyzeLendingModelVersion == null)? 0 :this.analyzeLendingModelVersion.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnalyzeLendingSummaryResponse) == false) {
            return false;
        }
        AnalyzeLendingSummaryResponse rhs = ((AnalyzeLendingSummaryResponse) other);
        return ((((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.documentMetadata == rhs.documentMetadata)||((this.documentMetadata!= null)&&this.documentMetadata.equals(rhs.documentMetadata))))&&((this.jobStatus == rhs.jobStatus)||((this.jobStatus!= null)&&this.jobStatus.equals(rhs.jobStatus))))&&((this.analyzeLendingModelVersion == rhs.analyzeLendingModelVersion)||((this.analyzeLendingModelVersion!= null)&&this.analyzeLendingModelVersion.equals(rhs.analyzeLendingModelVersion))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
