package io.logz.processor.factory;

import io.logz.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class DefaultProcessorFactory implements ProcessorFactory {

    private final Map<String, Processor> processors = new HashMap<>();
    private final DefaultFieldProcessor defaultFieldProcessor = new DefaultFieldProcessor();
    public DefaultProcessorFactory() {
        processors.put("AddField", new AddFieldProcessor());
        processors.put("RemoveField", new RemoveFieldProcessor());
        processors.put("CountNumberOfFields", new CountNumberOfFieldsProcessor());
    }

    @Override
    public Processor create(String processorName) {

        final Processor processor = processors.get(processorName);
        if (processor == null) return defaultFieldProcessor;

        return processor;
    }
}
