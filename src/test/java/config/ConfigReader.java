package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final String DEFAULT_PROFILE = "remote";
    private static final WebConfig WEB_CONFIG = createConfiguration();

    public WebConfig webConfig() {
        return WEB_CONFIG;
    }

    private static WebConfig createConfiguration() {
        if(!System.getProperties().containsKey("env")) {
            System.out.printf("ConfigReader: [env] property not set, defaulting to [%s]%n", DEFAULT_PROFILE);
            System.getProperties().setProperty("env", DEFAULT_PROFILE);
        }

        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }
}
