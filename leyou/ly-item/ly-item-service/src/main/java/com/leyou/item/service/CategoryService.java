package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid){
        List<Category> list = categoryMapper.queryCategoryListByPid(pid);
        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }
        return  categoryMapper.queryCategoryListByPid(pid);
    }
}
