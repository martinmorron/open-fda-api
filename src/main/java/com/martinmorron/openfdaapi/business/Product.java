
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
class Product {

    @JsonProperty("product_number")
    private String productNumber;
    @JsonProperty("reference_drug")
    private String referenceDrug;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("active_ingredients")
    private List<ActiveIngredient> activeIngredients = null;
    @JsonProperty("reference_standard")
    private String referenceStandard;
    @JsonProperty("dosage_form")
    private String dosageForm;
    @JsonProperty("route")
    private String route;
    @JsonProperty("marketing_status")
    private String marketingStatus;
    @JsonProperty("te_code")
    private String teCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("product_number")
    String getProductNumber() {
        return productNumber;
    }

    @JsonProperty("product_number")
    void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    @JsonProperty("reference_drug")
    String getReferenceDrug() {
        return referenceDrug;
    }

    @JsonProperty("reference_drug")
    void setReferenceDrug(String referenceDrug) {
        this.referenceDrug = referenceDrug;
    }

    @JsonProperty("brand_name")
    String getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("active_ingredients")
    List<ActiveIngredient> getActiveIngredients() {
        return activeIngredients;
    }

    @JsonProperty("active_ingredients")
    void setActiveIngredients(List<ActiveIngredient> activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    @JsonProperty("reference_standard")
    String getReferenceStandard() {
        return referenceStandard;
    }

    @JsonProperty("reference_standard")
    void setReferenceStandard(String referenceStandard) {
        this.referenceStandard = referenceStandard;
    }

    @JsonProperty("dosage_form")
    String getDosageForm() {
        return dosageForm;
    }

    @JsonProperty("dosage_form")
    void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    @JsonProperty("route")
    String getRoute() {
        return route;
    }

    @JsonProperty("route")
    void setRoute(String route) {
        this.route = route;
    }

    @JsonProperty("marketing_status")
    String getMarketingStatus() {
        return marketingStatus;
    }

    @JsonProperty("marketing_status")
    void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }

    @JsonProperty("te_code")
    String getTeCode() {
        return teCode;
    }

    @JsonProperty("te_code")
    void setTeCode(String teCode) {
        this.teCode = teCode;
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
