package ru.code4fun.demo.apigateway.gateway;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DataBaseUserDetailsService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>(user.getAuthorities());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new DefaultOAuth2User(
                grantedAuthorities,
                user.getAttributes(),
                "id"
        );
    }
}