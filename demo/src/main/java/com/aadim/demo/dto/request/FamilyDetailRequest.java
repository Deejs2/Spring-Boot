package com.aadim.demo.dto.request;

import com.aadim.demo.entity.PersonalDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDetailRequest {
    private String familyFirstname;
    private String familLastname;
    private Date familyDateOfBirth;
    private Integer familyAge;
    private String familyEmail;
    private String familyPhone;

    private PersonalDetail personalDetail;
}
