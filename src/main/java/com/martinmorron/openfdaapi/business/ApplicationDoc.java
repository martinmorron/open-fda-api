
package com.martinmorron.openfdaapi.business;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
class ApplicationDoc {

    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("date")
    private String date;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    String getId() {
        return id;
    }

    @JsonProperty("id")
    void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    String getUrl() {
        return url;
    }

    @JsonProperty("url")
    void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("date")
    String getDate() {
        return date;
    }

    @JsonProperty("date")
    void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("type")
    String getType() {
        return type;
    }

    @JsonProperty("type")
    void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
