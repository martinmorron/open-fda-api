
package com.martinmorron.openfdaapi.business;

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
@Generated("jsonschema2pojo")
class Example {

    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("meta")
    Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    void setMeta(Meta meta) {
        this.meta = meta;
    }

    @JsonProperty("results")
    List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    void setResults(List<Result> results) {
        this.results = results;
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
