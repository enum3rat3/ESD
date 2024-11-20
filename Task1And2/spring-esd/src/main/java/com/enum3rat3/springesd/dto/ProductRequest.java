package com.enum3rat3.springesd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ProductRequest (
        @NotNull(message = "Name should be present")
        @NotEmpty(message = "Name should be present")
        @NotBlank(message = "Name should be present")
        @JsonProperty("name")
        String name,

        @NotNull(message = "Price should be present")
        @NotEmpty(message = "Price should be present")
        @NotBlank(message = "Price should be present")
        @JsonProperty("price")
        double price
){
}