package io.logz.processor;

import io.logz.model.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class CountNumberOfFieldsProcessor implements Processor {
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
        final int count = jsonDocument.keySet().size();
        final String countFieldName = configuration.get(Constants.COUNT_FIELD_NAME);
        if (StringUtils.isEmpty(countFieldName)){
            throw new IllegalArgumentException("Count field is empty");
        }
        jsonDocument.putIfAbsent(Constants.COUNT_FIELD_NAME, count);
    }
}
