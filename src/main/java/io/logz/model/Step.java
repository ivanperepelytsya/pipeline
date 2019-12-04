package io.logz.model;

import java.util.Map;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class Step {
    private String processor;
    private Map<String, String> configuration;
    private int stepNumber;

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

}
