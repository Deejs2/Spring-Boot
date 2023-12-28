package com.aadim.demo.service;

import com.aadim.demo.dto.request.AddressRequest;
import com.aadim.demo.dto.request.AddressUpdateRequest;
import com.aadim.demo.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {
    AddressResponse saveAddress(AddressRequest request);
    List<AddressResponse> getAllAddress();

    AddressResponse getById(Integer id);

    AddressResponse updateAddress(AddressUpdateRequest request);

    String deleteAddress(Integer id);
}
