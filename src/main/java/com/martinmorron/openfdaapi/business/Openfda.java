
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
class Openfda {

    @JsonProperty("application_number")
    private List<String> applicationNumber = null;
    @JsonProperty("brand_name")
    private List<String> brandName = null;
    @JsonProperty("generic_name")
    private List<String> genericName = null;
    @JsonProperty("manufacturer_name")
    private List<String> manufacturerName = null;
    @JsonProperty("product_ndc")
    private List<String> productNdc = null;
    @JsonProperty("product_type")
    private List<String> productType = null;
    @JsonProperty("route")
    private List<String> route = null;
    @JsonProperty("substance_name")
    private List<String> substanceName = null;
    @JsonProperty("rxcui")
    private List<String> rxcui = null;
    @JsonProperty("spl_id")
    private List<String> splId = null;
    @JsonProperty("spl_set_id")
    private List<String> splSetId = null;
    @JsonProperty("package_ndc")
    private List<String> packageNdc = null;
    @JsonProperty("nui")
    private List<String> nui = null;
    @JsonProperty("pharm_class_epc")
    private List<String> pharmClassEpc = null;
    @JsonProperty("pharm_class_moa")
    private List<String> pharmClassMoa = null;
    @JsonProperty("pharm_class_cs")
    private List<String> pharmClassCs = null;
    @JsonProperty("unii")
    private List<String> unii = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("application_number")
    List<String> getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("application_number")
    void setApplicationNumber(List<String> applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    @JsonProperty("brand_name")
    List<String> getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("generic_name")
    List<String> getGenericName() {
        return genericName;
    }

    @JsonProperty("generic_name")
    void setGenericName(List<String> genericName) {
        this.genericName = genericName;
    }

    @JsonProperty("manufacturer_name")
    List<String> getManufacturerName() {
        return manufacturerName;
    }

    @JsonProperty("manufacturer_name")
    void setManufacturerName(List<String> manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @JsonProperty("product_ndc")
    List<String> getProductNdc() {
        return productNdc;
    }

    @JsonProperty("product_ndc")
    void setProductNdc(List<String> productNdc) {
        this.productNdc = productNdc;
    }

    @JsonProperty("product_type")
    List<String> getProductType() {
        return productType;
    }

    @JsonProperty("product_type")
    void setProductType(List<String> productType) {
        this.productType = productType;
    }

    @JsonProperty("route")
    List<String> getRoute() {
        return route;
    }

    @JsonProperty("route")
    void setRoute(List<String> route) {
        this.route = route;
    }

    @JsonProperty("substance_name")
    List<String> getSubstanceName() {
        return substanceName;
    }

    @JsonProperty("substance_name")
    void setSubstanceName(List<String> substanceName) {
        this.substanceName = substanceName;
    }

    @JsonProperty("rxcui")
    List<String> getRxcui() {
        return rxcui;
    }

    @JsonProperty("rxcui")
    void setRxcui(List<String> rxcui) {
        this.rxcui = rxcui;
    }

    @JsonProperty("spl_id")
    List<String> getSplId() {
        return splId;
    }

    @JsonProperty("spl_id")
    void setSplId(List<String> splId) {
        this.splId = splId;
    }

    @JsonProperty("spl_set_id")
    List<String> getSplSetId() {
        return splSetId;
    }

    @JsonProperty("spl_set_id")
    void setSplSetId(List<String> splSetId) {
        this.splSetId = splSetId;
    }

    @JsonProperty("package_ndc")
    List<String> getPackageNdc() {
        return packageNdc;
    }

    @JsonProperty("package_ndc")
    void setPackageNdc(List<String> packageNdc) {
        this.packageNdc = packageNdc;
    }

    @JsonProperty("nui")
    List<String> getNui() {
        return nui;
    }

    @JsonProperty("nui")
    void setNui(List<String> nui) {
        this.nui = nui;
    }

    @JsonProperty("pharm_class_epc")
    List<String> getPharmClassEpc() {
        return pharmClassEpc;
    }

    @JsonProperty("pharm_class_epc")
    void setPharmClassEpc(List<String> pharmClassEpc) {
        this.pharmClassEpc = pharmClassEpc;
    }

    @JsonProperty("pharm_class_moa")
    List<String> getPharmClassMoa() {
        return pharmClassMoa;
    }

    @JsonProperty("pharm_class_moa")
    void setPharmClassMoa(List<String> pharmClassMoa) {
        this.pharmClassMoa = pharmClassMoa;
    }

    @JsonProperty("pharm_class_cs")
    List<String> getPharmClassCs() {
        return pharmClassCs;
    }

    @JsonProperty("pharm_class_cs")
    void setPharmClassCs(List<String> pharmClassCs) {
        this.pharmClassCs = pharmClassCs;
    }

    @JsonProperty("unii")
    List<String> getUnii() {
        return unii;
    }

    @JsonProperty("unii")
    void setUnii(List<String> unii) {
        this.unii = unii;
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
