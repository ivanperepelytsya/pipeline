package io.logz;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.logz.model.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class DescriptorTransformer {


    public PipelineDescriptor getPipelineDescriptor(String fileDescriptionPath) {
        return convertJSONToObject(fileDescriptionPath);
    }

    private PipelineDescriptor convertJSONToObject(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)));
            return mapper.readValue(contents, PipelineDescriptor.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Wrong payload structure");
        }
    }
}
