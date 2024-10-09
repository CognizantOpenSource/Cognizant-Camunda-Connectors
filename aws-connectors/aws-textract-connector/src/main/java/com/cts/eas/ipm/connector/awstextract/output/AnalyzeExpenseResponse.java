
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
    "ExpenseDocuments"
})
@Generated("jsonschema2pojo")
public class AnalyzeExpenseResponse {

    @JsonProperty("DocumentMetadata")
    private DocumentMetadata documentMetadata;
    @JsonProperty("ExpenseDocuments")
    private List<ExpenseDocument> expenseDocuments = new ArrayList<ExpenseDocument>();
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

    public AnalyzeExpenseResponse withDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
        return this;
    }

    @JsonProperty("ExpenseDocuments")
    public List<ExpenseDocument> getExpenseDocuments() {
        return expenseDocuments;
    }

    @JsonProperty("ExpenseDocuments")
    public void setExpenseDocuments(List<ExpenseDocument> expenseDocuments) {
        this.expenseDocuments = expenseDocuments;
    }

    public AnalyzeExpenseResponse withExpenseDocuments(List<ExpenseDocument> expenseDocuments) {
        this.expenseDocuments = expenseDocuments;
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

    public AnalyzeExpenseResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnalyzeExpenseResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentMetadata");
        sb.append('=');
        sb.append(((this.documentMetadata == null)?"<null>":this.documentMetadata));
        sb.append(',');
        sb.append("expenseDocuments");
        sb.append('=');
        sb.append(((this.expenseDocuments == null)?"<null>":this.expenseDocuments));
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
        result = ((result* 31)+((this.expenseDocuments == null)? 0 :this.expenseDocuments.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnalyzeExpenseResponse) == false) {
            return false;
        }
        AnalyzeExpenseResponse rhs = ((AnalyzeExpenseResponse) other);
        return ((((this.documentMetadata == rhs.documentMetadata)||((this.documentMetadata!= null)&&this.documentMetadata.equals(rhs.documentMetadata)))&&((this.expenseDocuments == rhs.expenseDocuments)||((this.expenseDocuments!= null)&&this.expenseDocuments.equals(rhs.expenseDocuments))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
