
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
    "LabelDetection",
    "ValueDetection",
    "PageNumber",
    "GroupProperties",
    "Currency"
})
@Generated("jsonschema2pojo")
public class SummaryField {

    @JsonProperty("Type")
    private Type type;
    @JsonProperty("LabelDetection")
    private LabelDetection labelDetection;
    @JsonProperty("ValueDetection")
    private ValueDetection valueDetection;
    @JsonProperty("PageNumber")
    private Integer pageNumber;
    @JsonProperty("GroupProperties")
    private List<GroupProperty> groupProperties = new ArrayList<GroupProperty>();
    @JsonProperty("Currency")
    private Currency currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Type")
    public Type getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(Type type) {
        this.type = type;
    }

    public SummaryField withType(Type type) {
        this.type = type;
        return this;
    }

    @JsonProperty("LabelDetection")
    public LabelDetection getLabelDetection() {
        return labelDetection;
    }

    @JsonProperty("LabelDetection")
    public void setLabelDetection(LabelDetection labelDetection) {
        this.labelDetection = labelDetection;
    }

    public SummaryField withLabelDetection(LabelDetection labelDetection) {
        this.labelDetection = labelDetection;
        return this;
    }

    @JsonProperty("ValueDetection")
    public ValueDetection getValueDetection() {
        return valueDetection;
    }

    @JsonProperty("ValueDetection")
    public void setValueDetection(ValueDetection valueDetection) {
        this.valueDetection = valueDetection;
    }

    public SummaryField withValueDetection(ValueDetection valueDetection) {
        this.valueDetection = valueDetection;
        return this;
    }

    @JsonProperty("PageNumber")
    public Integer getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("PageNumber")
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public SummaryField withPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @JsonProperty("GroupProperties")
    public List<GroupProperty> getGroupProperties() {
        return groupProperties;
    }

    @JsonProperty("GroupProperties")
    public void setGroupProperties(List<GroupProperty> groupProperties) {
        this.groupProperties = groupProperties;
    }

    public SummaryField withGroupProperties(List<GroupProperty> groupProperties) {
        this.groupProperties = groupProperties;
        return this;
    }

    @JsonProperty("Currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public SummaryField withCurrency(Currency currency) {
        this.currency = currency;
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

    public SummaryField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SummaryField.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("labelDetection");
        sb.append('=');
        sb.append(((this.labelDetection == null)?"<null>":this.labelDetection));
        sb.append(',');
        sb.append("valueDetection");
        sb.append('=');
        sb.append(((this.valueDetection == null)?"<null>":this.valueDetection));
        sb.append(',');
        sb.append("pageNumber");
        sb.append('=');
        sb.append(((this.pageNumber == null)?"<null>":this.pageNumber));
        sb.append(',');
        sb.append("groupProperties");
        sb.append('=');
        sb.append(((this.groupProperties == null)?"<null>":this.groupProperties));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
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
        result = ((result* 31)+((this.pageNumber == null)? 0 :this.pageNumber.hashCode()));
        result = ((result* 31)+((this.labelDetection == null)? 0 :this.labelDetection.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.groupProperties == null)? 0 :this.groupProperties.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.valueDetection == null)? 0 :this.valueDetection.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SummaryField) == false) {
            return false;
        }
        SummaryField rhs = ((SummaryField) other);
        return ((((((((this.pageNumber == rhs.pageNumber)||((this.pageNumber!= null)&&this.pageNumber.equals(rhs.pageNumber)))&&((this.labelDetection == rhs.labelDetection)||((this.labelDetection!= null)&&this.labelDetection.equals(rhs.labelDetection))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.groupProperties == rhs.groupProperties)||((this.groupProperties!= null)&&this.groupProperties.equals(rhs.groupProperties))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.valueDetection == rhs.valueDetection)||((this.valueDetection!= null)&&this.valueDetection.equals(rhs.valueDetection))));
    }

}
