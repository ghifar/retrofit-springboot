package com.ghifar.test.demoTest.service;

import com.ghifar.test.demoTest.dto.UserProfile;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface UserService {
    @GET("api")
    Call<JsonElement> userProfile();
}
