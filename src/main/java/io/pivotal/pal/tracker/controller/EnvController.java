package io.pivotal.pal.tracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfIndex;
    private String cfAddress;

    private HashMap<String, String> env;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfIndex = cfIndex;
        this.cfAddress = cfAddress;
        env = new HashMap<>();
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfIndex);
        env.put("CF_INSTANCE_ADDR", cfAddress);
    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return env;
    }
}
