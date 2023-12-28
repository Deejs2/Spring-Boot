package com.aadim.demo.controller;

import com.aadim.demo.dto.request.PersonalDetailRequest;
import com.aadim.demo.dto.request.StudentRequest;
import com.aadim.demo.dto.response.PersonalDetailResponse;
import com.aadim.demo.dto.response.StudentResponse;
import com.aadim.demo.service.PersonalDetailService;
import com.aadim.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalDetail")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalDetailController {
    private final PersonalDetailService personalDetailService;

    @PostMapping("/save")
    public PersonalDetailResponse save(@RequestBody PersonalDetailRequest request){
        return personalDetailService.savePersonalDetail(request);
    }

    @GetMapping("/fetch")
    public List<PersonalDetailResponse> getAll(){
        return personalDetailService.getAllPersonalDetail();
    }

    @GetMapping("/fetch/{id}")
    public PersonalDetailResponse getById(@PathVariable Integer id){
        return personalDetailService.getById(id);
    }

//    @PutMapping("/update/{id}")
//    public PersonalDetailResponse updateStudent(@PathVariable Integer id, @RequestBody PersonalDetailRequest request){
//        return personalDetailService.updatePersonalDetail(id, request);
//    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return personalDetailService.deletePersonalDetail(id);
    }
}
