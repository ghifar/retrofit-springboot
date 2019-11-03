package com.ghifar.test.demoTest.service;

import com.ghifar.test.demoTest.dto.ApiResponse;
import com.ghifar.test.demoTest.dto.UserProfile;
import java.util.List;
import java.util.Map;

public interface MainService {

    Map<String, Object> getUserDetails();

    UserProfile getUserProfile(Map<String, Object> userDetails);

    ApiResponse getPerson(UserProfile userProfile);
}
