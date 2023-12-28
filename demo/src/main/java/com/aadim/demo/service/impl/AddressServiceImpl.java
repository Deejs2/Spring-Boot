package com.aadim.demo.service.impl;

import com.aadim.demo.dto.request.AddressRequest;
import com.aadim.demo.dto.request.AddressUpdateRequest;
import com.aadim.demo.dto.response.AddressResponse;
import com.aadim.demo.entity.Address;
import com.aadim.demo.repository.AddressRepository;
import com.aadim.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public AddressResponse saveAddress(AddressRequest request){
        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setState(request.getState());
        address.setStreet(request.getStreet());

        Address saveAddress = addressRepository.save(address);
        return new AddressResponse(saveAddress);
    }

    @Override
    public List<AddressResponse> getAllAddress(){
        List<AddressResponse> addressResponses = new ArrayList<>();
        List<Address> addresses = addressRepository.findAll();
        for(Address address : addresses){
            addressResponses.add(new AddressResponse(address));
        }
        return addressResponses;
    }

    @Override
    public AddressResponse getById(Integer id){
        Address address = addressRepository.getReferenceById(id);
        return new AddressResponse(address);
    }

    @Override
    public AddressResponse updateAddress(AddressUpdateRequest request){
        Address address = addressRepository.getReferenceById(request.getId());
        address.setCountry(request.getCountry());
        address.setState(request.getState());
        address.setStreet(request.getStreet());
        Address saveAddress = addressRepository.save(address);
        return new AddressResponse(saveAddress);
    }

    @Override
    public String deleteAddress(Integer id){
        addressRepository.deleteById(id);
        return "Address with id "+id+" deleted successfully";
    }
}
