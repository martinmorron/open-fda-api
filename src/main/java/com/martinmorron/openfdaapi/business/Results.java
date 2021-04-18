
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
class Results {

    @JsonProperty("skip")
    private Integer skip;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("total")
    private Integer total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("skip")
    Integer getSkip() {
        return skip;
    }

    @JsonProperty("skip")
    void setSkip(Integer skip) {
        this.skip = skip;
    }

    @JsonProperty("limit")
    Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("total")
    Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    void setTotal(Integer total) {
        this.total = total;
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
