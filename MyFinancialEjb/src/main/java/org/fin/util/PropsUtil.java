package org.fin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {

    private static final String APP_PROPS = "application.properties";

    public static String getProperty(final String key) {
        try (InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(APP_PROPS)) {
            Properties props = new Properties();
            props.load(inStream);
            return props.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
