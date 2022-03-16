package com.example.javamall.dao;

import com.example.javamall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
