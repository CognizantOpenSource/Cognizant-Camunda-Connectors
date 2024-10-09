
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
    "DocumentGroups",
    "UndetectedDocumentTypes"
})
@Generated("jsonschema2pojo")
public class Summary {

    @JsonProperty("DocumentGroups")
    private List<DocumentGroup> documentGroups = new ArrayList<DocumentGroup>();
    @JsonProperty("UndetectedDocumentTypes")
    private List<String> undetectedDocumentTypes = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DocumentGroups")
    public List<DocumentGroup> getDocumentGroups() {
        return documentGroups;
    }

    @JsonProperty("DocumentGroups")
    public void setDocumentGroups(List<DocumentGroup> documentGroups) {
        this.documentGroups = documentGroups;
    }

    public Summary withDocumentGroups(List<DocumentGroup> documentGroups) {
        this.documentGroups = documentGroups;
        return this;
    }

    @JsonProperty("UndetectedDocumentTypes")
    public List<String> getUndetectedDocumentTypes() {
        return undetectedDocumentTypes;
    }

    @JsonProperty("UndetectedDocumentTypes")
    public void setUndetectedDocumentTypes(List<String> undetectedDocumentTypes) {
        this.undetectedDocumentTypes = undetectedDocumentTypes;
    }

    public Summary withUndetectedDocumentTypes(List<String> undetectedDocumentTypes) {
        this.undetectedDocumentTypes = undetectedDocumentTypes;
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

    public Summary withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Summary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentGroups");
        sb.append('=');
        sb.append(((this.documentGroups == null)?"<null>":this.documentGroups));
        sb.append(',');
        sb.append("undetectedDocumentTypes");
        sb.append('=');
        sb.append(((this.undetectedDocumentTypes == null)?"<null>":this.undetectedDocumentTypes));
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
        result = ((result* 31)+((this.documentGroups == null)? 0 :this.documentGroups.hashCode()));
        result = ((result* 31)+((this.undetectedDocumentTypes == null)? 0 :this.undetectedDocumentTypes.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Summary) == false) {
            return false;
        }
        Summary rhs = ((Summary) other);
        return ((((this.documentGroups == rhs.documentGroups)||((this.documentGroups!= null)&&this.documentGroups.equals(rhs.documentGroups)))&&((this.undetectedDocumentTypes == rhs.undetectedDocumentTypes)||((this.undetectedDocumentTypes!= null)&&this.undetectedDocumentTypes.equals(rhs.undetectedDocumentTypes))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
