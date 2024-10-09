
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
    "BlockType",
    "Geometry",
    "Id",
    "Relationships",
    "Confidence",
    "Text",
    "TextType",
    "EntityTypes",
    "RowIndex",
    "ColumnIndex",
    "RowSpan",
    "ColumnSpan",
    "Query"
})
@Generated("jsonschema2pojo")
public class Block {

    @JsonProperty("BlockType")
    private String blockType;
    @JsonProperty("Geometry")
    private Geometry geometry;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Relationships")
    private List<Relationship> relationships = new ArrayList<Relationship>();
    @JsonProperty("Confidence")
    private Double confidence;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("TextType")
    private String textType;
    @JsonProperty("EntityTypes")
    private List<String> entityTypes = new ArrayList<String>();
    @JsonProperty("RowIndex")
    private Integer rowIndex;
    @JsonProperty("ColumnIndex")
    private Integer columnIndex;
    @JsonProperty("RowSpan")
    private Integer rowSpan;
    @JsonProperty("ColumnSpan")
    private Integer columnSpan;
    @JsonProperty("Query")
    private Query query;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BlockType")
    public String getBlockType() {
        return blockType;
    }

    @JsonProperty("BlockType")
    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public Block withBlockType(String blockType) {
        this.blockType = blockType;
        return this;
    }

    @JsonProperty("Geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("Geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Block withGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    public Block withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("Relationships")
    public List<Relationship> getRelationships() {
        return relationships;
    }

    @JsonProperty("Relationships")
    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public Block withRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
        return this;
    }

    @JsonProperty("Confidence")
    public Double getConfidence() {
        return confidence;
    }

    @JsonProperty("Confidence")
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Block withConfidence(Double confidence) {
        this.confidence = confidence;
        return this;
    }

    @JsonProperty("Text")
    public String getText() {
        return text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        this.text = text;
    }

    public Block withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("TextType")
    public String getTextType() {
        return textType;
    }

    @JsonProperty("TextType")
    public void setTextType(String textType) {
        this.textType = textType;
    }

    public Block withTextType(String textType) {
        this.textType = textType;
        return this;
    }

    @JsonProperty("EntityTypes")
    public List<String> getEntityTypes() {
        return entityTypes;
    }

    @JsonProperty("EntityTypes")
    public void setEntityTypes(List<String> entityTypes) {
        this.entityTypes = entityTypes;
    }

    public Block withEntityTypes(List<String> entityTypes) {
        this.entityTypes = entityTypes;
        return this;
    }

    @JsonProperty("RowIndex")
    public Integer getRowIndex() {
        return rowIndex;
    }

