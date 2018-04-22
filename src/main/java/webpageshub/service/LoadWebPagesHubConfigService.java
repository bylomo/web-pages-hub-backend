package webpageshub.service;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import webpageshub.model.WebPagesHubConfig;
import webpageshub.model.WebPagesHubConfigs;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class LoadWebPagesHubConfigService {

    static private Logger logger = LoggerFactory.getLogger(LoadWebPagesHubConfigService.class);

    private Gson gson = new Gson();

    public String loadConfigByIdAsString(String id) throws IOException {

        logger.info("Loading config for id {}", id);

        String configsString = loadConfigsAsString();
        WebPagesHubConfigs configs = gson.fromJson(configsString, WebPagesHubConfigs.class);
        WebPagesHubConfig config = configs.getConfigById(id);
        if (config != null) {

            logger.info("Loaded config {}", gson.toJson(config));

            return gson.toJson(config);
        } else {

            logger.info("No config existing for id {}", id);

            return "";
        }
    }

    public String loadConfigsAsString() throws IOException {

        logger.info("Loading all configs");

        return readConfigFileAsString("web-pages-hub-configs.json");
    }

    private String readConfigFileAsString(String configFileName) throws IOException {
        return IOUtils.toString(new ClassPathResource(configFileName).getInputStream());
    }

}
