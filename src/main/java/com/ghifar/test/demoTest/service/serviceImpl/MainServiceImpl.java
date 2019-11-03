package com.ghifar.test.demoTest.service.serviceImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghifar.test.demoTest.dto.ApiResponse;
import com.ghifar.test.demoTest.dto.UserProfile;
import com.ghifar.test.demoTest.service.MainService;
import com.ghifar.test.demoTest.service.UserService;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class MainServiceImpl implements MainService {

    @Override
    public Map<String, Object> getUserDetails() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService service= retrofit.create(UserService.class);
        Map<String, Object> result= new HashMap<>();

        Call<JsonElement> data= service.userProfile();
        try {
            Response<JsonElement>  resp = data.execute();

            ObjectMapper jsonMapper= new ObjectMapper();
            JsonNode rootJson= jsonMapper.readTree(resp.body().getAsJsonObject().toString());
            JsonNode jj= rootJson.findPath("results").get(0);

//            UserProfile[] tsst= jsonMapper.readValue(jj.toString(), UserProfile[].class);
//            userProfile= jsonMapper.treeToValue(jj, UserProfile[].class);

            TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>(){};

            result= jsonMapper.readValue(jj.toString(), typeReference);

        } catch (IOException e) {
            e.printStackTrace();
        }



        return result;
    }


    @Override
    public UserProfile getUserProfile(Map<String, Object> userDetails) {

        UserProfile userProfile= toUserprofilePojo(userDetails);



        return userProfile;
    }


    @Override
    public ApiResponse getPerson(UserProfile userProfile) {
        ApiResponse apiResponse= new ApiResponse();
        apiResponse.setFullname(userProfile.getTitle() + " "+userProfile.getFirst()+ " "+userProfile.getLast());
        apiResponse.setGender(userProfile.getGender());
        apiResponse.setAddress(userProfile.getStreetNumber() + " "+ userProfile.getStreet() +" "+ userProfile.getCity());
        apiResponse.setPicture(userProfile.getPicture());

        return apiResponse;
    }

    private UserProfile toUserprofilePojo(Map<String, Object> userDetails){

        UserProfile  userProfile= new UserProfile();
        Map<String, Object> nameObj = new HashMap<>();
        Map<String, Object> locationObj= new HashMap<>();
        Map<String, Object> pictureObj= new HashMap<>();
        Map<String, Object> streetObj= new HashMap<>();


        userDetails.forEach((k,v)->{
            if("gender".equals(k)){
                userProfile.setGender(v.toString());

            }else if("name".equals(k)){
                nameObj.putAll((HashMap<String, Object>)v);

                userProfile.setTitle(nameObj.get("title").toString());
                userProfile.setFirst(nameObj.get("first").toString());
                userProfile.setLast(nameObj.get("last").toString());
            }

            else if("location".equals(k)) {
                locationObj.putAll((HashMap<String, Object>) v);
                streetObj.putAll((HashMap<String, Object>)locationObj.get("street"));

                userProfile.setStreet(streetObj.get("name").toString());
                userProfile.setStreetNumber(streetObj.get("number").toString());
                userProfile.setCity(locationObj.get("city").toString());
            } else if("picture".equals(k)){

                pictureObj.putAll((HashMap<String, Object>)v);

                userProfile.setPicture(pictureObj.get("large").toString());
            }


        });
        return userProfile;
    }
}
