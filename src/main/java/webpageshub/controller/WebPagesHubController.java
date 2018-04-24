package webpageshub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webpageshub.service.LoadWebPagesHubConfigService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class WebPagesHubController {

    @Autowired
    private LoadWebPagesHubConfigService loadService;

    @GetMapping(value = "/configs")
    @ResponseBody
    String getAllConfig() throws IOException {
        return loadService.readConfigFileAsString();
    }

    @GetMapping(value = "/config")
    @ResponseBody
    String getConfig(HttpServletRequest request) throws IOException {
        return loadService.loadConfigByIdAsString(request.getRemoteHost());
    }

}
