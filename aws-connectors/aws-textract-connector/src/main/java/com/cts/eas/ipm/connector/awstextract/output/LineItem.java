
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
    "LineItemExpenseFields"
})
@Generated("jsonschema2pojo")
public class LineItem {

    @JsonProperty("LineItemExpenseFields")
    private List<LineItemExpenseField> lineItemExpenseFields = new ArrayList<LineItemExpenseField>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LineItemExpenseFields")
    public List<LineItemExpenseField> getLineItemExpenseFields() {
        return lineItemExpenseFields;
    }

    @JsonProperty("LineItemExpenseFields")
    public void setLineItemExpenseFields(List<LineItemExpenseField> lineItemExpenseFields) {
        this.lineItemExpenseFields = lineItemExpenseFields;
    }

    public LineItem withLineItemExpenseFields(List<LineItemExpenseField> lineItemExpenseFields) {
        this.lineItemExpenseFields = lineItemExpenseFields;
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

    public LineItem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LineItem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lineItemExpenseFields");
        sb.append('=');
        sb.append(((this.lineItemExpenseFields == null)?"<null>":this.lineItemExpenseFields));
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
        result = ((result* 31)+((this.lineItemExpenseFields == null)? 0 :this.lineItemExpenseFields.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LineItem) == false) {
            return false;
        }
        LineItem rhs = ((LineItem) other);
        return (((this.lineItemExpenseFields == rhs.lineItemExpenseFields)||((this.lineItemExpenseFields!= null)&&this.lineItemExpenseFields.equals(rhs.lineItemExpenseFields)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
