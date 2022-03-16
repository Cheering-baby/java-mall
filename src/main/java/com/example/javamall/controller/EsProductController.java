package com.example.javamall.controller;

import com.example.javamall.common.api.CommonResult;
import com.example.javamall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库商品到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    public CommonResult<Integer> importAllList() {
      int count = esProductService.importAll();
      return CommonResult.success(count);
    }

    @ApiOperation(value = "通过ID删除对应产品")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    public CommonResult<Integer> deleteById(@PathVariable Long id) {
        esProductService.delete(Long.valueOf(id));
        return CommonResult.success(null);
    }
}
