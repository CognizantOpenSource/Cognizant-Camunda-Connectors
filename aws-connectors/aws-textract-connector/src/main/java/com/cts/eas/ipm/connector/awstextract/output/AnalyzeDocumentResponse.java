
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
    "DocumentMetadata",
    "Blocks",
    "AnalyzeDocumentModelVersion"
})
@Generated("jsonschema2pojo")
public class AnalyzeDocumentResponse {

    @JsonProperty("DocumentMetadata")
    private DocumentMetadata documentMetadata;
    @JsonProperty("Blocks")
    private List<Block> blocks = new ArrayList<Block>();
    @JsonProperty("AnalyzeDocumentModelVersion")
    private String analyzeDocumentModelVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DocumentMetadata")
    public DocumentMetadata getDocumentMetadata() {
        return documentMetadata;
    }

    @JsonProperty("DocumentMetadata")
    public void setDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
    }

    public AnalyzeDocumentResponse withDocumentMetadata(DocumentMetadata documentMetadata) {
        this.documentMetadata = documentMetadata;
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

    public AnalyzeDocumentResponse withBlocks(List<Block> blocks) {
        this.blocks = blocks;
        return this;
    }

    @JsonProperty("AnalyzeDocumentModelVersion")
    public String getAnalyzeDocumentModelVersion() {
        return analyzeDocumentModelVersion;
    }

    @JsonProperty("AnalyzeDocumentModelVersion")
    public void setAnalyzeDocumentModelVersion(String analyzeDocumentModelVersion) {
        this.analyzeDocumentModelVersion = analyzeDocumentModelVersion;
    }

    public AnalyzeDocumentResponse withAnalyzeDocumentModelVersion(String analyzeDocumentModelVersion) {
        this.analyzeDocumentModelVersion = analyzeDocumentModelVersion;
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

    public AnalyzeDocumentResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnalyzeDocumentResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("documentMetadata");
        sb.append('=');
        sb.append(((this.documentMetadata == null)?"<null>":this.documentMetadata));
        sb.append(',');
        sb.append("blocks");
        sb.append('=');
        sb.append(((this.blocks == null)?"<null>":this.blocks));
        sb.append(',');
        sb.append("analyzeDocumentModelVersion");
        sb.append('=');
        sb.append(((this.analyzeDocumentModelVersion == null)?"<null>":this.analyzeDocumentModelVersion));
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
        result = ((result* 31)+((this.documentMetadata == null)? 0 :this.documentMetadata.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.analyzeDocumentModelVersion == null)? 0 :this.analyzeDocumentModelVersion.hashCode()));
        result = ((result* 31)+((this.blocks == null)? 0 :this.blocks.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnalyzeDocumentResponse) == false) {
            return false;
        }
        AnalyzeDocumentResponse rhs = ((AnalyzeDocumentResponse) other);
        return (((((this.documentMetadata == rhs.documentMetadata)||((this.documentMetadata!= null)&&this.documentMetadata.equals(rhs.documentMetadata)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.analyzeDocumentModelVersion == rhs.analyzeDocumentModelVersion)||((this.analyzeDocumentModelVersion!= null)&&this.analyzeDocumentModelVersion.equals(rhs.analyzeDocumentModelVersion))))&&((this.blocks == rhs.blocks)||((this.blocks!= null)&&this.blocks.equals(rhs.blocks))));
    }

}
