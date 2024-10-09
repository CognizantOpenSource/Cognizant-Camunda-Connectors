
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
    "X",
    "Y"
})
@Generated("jsonschema2pojo")
public class Polygon__3 {

    @JsonProperty("X")
    private Double x;
    @JsonProperty("Y")
    private Double y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("X")
    public Double getX() {
        return x;
    }

    @JsonProperty("X")
    public void setX(Double x) {
        this.x = x;
    }

    public Polygon__3 withX(Double x) {
        this.x = x;
        return this;
    }

    @JsonProperty("Y")
    public Double getY() {
        return y;
    }

    @JsonProperty("Y")
    public void setY(Double y) {
        this.y = y;
    }

    public Polygon__3 withY(Double y) {
        this.y = y;
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

    public Polygon__3 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Polygon__3 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("x");
        sb.append('=');
        sb.append(((this.x == null)?"<null>":this.x));
        sb.append(',');
        sb.append("y");
        sb.append('=');
        sb.append(((this.y == null)?"<null>":this.y));
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
        result = ((result* 31)+((this.x == null)? 0 :this.x.hashCode()));
        result = ((result* 31)+((this.y == null)? 0 :this.y.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Polygon__3) == false) {
            return false;
        }
        Polygon__3 rhs = ((Polygon__3) other);
        return ((((this.x == rhs.x)||((this.x!= null)&&this.x.equals(rhs.x)))&&((this.y == rhs.y)||((this.y!= null)&&this.y.equals(rhs.y))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
