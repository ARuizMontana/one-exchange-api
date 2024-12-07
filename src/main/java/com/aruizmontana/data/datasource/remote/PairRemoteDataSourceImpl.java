package com.aruizmontana.data.datasource.remote;

import com.aruizmontana.data.client.ExchangeClient;
import com.aruizmontana.domain.model.PairModel;
import com.google.gson.JsonObject;

public class PairRemoteDataSourceImpl implements IPairRemoteDataSource{
    private String API_KEY = "YOUR-API-KEY";
    @Override
    public PairModel pair(String base, String target, Double amount) {
        ExchangeClient client = new ExchangeClient("https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+base+"/"+target+"/"+amount);

        try {
            JsonObject json = client.request();
            var pair = new PairModel();
            pair.setBaseCode(json.get("base_code").getAsString());
            pair.setTargetCode(json.get("target_code").getAsString());
            pair.setConversationRate(json.get("conversion_rate").getAsDouble());
            pair.setConversationResult(json.get("conversion_result").getAsDouble());
            return pair;
        } catch (Exception e) {
            return null;
        }
    }
}
