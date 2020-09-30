package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

    @Select("select id , name , parent_id parentId  ,is_parent  isParent,sort from tb_category where parent_id=#{pid}")
    public List<Category> queryCategoryListByPid(Long pid);
}
