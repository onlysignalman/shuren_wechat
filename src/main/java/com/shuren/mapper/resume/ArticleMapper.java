package com.shuren.mapper.resume;

import com.shuren.pojo.resume.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 董帮辉 on 2017-5-23.
 */
public interface ArticleMapper {
    /**
     * 分页查询条数
     * @param offset
     * @param limit
     * @param type
     * @param subtype
     * @return
     */
    Long queryByTypeAndSubTypeCount(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("type") Integer type,@Param("subtype") String subtype);

    /**
     * 分页查询
     * @param offset
     * @param limit
     * @param type
     * @param subtype
     * @return
     */
    List<Article> queryByTypeAndSubTypeList(@Param("offset") Integer offset,@Param("limit") Integer limit,@Param("type") Integer type,@Param("subtype") String subtype);

    /**
     * 查询文章详情
     * @param id
     * @return
     */
    Article queryById(Integer id);
}
