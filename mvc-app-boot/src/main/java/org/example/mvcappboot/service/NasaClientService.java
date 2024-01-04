package org.example.mvcappboot.service;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.mvcappboot.dto.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;
import java.util.stream.Stream;

@Service
public class NasaClientService {

    @Value("${api.nasa.url}")
    private String nasaApiUrl;
    private RestTemplate restTemplate;

    public NasaClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void test() {
        System.out.println(getLargestPicture());
    }

    @Cacheable(value = "largestPicture")
    public Picture getLargestPicture() {
        JsonNode jsonNode = restTemplate.getForObject(nasaApiUrl, JsonNode.class);
        JsonNode jsonNode1 = jsonNode.findPath("photos");
        Iterator<JsonNode> it = jsonNode1.elements();
        List<Picture> pictureList = new ArrayList<>();
        while (it.hasNext()) {
            JsonNode node = it.next();
            Picture picture = buildPicture(node.findPath("img_src").asText());
            pictureList.add(picture);
        }
        return pictureList.stream().max(Comparator.comparing(Picture::getSize))
                .orElseThrow();
    }

    private Picture buildPicture(String imageUrl) {
        URI location = restTemplate.headForHeaders(imageUrl)
                .getLocation();
        Long size = restTemplate.headForHeaders(location)
                .getContentLength();
        return new Picture(imageUrl, size);
    }
}
