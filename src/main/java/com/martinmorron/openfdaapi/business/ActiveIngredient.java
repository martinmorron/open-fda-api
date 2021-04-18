
package com.martinmorron.openfdaapi.business;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
class ActiveIngredient {

    @JsonProperty("name")
    private String name;
    @JsonProperty("strength")
    private String strength;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    String getName() {
        return name;
    }

    @JsonProperty("name")
    void setName(String name) {
        this.name = name;
    }

    @JsonProperty("strength")
    String getStrength() {
        return strength;
    }

    @JsonProperty("strength")
    void setStrength(String strength) {
        this.strength = strength;
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
