package com.monster.luv_cocktail.domain.filter;

import com.monster.luv_cocktail.domain.Enumeration.Role;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class RoleDeserializer extends JsonDeserializer<Role> {
    @Override
    public Role deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return Role.valueOf(value); // 열거형으로 변환
    }
}