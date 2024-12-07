package com.aruizmontana.data.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeClient {

    String stringUrl;
    public ExchangeClient(String url) {
        this.stringUrl = url;
    }

    public JsonObject request() throws IOException {
        URL url = new URL(stringUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new InputStreamReader(request.getInputStream()));
        return element.getAsJsonObject();

    }
}
