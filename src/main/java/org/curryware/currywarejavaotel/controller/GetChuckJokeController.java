package org.curryware.currywarejavaotel.controller;

import com.google.gson.Gson;
import org.curryware.currywarejavaotel.models.ChuckNorrisJoke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("chuckjokes")
public class GetChuckJokeController {

    private static final Logger logger = LoggerFactory.getLogger(GetChuckJokeController.class);

    @GetMapping(value = "/getJoke", produces = "application/json")
    public @ResponseBody String getJoke() {
        logger.info("GetChuckJokeController.getJoke() called");
        return retrieveChuckJoke();
    }

    private String retrieveChuckJoke() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            ChuckNorrisJoke chuckJoke = gson.fromJson(response.body(), ChuckNorrisJoke.class);
            logger.info("Joke ID: {}", chuckJoke.getId());
            logger.info("Icon URL: {}", chuckJoke.getIcon_url());
            logger.info("Joke URL: {}", chuckJoke.getUrl());
            return chuckJoke.getValue();
        } catch (IOException | InterruptedException  error) {
            logger.error(error.getMessage());
        }
        return "Failed to retrieve joke";
    }
}
