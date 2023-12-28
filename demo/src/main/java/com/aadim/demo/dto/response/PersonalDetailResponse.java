package com.aadim.demo.dto.response;

import com.aadim.demo.entity.FamilyDetail;
import com.aadim.demo.entity.PersonalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetailResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private Integer age;
    private String email;
    private String phone;

    private ArrayList<FamilyDetail> familyDetailArray;

    public PersonalDetailResponse(PersonalDetail personalDetail){
        this.id=personalDetail.getId();
        this.firstname=personalDetail.getFirstname();
        this.lastname=personalDetail.getLastname();
        this.dateOfBirth=personalDetail.getDateOfBirth();
        this.age=personalDetail.getAge();
        this.email=personalDetail.getEmail();
        this.phone=personalDetail.getPhone();
        this.familyDetailArray = new ArrayList<>(personalDetail.getFamilyDetailArray());
    }
}
