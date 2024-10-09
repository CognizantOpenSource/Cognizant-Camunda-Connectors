
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
    "Type",
    "LabelDetection",
    "ValueDetection",
    "PageNumber"
})
@Generated("jsonschema2pojo")
public class LineItemExpenseField {

    @JsonProperty("Type")
    private Type__1 type;
    @JsonProperty("LabelDetection")
    private LabelDetection__1 labelDetection;
    @JsonProperty("ValueDetection")
    private ValueDetection__1 valueDetection;
    @JsonProperty("PageNumber")
    private Integer pageNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Type")
    public Type__1 getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(Type__1 type) {
        this.type = type;
    }

    public LineItemExpenseField withType(Type__1 type) {
        this.type = type;
        return this;
    }

    @JsonProperty("LabelDetection")
    public LabelDetection__1 getLabelDetection() {
        return labelDetection;
    }

    @JsonProperty("LabelDetection")
    public void setLabelDetection(LabelDetection__1 labelDetection) {
        this.labelDetection = labelDetection;
    }

    public LineItemExpenseField withLabelDetection(LabelDetection__1 labelDetection) {
        this.labelDetection = labelDetection;
        return this;
    }

    @JsonProperty("ValueDetection")
    public ValueDetection__1 getValueDetection() {
        return valueDetection;
    }

    @JsonProperty("ValueDetection")
    public void setValueDetection(ValueDetection__1 valueDetection) {
        this.valueDetection = valueDetection;
    }

    public LineItemExpenseField withValueDetection(ValueDetection__1 valueDetection) {
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

    public LineItemExpenseField withPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
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

    public LineItemExpenseField withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LineItemExpenseField.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.labelDetection == null)? 0 :this.labelDetection.hashCode()));
        result = ((result* 31)+((this.valueDetection == null)? 0 :this.valueDetection.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LineItemExpenseField) == false) {
            return false;
        }
        LineItemExpenseField rhs = ((LineItemExpenseField) other);
        return ((((((this.pageNumber == rhs.pageNumber)||((this.pageNumber!= null)&&this.pageNumber.equals(rhs.pageNumber)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.labelDetection == rhs.labelDetection)||((this.labelDetection!= null)&&this.labelDetection.equals(rhs.labelDetection))))&&((this.valueDetection == rhs.valueDetection)||((this.valueDetection!= null)&&this.valueDetection.equals(rhs.valueDetection))));
    }

}
