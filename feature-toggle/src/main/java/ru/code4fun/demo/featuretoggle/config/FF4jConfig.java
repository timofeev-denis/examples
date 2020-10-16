package ru.code4fun.demo.featuretoggle.config;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.core.FeatureStore;
import org.ff4j.store.InMemoryFeatureStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4jConfig {

    @Bean
    public FF4j ff4j() {
        FF4j ff4j = new FF4j();
        ff4j.setFeatureStore(prepareFeatureStore());
        return ff4j;
    }

    private FeatureStore prepareFeatureStore() {
        InMemoryFeatureStore featureStore = new InMemoryFeatureStore();
        featureStore.create(new Feature("FEATURE_OLD", false));
        featureStore.create(new Feature("FEATURE_NEW", false));
        return featureStore;
    }
}
