package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class SideBarResponse {

    private String success ;
    private List<SideBarData> data;
     public SideBarResponse(String success, List<SideBarData> data){
         this.success = success;
         this.data = data;
     }
}
