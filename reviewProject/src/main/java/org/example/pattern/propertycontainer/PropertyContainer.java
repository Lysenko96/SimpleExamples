package org.example.pattern.propertycontainer;

import java.util.Properties;

public class PropertyContainer {

    Properties properties;

    public PropertyContainer(Properties properties) {
        this.properties = properties;
    }

    public void addProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public Properties getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        PropertyContainer container = new PropertyContainer(new Properties());
        container.addProperty("key1", "value1");
        container.addProperty("key2", "value2");
        System.out.println(container.getProperties());
    }
}
