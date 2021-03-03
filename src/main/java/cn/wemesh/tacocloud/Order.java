package cn.wemesh.tacocloud;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Order {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    private String street;
    private String city;
    private String ccCVV;
    private Date created_at;
}
