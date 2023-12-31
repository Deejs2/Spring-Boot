package com.aadim.demo.controller;

import com.aadim.demo.controller.base.BaseController;
import com.aadim.demo.dto.request.AddressRequest;
import com.aadim.demo.dto.request.AddressUpdateRequest;
import com.aadim.demo.dto.response.AddressResponse;
import com.aadim.demo.dto.GlobalApiResponse;
import com.aadim.demo.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Validated
public class AddressController extends BaseController {
    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<GlobalApiResponse> save(@RequestBody @Valid AddressRequest request){

        return successResponse(addressService.saveAddress(request));
    }

    @GetMapping("/fetch")
    public List<AddressResponse> getAll(){

        return addressService.getAllAddress();
    }

    @GetMapping("/fetch/{id}")
    public AddressResponse getById(@PathVariable Integer id){

        return addressService.getById(id);
    }

    @PutMapping("/update")
    public AddressResponse updateAddress(@RequestBody AddressUpdateRequest request){
        return addressService.updateAddress(request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Integer id){
        return addressService.deleteAddress(id);
    }
}
