
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
    "Index",
    "Pages"
})
@Generated("jsonschema2pojo")
public class SplitDocument {

    @JsonProperty("Index")
    private Integer index;
    @JsonProperty("Pages")
    private List<Integer> pages = new ArrayList<Integer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("Index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    public SplitDocument withIndex(Integer index) {
        this.index = index;
        return this;
    }

    @JsonProperty("Pages")
    public List<Integer> getPages() {
        return pages;
    }

    @JsonProperty("Pages")
    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public SplitDocument withPages(List<Integer> pages) {
        this.pages = pages;
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

    public SplitDocument withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SplitDocument.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("index");
        sb.append('=');
        sb.append(((this.index == null)?"<null>":this.index));
        sb.append(',');
        sb.append("pages");
        sb.append('=');
        sb.append(((this.pages == null)?"<null>":this.pages));
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
        result = ((result* 31)+((this.index == null)? 0 :this.index.hashCode()));
        result = ((result* 31)+((this.pages == null)? 0 :this.pages.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SplitDocument) == false) {
            return false;
        }
        SplitDocument rhs = ((SplitDocument) other);
        return ((((this.index == rhs.index)||((this.index!= null)&&this.index.equals(rhs.index)))&&((this.pages == rhs.pages)||((this.pages!= null)&&this.pages.equals(rhs.pages))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
