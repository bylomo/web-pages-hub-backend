package webpageshub.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import webpageshub.model.WebPagesHubConfig;
import webpageshub.model.WebPagesHubConfigs;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LoadWebPagesHubConfigService {

    private Gson gson = new Gson();

    public String loadConfigByIdAsString(String id) throws IOException {
        String configsString = loadConfigsAsString();
        WebPagesHubConfigs configs = gson.fromJson(configsString, WebPagesHubConfigs.class);
        WebPagesHubConfig config = configs.getConfigById(id);
        if (config != null) {
            return gson.toJson(config);
        } else {
            return "";
        }
    }

    public String loadConfigsAsString() throws IOException {
        return readConfigFileAsString("classpath:web-pages-hub-configs.json");
    }

    private String readConfigFileAsString(String configFileName) throws IOException {
        File file = ResourceUtils.getFile(configFileName);
        return new String(Files.readAllBytes(file.toPath()));
    }

}
