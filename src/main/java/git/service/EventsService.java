package git.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventsService {

    private final RestTemplate restTemplate;

    public EventsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON(String owner,String repo) {
        String url = "https://api.github.com/repos/"+owner+"/"+repo+"/commits";
        return this.restTemplate.getForObject(url, String.class);
    }
}
