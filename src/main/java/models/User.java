package models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;
    private String name;
    private String password;
    private String emailId;
    private String mobileNumber;
    private String address;

}
