
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
class Meta {

    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("terms")
    private String terms;
    @JsonProperty("license")
    private String license;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("results")
    private Results results;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("disclaimer")
    String getDisclaimer() {
        return disclaimer;
    }

    @JsonProperty("disclaimer")
    void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @JsonProperty("terms")
    String getTerms() {
        return terms;
    }

    @JsonProperty("terms")
    void setTerms(String terms) {
        this.terms = terms;
    }

    @JsonProperty("license")
    String getLicense() {
        return license;
    }

    @JsonProperty("license")
    void setLicense(String license) {
        this.license = license;
    }

    @JsonProperty("last_updated")
    String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("results")
    Results getResults() {
        return results;
    }

    @JsonProperty("results")
    void setResults(Results results) {
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
