package com.dao;

import com.entity.TushufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushufenleiVO;
import com.entity.view.TushufenleiView;


/**
 * 图书分类
 * 
 * @author 
 * @email 
 * @date 2021-03-05 14:09:24
 */
public interface TushufenleiDao extends BaseMapper<TushufenleiEntity> {
	
	List<TushufenleiVO> selectListVO(@Param("ew") Wrapper<TushufenleiEntity> wrapper);
	
	TushufenleiVO selectVO(@Param("ew") Wrapper<TushufenleiEntity> wrapper);
	
	List<TushufenleiView> selectListView(@Param("ew") Wrapper<TushufenleiEntity> wrapper);

	List<TushufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<TushufenleiEntity> wrapper);
	
	TushufenleiView selectView(@Param("ew") Wrapper<TushufenleiEntity> wrapper);
	
}
