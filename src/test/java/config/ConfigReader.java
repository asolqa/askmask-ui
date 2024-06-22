package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final WebConfig WEB_CONFIG =
            ConfigFactory.create(WebConfig.class, System.getProperties());

    public WebConfig webConfig() {
        return WEB_CONFIG;
    }
}
