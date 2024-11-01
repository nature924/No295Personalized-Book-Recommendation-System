package com.dao;

import com.entity.TushuyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushuyuyueVO;
import com.entity.view.TushuyuyueView;


/**
 * 图书预约
 * 
 * @author 
 * @email 
 * @date 2021-03-05 14:09:24
 */
public interface TushuyuyueDao extends BaseMapper<TushuyuyueEntity> {
	
	List<TushuyuyueVO> selectListVO(@Param("ew") Wrapper<TushuyuyueEntity> wrapper);
	
	TushuyuyueVO selectVO(@Param("ew") Wrapper<TushuyuyueEntity> wrapper);
	
	List<TushuyuyueView> selectListView(@Param("ew") Wrapper<TushuyuyueEntity> wrapper);

	List<TushuyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<TushuyuyueEntity> wrapper);
	
	TushuyuyueView selectView(@Param("ew") Wrapper<TushuyuyueEntity> wrapper);
	
}
