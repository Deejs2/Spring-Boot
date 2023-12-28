package com.aadim.demo.dto.response;

import com.aadim.demo.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Integer id;
    private String fullAddress;

    public AddressResponse(Address address){
        this.id = address.getId();
        this.fullAddress = address.getStreet()+","+address.getState()+" Province,"+address.getCountry();
    }
}
