package com.aadim.demo.dto.request;

import com.aadim.demo.entity.FamilyDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetailRequest {
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private Integer age;
    private String email;
    private String phone;

    private ArrayList<FamilyDetail> familyDetailArray;
}
