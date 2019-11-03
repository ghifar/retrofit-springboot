package com.ghifar.test.demoTest.controller;

import com.ghifar.test.demoTest.dto.ApiResponse;
import com.ghifar.test.demoTest.dto.UserProfile;
import com.ghifar.test.demoTest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/person")
    public ResponseEntity<ApiResponse> person(){
        Map<String, Object> userDetails= mainService.getUserDetails();
        UserProfile userProfile= mainService.getUserProfile(userDetails);
        ApiResponse apiResponse= mainService.getPerson(userProfile);

        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }
}
