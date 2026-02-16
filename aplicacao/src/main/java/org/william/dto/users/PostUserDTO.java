package org.william.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.IgnoreProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostUserDTO {

    private String name;
    private String lastName;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
