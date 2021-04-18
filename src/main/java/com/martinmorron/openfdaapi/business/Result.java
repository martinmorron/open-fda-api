
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("submissions")
    private List<Submission> submissions = null;
    @JsonProperty("application_number")
    private String applicationNumber;
    @JsonProperty("sponsor_name")
    private String sponsorName;
    @JsonProperty("openfda")
    private Openfda openfda;
    @JsonProperty("products")
    private List<Product> products = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("submissions")
    List<Submission> getSubmissions() {
        return submissions;
    }

    @JsonProperty("submissions")
    void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    @JsonProperty("application_number")
    String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("application_number")
    void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    @JsonProperty("sponsor_name")
    String getSponsorName() {
        return sponsorName;
    }

    @JsonProperty("sponsor_name")
    void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    @JsonProperty("openfda")
    Openfda getOpenfda() {
        return openfda;
    }

    @JsonProperty("openfda")
    void setOpenfda(Openfda openfda) {
        this.openfda = openfda;
    }

    @JsonProperty("products")
    List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    void setProducts(List<Product> products) {
        this.products = products;
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
