package ru.code4fun.demo.apigateway.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    @Value("${downstream.client.url}")
    private String clientUrl;

    @Value("${downstream.admin.url}")
    private String adminUrl;

    @GetMapping("/public/**")
    public ResponseEntity<?> proxyToClient(ProxyExchange<?> proxy) {
        String path = proxy.path("/public");
        return proxy.uri(clientUrl + path).get();
    }

    @GetMapping("/admin/**")
    public ResponseEntity<?> proxyToAdmin(ProxyExchange<?> proxy) {
        String path = proxy.path("/admin");
        return proxy.uri(adminUrl + path).get();
    }
}
