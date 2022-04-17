package ru.code4fun.demo.apigateway.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @Value("${downstream.client.url}")
    private String clientUrl;

    @GetMapping("/public/**")
    public ResponseEntity<?> proxyPath(ProxyExchange<?> proxy) throws Exception {
        String path = proxy.path("/public");
        return proxy.uri(clientUrl + path).get();
    }
}
