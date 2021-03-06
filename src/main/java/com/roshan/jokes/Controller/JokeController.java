package com.roshan.jokes.Controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/* Controller handles calls to API and helps render webpag
 */

@Controller
@RequestMapping("/api")
public class JokeController {

    /*
    Retrieve JSON data from API endpoint
    */

    @GetMapping("/jokes")
    public String getJokes(Model model) throws IOException, InterruptedException {

        // Build request to URI and send to backend

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://official-joke-api.appspot.com/random_ten"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Map<String, String> JsonMap = makeJSONMap(response);

        // Spring enables this model object to be linked to and retrieved by HTML/JS code
        model.addAttribute("jokes", JsonMap);

        return "joke-page";
    }

    /*
    Parse JSON data, create and return Map object to method call
    */

    public Map<String, String> makeJSONMap(HttpResponse<String> response){

        JSONArray jsonArray = new JSONArray(response.body());
        Map<String, String> jokes = new HashMap<>();

        // Add each JSON object to Map

        for(int i = 0; i < jsonArray.length(); i++){
            jokes.put(jsonArray.getJSONObject(i).get("setup").toString(), jsonArray.getJSONObject(i).get("punchline").toString());
        }
        return jokes;
    }
}
