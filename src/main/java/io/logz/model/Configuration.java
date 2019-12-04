package io.logz.model;

import java.util.Map;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class Configuration {
    private String fieldName;
    private String fieldValue;
    private String targetFieldName;

    public String getTargetFieldName() {
        return targetFieldName;
    }

    public void setTargetFieldName(String targetFieldName) {
        this.targetFieldName = targetFieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
