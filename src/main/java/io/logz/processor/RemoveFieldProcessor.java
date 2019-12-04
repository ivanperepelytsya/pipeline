package io.logz.processor;

import io.logz.model.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class RemoveFieldProcessor implements Processor {
    private Map<String, String> configuration;

    @Override
    public void initialize(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        if (configuration == null) {
            throw new IllegalArgumentException("Configuration can't be empty");
        }
        final String fieldName = configuration.get(Constants.FIELD_NAME);
        jsonDocument.remove(fieldName);
    }
}
