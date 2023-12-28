package com.aadim.demo.entity;

import com.aadim.demo.dto.request.AddressRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String country;
    private String state;
    private String street;

    public Address(AddressRequest request){
        this.country = request.getCountry();
        this.state = request.getState();
        this.street = request.getStreet();
    }
}
