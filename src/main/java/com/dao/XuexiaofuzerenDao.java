package com.dao;

import com.entity.XuexiaofuzerenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuexiaofuzerenView;

/**
 * 学院负责人 Dao 接口
 *
 * @author 
 */
public interface XuexiaofuzerenDao extends BaseMapper<XuexiaofuzerenEntity> {

   List<XuexiaofuzerenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
