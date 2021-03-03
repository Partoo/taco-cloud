package cn.wemesh.tacocloud;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private Long id;
    private String name;
    private Date created_at;
    private List<String> ingredients;
}
