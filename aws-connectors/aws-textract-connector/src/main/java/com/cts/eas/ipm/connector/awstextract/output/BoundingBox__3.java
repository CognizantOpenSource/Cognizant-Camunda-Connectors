
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
    "Width",
    "Height",
    "Left",
    "Top"
})
@Generated("jsonschema2pojo")
public class BoundingBox__3 {

    @JsonProperty("Width")
    private Double width;
    @JsonProperty("Height")
    private Double height;
    @JsonProperty("Left")
    private Double left;
    @JsonProperty("Top")
    private Double top;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Width")
    public Double getWidth() {
        return width;
    }

    @JsonProperty("Width")
    public void setWidth(Double width) {
        this.width = width;
    }

    public BoundingBox__3 withWidth(Double width) {
        this.width = width;
        return this;
    }

    @JsonProperty("Height")
    public Double getHeight() {
        return height;
    }

    @JsonProperty("Height")
    public void setHeight(Double height) {
        this.height = height;
    }

    public BoundingBox__3 withHeight(Double height) {
        this.height = height;
        return this;
    }

    @JsonProperty("Left")
    public Double getLeft() {
        return left;
    }

    @JsonProperty("Left")
    public void setLeft(Double left) {
        this.left = left;
    }

    public BoundingBox__3 withLeft(Double left) {
        this.left = left;
        return this;
    }

    @JsonProperty("Top")
    public Double getTop() {
        return top;
    }

    @JsonProperty("Top")
    public void setTop(Double top) {
        this.top = top;
    }

    public BoundingBox__3 withTop(Double top) {
        this.top = top;
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

    public BoundingBox__3 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BoundingBox__3 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("left");
        sb.append('=');
        sb.append(((this.left == null)?"<null>":this.left));
        sb.append(',');
        sb.append("top");
        sb.append('=');
        sb.append(((this.top == null)?"<null>":this.top));
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
        result = ((result* 31)+((this.width == null)? 0 :this.width.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.top == null)? 0 :this.top.hashCode()));
        result = ((result* 31)+((this.left == null)? 0 :this.left.hashCode()));
        result = ((result* 31)+((this.height == null)? 0 :this.height.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoundingBox__3) == false) {
            return false;
        }
        BoundingBox__3 rhs = ((BoundingBox__3) other);
        return ((((((this.width == rhs.width)||((this.width!= null)&&this.width.equals(rhs.width)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.top == rhs.top)||((this.top!= null)&&this.top.equals(rhs.top))))&&((this.left == rhs.left)||((this.left!= null)&&this.left.equals(rhs.left))))&&((this.height == rhs.height)||((this.height!= null)&&this.height.equals(rhs.height))));
    }

}
