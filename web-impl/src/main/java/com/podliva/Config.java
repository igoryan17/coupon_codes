package com.podliva;

import com.podliva.web.models.Provider;
import com.podliva.web.url.PapaJonsUrlComposer;
import com.podliva.web.url.UrlComposer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:web.properties")
@ComponentScan("com.podliva.web")
public class Config {
    @Autowired
    Environment env;

    @Bean
    @Scope("singleton")
    public UrlComposer papaJonsUrlComposer() {
        return new PapaJonsUrlComposer(
                env.getProperty("web.papajons.protocol"),
                env.getProperty("web.papajons.domen"),
                env.getProperty("web.papajons.api"),
                env.getProperty("web.papajons.query"));
    }

    @Bean
    @Scope("singleton")
    public Map<Provider, UrlComposer> urlComposerMap() {
        Map<Provider, UrlComposer> map = new HashMap<>();
        map.put(Provider.PAPA_JONS, papaJonsUrlComposer());
        return map;
    }
}
