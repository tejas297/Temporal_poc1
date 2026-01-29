package com.example.temporal.poccode;


import java.util.HashMap;
import java.util.Map;
public class Cart {

    private Map<String, Object> data = new HashMap<>();

    // REQUIRED by Jackson
    public Cart() {
    }

    public Cart(String orderId) {
        data.put("orderId", orderId);
        data.put("status", "CREATED");
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }
}
