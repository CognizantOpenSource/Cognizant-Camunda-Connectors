
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
public class Geometry__2 {

    @JsonProperty("BoundingBox")
    private BoundingBox__2 boundingBox;
    @JsonProperty("Polygon")
    private List<Polygon__2> polygon = new ArrayList<Polygon__2>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BoundingBox")
    public BoundingBox__2 getBoundingBox() {
        return boundingBox;
    }

    @JsonProperty("BoundingBox")
    public void setBoundingBox(BoundingBox__2 boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Geometry__2 withBoundingBox(BoundingBox__2 boundingBox) {
        this.boundingBox = boundingBox;
        return this;
    }

    @JsonProperty("Polygon")
    public List<Polygon__2> getPolygon() {
        return polygon;
    }

    @JsonProperty("Polygon")
    public void setPolygon(List<Polygon__2> polygon) {
        this.polygon = polygon;
    }

    public Geometry__2 withPolygon(List<Polygon__2> polygon) {
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

    public Geometry__2 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Geometry__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof Geometry__2) == false) {
            return false;
        }
        Geometry__2 rhs = ((Geometry__2) other);
        return ((((this.boundingBox == rhs.boundingBox)||((this.boundingBox!= null)&&this.boundingBox.equals(rhs.boundingBox)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.polygon == rhs.polygon)||((this.polygon!= null)&&this.polygon.equals(rhs.polygon))));
    }

}
