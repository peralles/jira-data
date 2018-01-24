package com.br.peralles.jira.jiradatamanagement.rest.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Box {
    @JsonProperty
    Map<String, Object> json;

    public Box() {
        // Blank
    }

    // Getter and setter for `json` field
}
