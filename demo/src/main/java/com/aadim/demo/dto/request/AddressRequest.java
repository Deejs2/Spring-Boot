package com.aadim.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    @NotNull(message = "Country cannot be null!")
    private String country;
    @NotNull(message = "State cannot be null!")
    private String state;
    private String street;
}