    @JsonProperty("RowIndex")
    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Block withRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
        return this;
    }

    @JsonProperty("ColumnIndex")
    public Integer getColumnIndex() {
        return columnIndex;
    }

    @JsonProperty("ColumnIndex")
    public void setColumnIndex(Integer columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Block withColumnIndex(Integer columnIndex) {
        this.columnIndex = columnIndex;
        return this;
    }

    @JsonProperty("RowSpan")
    public Integer getRowSpan() {
        return rowSpan;
    }

    @JsonProperty("RowSpan")
    public void setRowSpan(Integer rowSpan) {
        this.rowSpan = rowSpan;
    }

    public Block withRowSpan(Integer rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    @JsonProperty("ColumnSpan")
    public Integer getColumnSpan() {
        return columnSpan;
    }

    @JsonProperty("ColumnSpan")
    public void setColumnSpan(Integer columnSpan) {
        this.columnSpan = columnSpan;
    }

    public Block withColumnSpan(Integer columnSpan) {
        this.columnSpan = columnSpan;
        return this;
    }

    @JsonProperty("Query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("Query")
    public void setQuery(Query query) {
        this.query = query;
    }

    public Block withQuery(Query query) {
        this.query = query;
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

    public Block withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Block.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("blockType");
        sb.append('=');
        sb.append(((this.blockType == null)?"<null>":this.blockType));
        sb.append(',');
        sb.append("geometry");
        sb.append('=');
        sb.append(((this.geometry == null)?"<null>":this.geometry));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("relationships");
        sb.append('=');
        sb.append(((this.relationships == null)?"<null>":this.relationships));
        sb.append(',');
        sb.append("confidence");
        sb.append('=');
        sb.append(((this.confidence == null)?"<null>":this.confidence));
        sb.append(',');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("textType");
        sb.append('=');
        sb.append(((this.textType == null)?"<null>":this.textType));
        sb.append(',');
        sb.append("entityTypes");
        sb.append('=');
        sb.append(((this.entityTypes == null)?"<null>":this.entityTypes));
        sb.append(',');
        sb.append("rowIndex");
        sb.append('=');
        sb.append(((this.rowIndex == null)?"<null>":this.rowIndex));
        sb.append(',');
        sb.append("columnIndex");
        sb.append('=');
        sb.append(((this.columnIndex == null)?"<null>":this.columnIndex));
        sb.append(',');
        sb.append("rowSpan");
        sb.append('=');
        sb.append(((this.rowSpan == null)?"<null>":this.rowSpan));
        sb.append(',');
        sb.append("columnSpan");
        sb.append('=');
        sb.append(((this.columnSpan == null)?"<null>":this.columnSpan));
        sb.append(',');
        sb.append("query");
        sb.append('=');
        sb.append(((this.query == null)?"<null>":this.query));
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
        result = ((result* 31)+((this.rowSpan == null)? 0 :this.rowSpan.hashCode()));
        result = ((result* 31)+((this.columnSpan == null)? 0 :this.columnSpan.hashCode()));
        result = ((result* 31)+((this.blockType == null)? 0 :this.blockType.hashCode()));
        result = ((result* 31)+((this.confidence == null)? 0 :this.confidence.hashCode()));
        result = ((result* 31)+((this.query == null)? 0 :this.query.hashCode()));
        result = ((result* 31)+((this.textType == null)? 0 :this.textType.hashCode()));
        result = ((result* 31)+((this.relationships == null)? 0 :this.relationships.hashCode()));
        result = ((result* 31)+((this.geometry == null)? 0 :this.geometry.hashCode()));
        result = ((result* 31)+((this.entityTypes == null)? 0 :this.entityTypes.hashCode()));
        result = ((result* 31)+((this.rowIndex == null)? 0 :this.rowIndex.hashCode()));
        result = ((result* 31)+((this.columnIndex == null)? 0 :this.columnIndex.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.text == null)? 0 :this.text.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Block) == false) {
            return false;
        }
        Block rhs = ((Block) other);
        return (((((((((((((((this.rowSpan == rhs.rowSpan)||((this.rowSpan!= null)&&this.rowSpan.equals(rhs.rowSpan)))&&((this.columnSpan == rhs.columnSpan)||((this.columnSpan!= null)&&this.columnSpan.equals(rhs.columnSpan))))&&((this.blockType == rhs.blockType)||((this.blockType!= null)&&this.blockType.equals(rhs.blockType))))&&((this.confidence == rhs.confidence)||((this.confidence!= null)&&this.confidence.equals(rhs.confidence))))&&((this.query == rhs.query)||((this.query!= null)&&this.query.equals(rhs.query))))&&((this.textType == rhs.textType)||((this.textType!= null)&&this.textType.equals(rhs.textType))))&&((this.relationships == rhs.relationships)||((this.relationships!= null)&&this.relationships.equals(rhs.relationships))))&&((this.geometry == rhs.geometry)||((this.geometry!= null)&&this.geometry.equals(rhs.geometry))))&&((this.entityTypes == rhs.entityTypes)||((this.entityTypes!= null)&&this.entityTypes.equals(rhs.entityTypes))))&&((this.rowIndex == rhs.rowIndex)||((this.rowIndex!= null)&&this.rowIndex.equals(rhs.rowIndex))))&&((this.columnIndex == rhs.columnIndex)||((this.columnIndex!= null)&&this.columnIndex.equals(rhs.columnIndex))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.text == rhs.text)||((this.text!= null)&&this.text.equals(rhs.text))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
