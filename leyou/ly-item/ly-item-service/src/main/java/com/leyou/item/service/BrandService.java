package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, boolean descending, String sortBy, String key) {
        PageHelper.startPage(page,rows);
        Example example = new Example(Brand.class);
        //过滤条件
        if(StringUtils.isNotBlank(key)){
            example.createCriteria().orLike("name","%"+key+"%")
                    .orEqualTo("letter",key.toUpperCase());
        }
        //排序
        if(StringUtils.isNotBlank(sortBy)){
            String orderByClause = sortBy + (descending?" DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> list = brandMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //解析分页结果
        PageInfo pageInfo = new PageInfo(list);
        return PageResult.successPage(pageInfo.getTotal(),list);
    }


    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        //保存品牌Brand
        this.brandMapper.insertSelective(brand);
        //保存品牌和分类的中间表
        cids.forEach(cid ->{
            this.brandMapper.saveBrandidAndCid(cid,brand.getId());
        });
    }

}
