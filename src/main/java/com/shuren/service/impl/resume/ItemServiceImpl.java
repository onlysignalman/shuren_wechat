package com.shuren.service.impl.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.pojo.resume.Item;
import org.springframework.stereotype.Service;

import com.shuren.service.resume.ItemService;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {


    @Override
    public PageInfo<Item> findAllByPage(Integer pageNum, Integer pageSize) {

        return null;
    }
}
