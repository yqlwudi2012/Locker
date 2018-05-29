package com.locker.service;

import com.locker.Entity.CabinetInfoDTO;
import com.locker.dao.CabinetInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Sejta on 2018/5/29.
 */
public class CabinetInfoService {
    @Autowired
    private CabinetInfoDao cabinetInfoDao;
    public List<CabinetInfoDTO> findByExample(CabinetInfoDTO cabinetInfoDTO,int pageIndex,int pageSize){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<CabinetInfoDTO> ex = Example.of(cabinetInfoDTO, matcher);
        Page<CabinetInfoDTO>  page=cabinetInfoDao.findAll(ex, PageRequest.of(pageIndex, pageSize));
        return page.getContent();
    }
}
