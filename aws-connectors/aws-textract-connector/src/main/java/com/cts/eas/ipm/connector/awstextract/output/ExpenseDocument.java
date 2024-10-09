
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
    "ExpenseIndex",
    "SummaryFields",
    "LineItemGroups",
    "Blocks"
})
@Generated("jsonschema2pojo")
public class ExpenseDocument {

    @JsonProperty("ExpenseIndex")
    private Integer expenseIndex;
    @JsonProperty("SummaryFields")
    private List<SummaryField> summaryFields = new ArrayList<SummaryField>();
    @JsonProperty("LineItemGroups")
    private List<LineItemGroup> lineItemGroups = new ArrayList<LineItemGroup>();
    @JsonProperty("Blocks")
    private List<Block> blocks = new ArrayList<Block>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ExpenseIndex")
    public Integer getExpenseIndex() {
        return expenseIndex;
    }

    @JsonProperty("ExpenseIndex")
    public void setExpenseIndex(Integer expenseIndex) {
        this.expenseIndex = expenseIndex;
    }

    public ExpenseDocument withExpenseIndex(Integer expenseIndex) {
        this.expenseIndex = expenseIndex;
        return this;
    }

    @JsonProperty("SummaryFields")
    public List<SummaryField> getSummaryFields() {
        return summaryFields;
    }

    @JsonProperty("SummaryFields")
    public void setSummaryFields(List<SummaryField> summaryFields) {
        this.summaryFields = summaryFields;
    }

    public ExpenseDocument withSummaryFields(List<SummaryField> summaryFields) {
        this.summaryFields = summaryFields;
        return this;
    }

    @JsonProperty("LineItemGroups")
    public List<LineItemGroup> getLineItemGroups() {
        return lineItemGroups;
    }

    @JsonProperty("LineItemGroups")
    public void setLineItemGroups(List<LineItemGroup> lineItemGroups) {
        this.lineItemGroups = lineItemGroups;
    }

    public ExpenseDocument withLineItemGroups(List<LineItemGroup> lineItemGroups) {
        this.lineItemGroups = lineItemGroups;
        return this;
    }

    @JsonProperty("Blocks")
    public List<Block> getBlocks() {
        return blocks;
    }

    @JsonProperty("Blocks")
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public ExpenseDocument withBlocks(List<Block> blocks) {
        this.blocks = blocks;
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

    public ExpenseDocument withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ExpenseDocument.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("expenseIndex");
        sb.append('=');
        sb.append(((this.expenseIndex == null)?"<null>":this.expenseIndex));
        sb.append(',');
        sb.append("summaryFields");
        sb.append('=');
        sb.append(((this.summaryFields == null)?"<null>":this.summaryFields));
        sb.append(',');
        sb.append("lineItemGroups");
        sb.append('=');
        sb.append(((this.lineItemGroups == null)?"<null>":this.lineItemGroups));
        sb.append(',');
        sb.append("blocks");
        sb.append('=');
        sb.append(((this.blocks == null)?"<null>":this.blocks));
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
        result = ((result* 31)+((this.expenseIndex == null)? 0 :this.expenseIndex.hashCode()));
        result = ((result* 31)+((this.lineItemGroups == null)? 0 :this.lineItemGroups.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.summaryFields == null)? 0 :this.summaryFields.hashCode()));
        result = ((result* 31)+((this.blocks == null)? 0 :this.blocks.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExpenseDocument) == false) {
            return false;
        }
        ExpenseDocument rhs = ((ExpenseDocument) other);
        return ((((((this.expenseIndex == rhs.expenseIndex)||((this.expenseIndex!= null)&&this.expenseIndex.equals(rhs.expenseIndex)))&&((this.lineItemGroups == rhs.lineItemGroups)||((this.lineItemGroups!= null)&&this.lineItemGroups.equals(rhs.lineItemGroups))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.summaryFields == rhs.summaryFields)||((this.summaryFields!= null)&&this.summaryFields.equals(rhs.summaryFields))))&&((this.blocks == rhs.blocks)||((this.blocks!= null)&&this.blocks.equals(rhs.blocks))));
    }

}
