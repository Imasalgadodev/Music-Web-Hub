package Ima.Salgado.MusicWebHub.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class KeycloakController {

    private final String keycloakUrl = "http://localhost:8080/auth/realms/SpringBootKeycloak/protocol/openid-connect/token";
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/login")
    public String login() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "");
        map.add("username", "Isalgado");
        map.add("password", "Ima1234");
        map.add("grant_type", "Ima1234");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String response = restTemplate.postForObject(keycloakUrl, request, String.class);

        return "Response: " + response;
    }
}
