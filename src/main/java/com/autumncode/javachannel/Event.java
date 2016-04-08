package com.autumncode.javachannel;

import lombok.Data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;

@Data
public class Event {
    int amount;
    String type;
    Long createdAt;
    Long updatedAt;

    public Event(int amount, long createdAt) {
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public Event(int amount, long createdAt, long updatedAt) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private Event() {
    }

    public String toJSON() {
        JSONObject json = new JSONObject();
        json.put("amount", amount);
        json.put("createdAt", createdAt);
        json.put("type", type);
        if (updatedAt != null) {
            json.put("updatedAt", updatedAt);
        }
        return json.toJSONString();
    }

    static JSONParser parser = new JSONParser();

    public static Event fromJSON(Reader jsonReader) throws IOException, ParseException {
        JSONObject json = (JSONObject) parser.parse(jsonReader);
        Event event = new Event();
        event.setAmount(Integer.valueOf(json.get("amount").toString()));
        event.setCreatedAt(Long.valueOf(json.get("createdAt").toString()));
        event.setUpdatedAt(Long.valueOf(json.get("updatedAt").toString()));
        event.setType(json.get("type").toString());
        return event;
    }
}
