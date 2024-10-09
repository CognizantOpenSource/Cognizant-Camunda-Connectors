
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
    "Page",
    "PageClassification",
    "Extractions"
})
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("Page")
    private Integer page;
    @JsonProperty("PageClassification")
    private PageClassification pageClassification;
    @JsonProperty("Extractions")
    private List<Extraction> extractions = new ArrayList<Extraction>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("Page")
    public void setPage(Integer page) {
        this.page = page;
    }

    public Result withPage(Integer page) {
        this.page = page;
        return this;
    }

    @JsonProperty("PageClassification")
    public PageClassification getPageClassification() {
        return pageClassification;
    }

    @JsonProperty("PageClassification")
    public void setPageClassification(PageClassification pageClassification) {
        this.pageClassification = pageClassification;
    }

    public Result withPageClassification(PageClassification pageClassification) {
        this.pageClassification = pageClassification;
        return this;
    }

    @JsonProperty("Extractions")
    public List<Extraction> getExtractions() {
        return extractions;
    }

    @JsonProperty("Extractions")
    public void setExtractions(List<Extraction> extractions) {
        this.extractions = extractions;
    }

    public Result withExtractions(List<Extraction> extractions) {
        this.extractions = extractions;
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

    public Result withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
        sb.append(',');
        sb.append("pageClassification");
        sb.append('=');
        sb.append(((this.pageClassification == null)?"<null>":this.pageClassification));
        sb.append(',');
        sb.append("extractions");
        sb.append('=');
        sb.append(((this.extractions == null)?"<null>":this.extractions));
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
        result = ((result* 31)+((this.page == null)? 0 :this.page.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.extractions == null)? 0 :this.extractions.hashCode()));
        result = ((result* 31)+((this.pageClassification == null)? 0 :this.pageClassification.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return (((((this.page == rhs.page)||((this.page!= null)&&this.page.equals(rhs.page)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.extractions == rhs.extractions)||((this.extractions!= null)&&this.extractions.equals(rhs.extractions))))&&((this.pageClassification == rhs.pageClassification)||((this.pageClassification!= null)&&this.pageClassification.equals(rhs.pageClassification))));
    }

}
