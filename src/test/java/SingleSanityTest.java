import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.logz.DescriptorTransformer;
import io.logz.PipelineDescriptor;
import io.logz.executor.PipelineExecutor;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class SingleSanityTest {

    private final String sampleJson = "{\"field1\": \"value1\", \"field2\": \"value2\", \"field3\": \"value3\"}";

    @Test
    public void singleTest() throws JsonProcessingException {
        Map<String, Object> json = getJson();

        final DescriptorTransformer descriptorTransformer = new DescriptorTransformer();
        final PipelineDescriptor pipelineDescriptor = descriptorTransformer
                .getPipelineDescriptor(getResourceAsString("pipeline.json"));

        final PipelineExecutor pipelineExecutor = new PipelineExecutor();
        pipelineExecutor.transform(pipelineDescriptor, json);

        assertEquals(json.get("field1"), "value1");
        assertEquals(json.get("field2"), "value2");
        assertEquals(json.get("field3"), "value3");
        assertEquals(json.get("firstName"), "George");
        assertEquals(json.get("countFieldName"), 4);

        System.out.println();
    }

    private Map<String, Object> getJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> json = mapper.readValue(sampleJson, Map.class);
        return json;
    }

    private String getResourceAsString(String path){
        ClassLoader classLoader = getClass().getClassLoader();
        final URL resource = classLoader.getResource("pipeline.json");
        return resource.getFile();
    }
}
