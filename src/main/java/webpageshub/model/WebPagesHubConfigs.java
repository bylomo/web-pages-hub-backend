package webpageshub.model;

public class WebPagesHubConfigs {

    private WebPagesHubConfig[] configs;

    public WebPagesHubConfig getConfigById(String id) {
        for(WebPagesHubConfig config : configs) {
            if (config.getId().equals(id)) {
                return config;
            }
        }
        return null;
    }

    public WebPagesHubConfig[] getConfigs() {
        return configs;
    }

    public void setConfigs(WebPagesHubConfig[] configs) {
        this.configs = configs;
    }

}
