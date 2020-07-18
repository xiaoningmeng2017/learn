package cn.study.pojo;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String birthday;
    private String sex;
    //@Transient
    private String address;
}
