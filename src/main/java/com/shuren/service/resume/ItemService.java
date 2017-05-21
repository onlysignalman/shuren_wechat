package com.shuren.service.resume;

import com.github.pagehelper.PageInfo;
import com.shuren.pojo.resume.Item;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
public interface ItemService {
    /**
     * 分页查询试题
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Item> findAllByPage(Integer pageNum, Integer pageSize);
}
