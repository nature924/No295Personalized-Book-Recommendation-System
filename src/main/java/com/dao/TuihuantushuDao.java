package com.dao;

import com.entity.TuihuantushuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuihuantushuVO;
import com.entity.view.TuihuantushuView;


/**
 * 退换图书
 * 
 * @author 
 * @email 
 * @date 2021-03-05 14:09:24
 */
public interface TuihuantushuDao extends BaseMapper<TuihuantushuEntity> {
	
	List<TuihuantushuVO> selectListVO(@Param("ew") Wrapper<TuihuantushuEntity> wrapper);
	
	TuihuantushuVO selectVO(@Param("ew") Wrapper<TuihuantushuEntity> wrapper);
	
	List<TuihuantushuView> selectListView(@Param("ew") Wrapper<TuihuantushuEntity> wrapper);

	List<TuihuantushuView> selectListView(Pagination page,@Param("ew") Wrapper<TuihuantushuEntity> wrapper);
	
	TuihuantushuView selectView(@Param("ew") Wrapper<TuihuantushuEntity> wrapper);
	
}
