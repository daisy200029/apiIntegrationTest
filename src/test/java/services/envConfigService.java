package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class envConfigService {
    public void loadEnvProperties() {
            String envPropertyFile= MessageFormat.format("src/test/resources/env/{0}.properties", System.getProperty("env","local"));
            try (InputStream input = new FileInputStream(envPropertyFile)) {
                Properties prop = new Properties();
                // load a properties file
                prop.load(input);
                // get the property value and print it out
                for (String name : prop.stringPropertyNames()) {
                    String value = prop.getProperty(name);
                    System.setProperty(name, value);
                }
                prop.list(System.out);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

