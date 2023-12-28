package com.aadim.demo.service.impl;

import com.aadim.demo.dto.request.FamilyDetailRequest;
import com.aadim.demo.dto.request.PersonalDetailRequest;
import com.aadim.demo.dto.response.PersonalDetailResponse;
import com.aadim.demo.entity.FamilyDetail;
import com.aadim.demo.entity.PersonalDetail;
import com.aadim.demo.repository.FamilyDetailRepository;
import com.aadim.demo.repository.PersonalDetailRepository;
import com.aadim.demo.service.PersonalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalDetailServiceImpl implements PersonalDetailService {
    private final PersonalDetailRepository personalDetailRepository;
    private final FamilyDetailRepository familyDetailRepository;

    @Override
    public PersonalDetailResponse savePersonalDetail(PersonalDetailRequest request) {

        PersonalDetail personalDetail = new PersonalDetail();
        personalDetail.setFirstname(request.getFirstname());
        personalDetail.setLastname(request.getLastname());
        personalDetail.setDateOfBirth(request.getDateOfBirth());
        personalDetail.setAge(request.getAge());
        personalDetail.setEmail(request.getEmail());
        personalDetail.setPhone(request.getPhone());
        personalDetail.setFamilyDetailArray(request.getFamilyDetailArray());

        PersonalDetail saveDetail = personalDetailRepository.save(personalDetail);


        List<FamilyDetail> familyDetails = new ArrayList<>();
        for(FamilyDetail familyDetailRequest : request.getFamilyDetailArray()){
            FamilyDetail familyDetail = new FamilyDetail();
            familyDetail.setFamilyFirstname(familyDetailRequest.getFamilyFirstname());
            familyDetail.setFamilyLastname(familyDetailRequest.getFamilyLastname());
            familyDetail.setFamilyDateOfBirth(familyDetailRequest.getFamilyDateOfBirth());
            familyDetail.setFamilyAge(familyDetailRequest.getFamilyAge());
            familyDetail.setFamilyEmail(familyDetailRequest.getFamilyEmail());
            familyDetail.setFamilyPhone(familyDetailRequest.getFamilyPhone());
            familyDetail.setPersonalDetail(saveDetail); // Associate with PersonalDetail

            familyDetails.add(familyDetail);
        }

        List<FamilyDetail> savedFamilyDetails = familyDetailRepository.saveAll(familyDetails);
        // Set the saved FamilyDetail instances to the PersonalDetail
        saveDetail.setFamilyDetailArray(savedFamilyDetails);
        personalDetailRepository.save(saveDetail); // Update PersonalDetail with associated FamilyDetail instances


        return new PersonalDetailResponse(saveDetail);




    }

    @Override
    public List<PersonalDetailResponse> getAllPersonalDetail(){
        List<PersonalDetailResponse> personalDetailResponses = new ArrayList<>();
        List<PersonalDetail> personalDetails = personalDetailRepository.findAll();
        for(PersonalDetail personalDetail : personalDetails){
            personalDetailResponses.add(new PersonalDetailResponse(personalDetail));
        }
        return personalDetailResponses;
    }

    @Override
    public PersonalDetailResponse getById(Integer id){
        PersonalDetail personalDetail = personalDetailRepository.getReferenceById(id);
        return new PersonalDetailResponse(personalDetail);
    }



    @Override
    public String deletePersonalDetail(Integer id){
        personalDetailRepository.deleteById(id);
        return "Student with id "+id+" deleted successfully";
    }
}
