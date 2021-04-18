
package com.martinmorron.openfdaapi.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
class Submission {

    @JsonProperty("submission_type")
    private String submissionType;
    @JsonProperty("submission_number")
    private String submissionNumber;
    @JsonProperty("submission_status")
    private String submissionStatus;
    @JsonProperty("submission_status_date")
    private String submissionStatusDate;
    @JsonProperty("review_priority")
    private String reviewPriority;
    @JsonProperty("submission_class_code")
    private String submissionClassCode;
    @JsonProperty("submission_class_code_description")
    private String submissionClassCodeDescription;
    @JsonProperty("application_docs")
    private List<ApplicationDoc> applicationDocs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("submission_type")
    String getSubmissionType() {
        return submissionType;
    }

    @JsonProperty("submission_type")
    void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    @JsonProperty("submission_number")
    String getSubmissionNumber() {
        return submissionNumber;
    }

    @JsonProperty("submission_number")
    void setSubmissionNumber(String submissionNumber) {
        this.submissionNumber = submissionNumber;
    }

    @JsonProperty("submission_status")
    String getSubmissionStatus() {
        return submissionStatus;
    }

    @JsonProperty("submission_status")
    void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    @JsonProperty("submission_status_date")
    String getSubmissionStatusDate() {
        return submissionStatusDate;
    }

    @JsonProperty("submission_status_date")
    void setSubmissionStatusDate(String submissionStatusDate) {
        this.submissionStatusDate = submissionStatusDate;
    }

    @JsonProperty("review_priority")
    String getReviewPriority() {
        return reviewPriority;
    }

    @JsonProperty("review_priority")
    void setReviewPriority(String reviewPriority) {
        this.reviewPriority = reviewPriority;
    }

    @JsonProperty("submission_class_code")
    String getSubmissionClassCode() {
        return submissionClassCode;
    }

    @JsonProperty("submission_class_code")
    void setSubmissionClassCode(String submissionClassCode) {
        this.submissionClassCode = submissionClassCode;
    }

    @JsonProperty("submission_class_code_description")
    String getSubmissionClassCodeDescription() {
        return submissionClassCodeDescription;
    }

    @JsonProperty("submission_class_code_description")
    void setSubmissionClassCodeDescription(String submissionClassCodeDescription) {
        this.submissionClassCodeDescription = submissionClassCodeDescription;
    }

    @JsonProperty("application_docs")
    List<ApplicationDoc> getApplicationDocs() {
        return applicationDocs;
    }

    @JsonProperty("application_docs")
    void setApplicationDocs(List<ApplicationDoc> applicationDocs) {
        this.applicationDocs = applicationDocs;
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
