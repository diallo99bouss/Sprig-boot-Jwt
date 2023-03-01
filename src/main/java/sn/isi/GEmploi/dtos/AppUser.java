package sn.isi.GEmploi.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class AppUser  {
    private int id;
    private String firsName;
    private String lastName;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
   List<AppRoles> roles = new ArrayList<AppRoles>();

}
