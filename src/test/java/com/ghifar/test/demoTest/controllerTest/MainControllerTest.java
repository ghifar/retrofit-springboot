package com.ghifar.test.demoTest.controllerTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ghifar.test.demoTest.controller.MainController;
import com.ghifar.test.demoTest.dto.ApiResponse;
import com.ghifar.test.demoTest.dto.UserProfile;
import com.ghifar.test.demoTest.service.MainService;
import com.ghifar.test.demoTest.service.UserService;
import com.ghifar.test.demoTest.service.serviceImpl.MainServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
@ContextConfiguration(classes = {MainController.class, UserService.class, MainServiceImpl.class})
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainService mainService;

    @Test
    public void testGetUserDetails() throws Exception{
        Map<String, Object> userDetail= mainService.getUserDetails();
        assertThat(userDetail, notNullValue());
    }

    @Test
    public void testGetUserProfile()throws  Exception{
        Map<String, Object> userDetails= mainService.getUserDetails();
        UserProfile userProfile= mainService.getUserProfile(userDetails);
        assertThat(userProfile,notNullValue());
    }

    @Test
    public void testGetUserProfile2negativ() throws Exception{

        Map<String, Object> userDetails= new HashMap<>();

        UserProfile userProfile= mainService.getUserProfile(userDetails);
        assertThat(userProfile.getCity(), nullValue());
    }


    @Test
    public void testAPIResponse(){
        Map<String, Object> userDetails= mainService.getUserDetails();
        UserProfile userProfile= mainService.getUserProfile(userDetails);
        ApiResponse apiResponse= mainService.getPerson(userProfile);

    }

    @Test
    public void testPersonApi() throws Exception{

        MockHttpServletResponse response = mockMvc.perform(get("/person"))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus() , is(HttpStatus.OK.value()));
        System.out.println(response.getContentAsString());
    }

}
