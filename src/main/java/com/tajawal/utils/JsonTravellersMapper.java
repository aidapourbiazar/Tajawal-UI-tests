package com.tajawal.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTravellersMapper {
	@JsonProperty("firstname")
    String firstname;

    @JsonProperty("lastname")
    String lastname;

    @JsonProperty("title")
    String title;

    @JsonProperty("email")
    String email;

    @JsonProperty("phoneNumber")
    String phoneNumber;

  
    public String getFirstname ()
    {
        return firstname;
    }

    
  

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    

    public String getTitle ()
    {
        return title;
    }


    public String getEmail ()
    {
        return email;
    }

  
    public String getLastname ()
    {
        return lastname;
    }

 

    @Override
    public String toString()
    {
        return "ClassPojo [firstname = "+firstname+", phoneNumber = "+phoneNumber+", title = "+title+", email = "+email+", lastname = "+lastname+"]";
    }
    
    
    public static JsonTravellersMapper get(String filename) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), JsonTravellersMapper.class);
        
    }
 
}
