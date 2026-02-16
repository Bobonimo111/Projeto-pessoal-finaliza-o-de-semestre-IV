package org.william.dto.items;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetitemDTO (
        Integer id,
        @JsonProperty("user_Id")
        Integer userId,
        @JsonProperty("nome")
        String name
){
}
