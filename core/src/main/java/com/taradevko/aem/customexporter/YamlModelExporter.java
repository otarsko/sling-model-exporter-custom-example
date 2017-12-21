package com.taradevko.aem.customexporter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.models.export.spi.ModelExporter;
import org.apache.sling.models.factory.ExportException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Component
@Service
public class YamlModelExporter implements ModelExporter {

    @Override
    public boolean isSupported(Class<?> clazz) {
        return clazz.equals(String.class);
    }

    @Override
    public <T> T export(Object model, Class<T> clazz, Map<String, String> options) throws ExportException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        StringWriter stringWriter = new StringWriter();
        try {
            mapper.writeValue(stringWriter, model);
        } catch (IOException e) {
            throw new ExportException(e);
        }
        return (T) stringWriter.toString();
    }

    @Override
    public String getName() {
        return "yaml-exporter";
    }
}
