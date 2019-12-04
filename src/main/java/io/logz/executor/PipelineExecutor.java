package io.logz.executor;

import io.logz.PipelineDescriptor;
import io.logz.model.Step;
import io.logz.processor.Processor;
import io.logz.processor.factory.ProcessorFactory;
import io.logz.processor.factory.DefaultProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class PipelineExecutor {
    final private ProcessorFactory factory = new DefaultProcessorFactory();

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument){
        final List<String> collect = pipelineDescriptor.getSteps()
                .stream()
                .map(Step::getProcessor)
                .distinct().collect(Collectors.toList());
        for (Step step : pipelineDescriptor.getSteps()) {
            final Processor processor = factory.create(step.getProcessor());
            processor.initialize(step.getConfiguration());
            processor.process(jsonDocument);
        }
    }
}
