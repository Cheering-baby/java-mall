package com.example.javamall.service.impl;


import com.example.javamall.common.api.UmsResultCode;
import com.example.javamall.common.exception.ApiException;
import com.example.javamall.common.exception.ApiExceptionAsserts;
import com.example.javamall.dto.PmsBrandParam;
import com.example.javamall.mbg.mapper.PmsBrandMapper;
import com.example.javamall.mbg.model.PmsBrand;
import com.example.javamall.mbg.model.PmsBrandExample;
import com.example.javamall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PmsServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Transactional(noRollbackFor = { ApiException.class })
    @Override
    public int createBrand(PmsBrandParam pmsBrandParam)  {
        PmsBrand pmsBrand = new PmsBrand();

        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        Integer count = brandMapper.insertSelective(pmsBrand);
        try {
            if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
                pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
                throw new Exception("12");
            }
        }catch (Exception e) {
            e.getMessage();
        }
        return count;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
