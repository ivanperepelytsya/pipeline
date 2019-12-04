package io.logz.processor.factory;


import io.logz.processor.Processor;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public interface ProcessorFactory {
    Processor create(String processorName);
}
