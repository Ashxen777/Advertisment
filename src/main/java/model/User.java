package model;



import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private String phoneNumber;
    private String password;

}
