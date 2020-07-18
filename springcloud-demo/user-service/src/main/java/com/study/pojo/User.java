package com.study.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name = "user")
public class User implements  Serializable{

        @Id
        @KeySql(useGeneratedKeys = true)
        private String id;
        private String username;
        private String birthday;
        private String sex;
        //@Transient
        private String address;
}
