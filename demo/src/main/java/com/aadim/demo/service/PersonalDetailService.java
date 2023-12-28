package com.aadim.demo.service;

import com.aadim.demo.dto.request.PersonalDetailRequest;
import com.aadim.demo.dto.request.StudentRequest;
import com.aadim.demo.dto.response.PersonalDetailResponse;
import com.aadim.demo.dto.response.StudentResponse;

import java.util.List;

public interface PersonalDetailService {

    PersonalDetailResponse savePersonalDetail(PersonalDetailRequest request);

    List<PersonalDetailResponse> getAllPersonalDetail();

    PersonalDetailResponse getById(Integer id);
    String deletePersonalDetail(Integer id);
}
