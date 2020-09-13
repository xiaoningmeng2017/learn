package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {

    @Select("select * from tb_category where parent_id=#{pid}")
    public List<Category> queryCategoryListByPid(long pid);
}
