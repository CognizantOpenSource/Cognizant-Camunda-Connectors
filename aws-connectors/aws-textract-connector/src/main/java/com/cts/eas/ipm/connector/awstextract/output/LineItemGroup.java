
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
    "LineItemGroupIndex",
    "LineItems"
})
@Generated("jsonschema2pojo")
public class LineItemGroup {

    @JsonProperty("LineItemGroupIndex")
    private Integer lineItemGroupIndex;
    @JsonProperty("LineItems")
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LineItemGroupIndex")
    public Integer getLineItemGroupIndex() {
        return lineItemGroupIndex;
    }

    @JsonProperty("LineItemGroupIndex")
    public void setLineItemGroupIndex(Integer lineItemGroupIndex) {
        this.lineItemGroupIndex = lineItemGroupIndex;
    }

    public LineItemGroup withLineItemGroupIndex(Integer lineItemGroupIndex) {
        this.lineItemGroupIndex = lineItemGroupIndex;
        return this;
    }

    @JsonProperty("LineItems")
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    @JsonProperty("LineItems")
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public LineItemGroup withLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
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

    public LineItemGroup withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LineItemGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lineItemGroupIndex");
        sb.append('=');
        sb.append(((this.lineItemGroupIndex == null)?"<null>":this.lineItemGroupIndex));
        sb.append(',');
        sb.append("lineItems");
        sb.append('=');
        sb.append(((this.lineItems == null)?"<null>":this.lineItems));
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
        result = ((result* 31)+((this.lineItems == null)? 0 :this.lineItems.hashCode()));
        result = ((result* 31)+((this.lineItemGroupIndex == null)? 0 :this.lineItemGroupIndex.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LineItemGroup) == false) {
            return false;
        }
        LineItemGroup rhs = ((LineItemGroup) other);
        return ((((this.lineItems == rhs.lineItems)||((this.lineItems!= null)&&this.lineItems.equals(rhs.lineItems)))&&((this.lineItemGroupIndex == rhs.lineItemGroupIndex)||((this.lineItemGroupIndex!= null)&&this.lineItemGroupIndex.equals(rhs.lineItemGroupIndex))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
