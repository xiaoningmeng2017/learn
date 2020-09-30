package com.leyou.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Number page;
    private List<T> data;

    public static  <T,R extends Number>PageResult successPage(R page,List<T> list) {
        return new PageResult(page,list);
    }
}
