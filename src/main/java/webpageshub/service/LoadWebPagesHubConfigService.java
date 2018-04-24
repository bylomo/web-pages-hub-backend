package webpageshub.service;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import webpageshub.model.WebPagesHubConfig;
import webpageshub.model.WebPagesHubConfigs;

import java.io.*;

@Service
public class LoadWebPagesHubConfigService {

    static private Logger logger = LoggerFactory.getLogger(LoadWebPagesHubConfigService.class);

    @Value("${configFilePath}")
    private String configFilePath;

    private Gson gson = new Gson();

    public String loadConfigByIdAsString(String id) throws IOException {

        logger.info("Loading config for id {}", id);

        String configFileString = readConfigFileAsString();
        WebPagesHubConfigs configs = gson.fromJson(configFileString, WebPagesHubConfigs.class);
        WebPagesHubConfig config = configs.getConfigById(id);
        if (config != null) {

            logger.info("Loaded config {}", gson.toJson(config));

            return gson.toJson(config);
        } else {

            logger.info("No config existing for id {}", id);

            return "";
        }
    }

    public String readConfigFileAsString() throws IOException {
        File configFile = new File(configFilePath);
        if (configFile.exists()) {
            if (configFile.isFile()) {
                return IOUtils.toString(new FileReader(configFile));
            } else {
                throw new IllegalArgumentException(configFilePath + " is not a file");
            }
        } else {
            throw new IllegalArgumentException(configFilePath + " is not exist");
        }
    }

}
