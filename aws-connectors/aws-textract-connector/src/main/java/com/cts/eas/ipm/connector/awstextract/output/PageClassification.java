
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
    "PageType",
    "PageNumber"
})
@Generated("jsonschema2pojo")
public class PageClassification {

    @JsonProperty("PageType")
    private List<PageType> pageType = new ArrayList<PageType>();
    @JsonProperty("PageNumber")
    private List<PageNumber> pageNumber = new ArrayList<PageNumber>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PageType")
    public List<PageType> getPageType() {
        return pageType;
    }

    @JsonProperty("PageType")
    public void setPageType(List<PageType> pageType) {
        this.pageType = pageType;
    }

    public PageClassification withPageType(List<PageType> pageType) {
        this.pageType = pageType;
        return this;
    }

    @JsonProperty("PageNumber")
    public List<PageNumber> getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("PageNumber")
    public void setPageNumber(List<PageNumber> pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PageClassification withPageNumber(List<PageNumber> pageNumber) {
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

    public PageClassification withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PageClassification.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pageType");
        sb.append('=');
        sb.append(((this.pageType == null)?"<null>":this.pageType));
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
        result = ((result* 31)+((this.pageType == null)? 0 :this.pageType.hashCode()));
        result = ((result* 31)+((this.pageNumber == null)? 0 :this.pageNumber.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PageClassification) == false) {
            return false;
        }
        PageClassification rhs = ((PageClassification) other);
        return ((((this.pageType == rhs.pageType)||((this.pageType!= null)&&this.pageType.equals(rhs.pageType)))&&((this.pageNumber == rhs.pageNumber)||((this.pageNumber!= null)&&this.pageNumber.equals(rhs.pageNumber))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
