
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
    "BoundingBox",
    "Polygon"
})
@Generated("jsonschema2pojo")
public class Geometry__1 {

    @JsonProperty("BoundingBox")
    private BoundingBox__1 boundingBox;
    @JsonProperty("Polygon")
    private List<Polygon__1> polygon = new ArrayList<Polygon__1>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BoundingBox")
    public BoundingBox__1 getBoundingBox() {
        return boundingBox;
    }

    @JsonProperty("BoundingBox")
    public void setBoundingBox(BoundingBox__1 boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Geometry__1 withBoundingBox(BoundingBox__1 boundingBox) {
        this.boundingBox = boundingBox;
        return this;
    }

    @JsonProperty("Polygon")
    public List<Polygon__1> getPolygon() {
        return polygon;
    }

    @JsonProperty("Polygon")
    public void setPolygon(List<Polygon__1> polygon) {
        this.polygon = polygon;
    }

    public Geometry__1 withPolygon(List<Polygon__1> polygon) {
        this.polygon = polygon;
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

    public Geometry__1 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Geometry__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("boundingBox");
        sb.append('=');
        sb.append(((this.boundingBox == null)?"<null>":this.boundingBox));
        sb.append(',');
        sb.append("polygon");
        sb.append('=');
        sb.append(((this.polygon == null)?"<null>":this.polygon));
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
        result = ((result* 31)+((this.boundingBox == null)? 0 :this.boundingBox.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.polygon == null)? 0 :this.polygon.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Geometry__1) == false) {
            return false;
        }
        Geometry__1 rhs = ((Geometry__1) other);
        return ((((this.boundingBox == rhs.boundingBox)||((this.boundingBox!= null)&&this.boundingBox.equals(rhs.boundingBox)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.polygon == rhs.polygon)||((this.polygon!= null)&&this.polygon.equals(rhs.polygon))));
    }

}
