package uz.pdp.springmvctest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by: Mehrojbek
 DateTime: 10/01/25 21:10
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private Integer id;
    private String name;
    private Integer age;

}
