package com.br.peralles.jira.jiradatamanagement.rest.client;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "field",
        "fieldtype",
        "from",
        "fromString",
        "to",
        "toString",
        "fieldId"
})
public class Item {

    @JsonProperty("field")
    private String field;
    @JsonProperty("fieldtype")
    private String fieldtype;
    @JsonProperty("from")
    private Object from;
    @JsonProperty("fromString")
    private String fromString;
    @JsonProperty("to")
    private Object to;
    @JsonProperty("toString")
    private String toString;
    @JsonProperty("fieldId")
    private String fieldId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
    }

    @JsonProperty("fieldtype")
    public String getFieldtype() {
        return fieldtype;
    }

    @JsonProperty("fieldtype")
    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }

    @JsonProperty("from")
    public Object getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(Object from) {
        this.from = from;
    }

    @JsonProperty("fromString")
    public String getFromString() {
        return fromString;
    }

    @JsonProperty("fromString")
    public void setFromString(String fromString) {
        this.fromString = fromString;
    }

    @JsonProperty("to")
    public Object getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(Object to) {
        this.to = to;
    }

    @JsonProperty("toString")
    public String getToString() {
        return toString;
    }

    @JsonProperty("toString")
    public void setToString(String toString) {
        this.toString = toString;
    }

    @JsonProperty("fieldId")
    public String getFieldId() {
        return fieldId;
    }

    @JsonProperty("fieldId")
    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
