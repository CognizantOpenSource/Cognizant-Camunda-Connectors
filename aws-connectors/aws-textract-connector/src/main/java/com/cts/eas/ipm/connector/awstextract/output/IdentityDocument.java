
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
    "DocumentIndex",
    "IdentityDocumentFields",
    "Blocks"
})
@Generated("jsonschema2pojo")
public class IdentityDocument {

    @JsonProperty("DocumentIndex")
    private Integer documentIndex;
    @JsonProperty("IdentityDocumentFields")
    private List<IdentityDocumentField> identityDocumentFields = new ArrayList<IdentityDocumentField>();
    @JsonProperty("Blocks")
    private List<Block> blocks = new ArrayList<Block>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DocumentIndex")
    public Integer getDocumentIndex() {
        return documentIndex;
    }

    @JsonProperty("DocumentIndex")
    public void setDocumentIndex(Integer documentIndex) {
        this.documentIndex = documentIndex;
    }

    public IdentityDocument withDocumentIndex(Integer documentIndex) {
        this.documentIndex = documentIndex;
        return this;
    }

    @JsonProperty("IdentityDocumentFields")
    public List<IdentityDocumentField> getIdentityDocumentFields() {
        return identityDocumentFields;
    }

    @JsonProperty("IdentityDocumentFields")
    public void setIdentityDocumentFields(List<IdentityDocumentField> identityDocumentFields) {
        this.identityDocumentFields = identityDocumentFields;
    }

    public IdentityDocument withIdentityDocumentFields(List<IdentityDocumentField> identityDocumentFields) {
        this.identityDocumentFields = identityDocumentFields;
        return this;
    }

    @JsonProperty("Blocks")
    public List<Block> getBlocks() {
        return blocks;
    }

    @JsonProperty("Blocks")
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public IdentityDocument withBlocks(List<Block> blocks) {
        this.blocks = blocks;
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

    public IdentityDocument withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IdentityDocument.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentIndex");
        sb.append('=');
        sb.append(((this.documentIndex == null)?"<null>":this.documentIndex));
        sb.append(',');
        sb.append("identityDocumentFields");
        sb.append('=');
        sb.append(((this.identityDocumentFields == null)?"<null>":this.identityDocumentFields));
        sb.append(',');
        sb.append("blocks");
        sb.append('=');
        sb.append(((this.blocks == null)?"<null>":this.blocks));
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
        result = ((result* 31)+((this.identityDocumentFields == null)? 0 :this.identityDocumentFields.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.blocks == null)? 0 :this.blocks.hashCode()));
        result = ((result* 31)+((this.documentIndex == null)? 0 :this.documentIndex.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdentityDocument) == false) {
            return false;
        }
        IdentityDocument rhs = ((IdentityDocument) other);
        return (((((this.identityDocumentFields == rhs.identityDocumentFields)||((this.identityDocumentFields!= null)&&this.identityDocumentFields.equals(rhs.identityDocumentFields)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.blocks == rhs.blocks)||((this.blocks!= null)&&this.blocks.equals(rhs.blocks))))&&((this.documentIndex == rhs.documentIndex)||((this.documentIndex!= null)&&this.documentIndex.equals(rhs.documentIndex))));
    }

}
