package io.logz.processor;

import java.util.Map;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public interface Processor {

    void initialize(Map<String, String> configuration);
    void process(Map<String, Object> jsonDocument);

}
