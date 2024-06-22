package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/common-config.properties",
        "classpath:config/${env}.properties"
})
public interface WebConfig extends Config {
    @Key("browser")
    String browser();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.size")
    String browserSize();

    @Key("base.url")
    String baseUrl();

    @Key("remote.mode.enabled")
    boolean isRemoteEnabled();

    @Key("remote.url")
    String remoteUrl();

    @Key("page.load.strategy")
    String pageLoadStrategy();
}
