package com.datacompass.exception;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ErrorVO {

    private String code;

    private String description;

    private String comments;

    public ErrorVO() {
    }

    public ErrorVO(String code, String description, String comments) {
        this.code = code;
        this.description = description;
        this.comments = comments;
    }

    public ErrorVO(BusinessException businessException) {
        this.code = businessException.getErrorCode().getCode();
        this.description = businessException.getMessage();
        this.comments = businessException.getErrorCode().getComments();
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

