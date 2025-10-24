package com.udea.Lab2p;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
@RestController
public class DataController {
    @GetMapping("/")
    public String healthCheck() {
        return "HEALTH CHECK OK";
    }
    @GetMapping("/version")
    public String version() {
        return "Version 1.0.0";
    }
    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        var ObjectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var nations = ObjectMapper.createArrayNode();
        for (var i = 0; i < 10; i++) {
            var nation = faker.nation();
            nations.add(ObjectMapper.createObjectNode()
                .put("nacionality", nation.nationality())
                .put("capitalCity", nation.capitalCity())
                .put("bandera", nation.flag())
                .put("language", nation.language())
            );
        }
        return nations;
    }
    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
        var ObjectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var currencies = ObjectMapper.createArrayNode();
        for (var i = 0; i < 20; i++) {
            var currency = faker.currency();
            currencies.add(ObjectMapper.createObjectNode()
                .put("code", currency.code())
                .put("name", currency.name())
            );
        }
        return currencies;
    }
    @GetMapping("/aviation")
    public JsonNode getRandomAviationData() {
        var ObjectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var aviationData = ObjectMapper.createArrayNode();
        for (var i = 0; i < 20; i++) {
            var aircraft = faker.aviation();
            aviationData.add(ObjectMapper.createObjectNode()
                .put("aircraft", aircraft.aircraft())
                .put("airport", aircraft.airport())
                .put("metar", aircraft.METAR())
            );
        }
        return aviationData;
    }
}
