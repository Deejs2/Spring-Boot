package com.aadim.demo.dto.response;

import com.aadim.demo.entity.FamilyDetail;
import com.aadim.demo.entity.PersonalDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDetailResponse {
    private Integer id;
    private String familyFirstname;
    private String familyLastname;
    private Date familyDateOfBirth;
    private Integer familyAge;
    private String familyEmail;
    private String familyPhone;

    public FamilyDetailResponse(FamilyDetail familyDetail){
        this.id=familyDetail.getId();
        this.familyFirstname=familyDetail.getFamilyFirstname();
        this.familyLastname=familyDetail.getFamilyLastname();
        this.familyDateOfBirth=familyDetail.getFamilyDateOfBirth();
        this.familyAge=familyDetail.getFamilyAge();
        this.familyEmail=familyDetail.getFamilyEmail();
        this.familyPhone=familyDetail.getFamilyPhone();
    }
}
