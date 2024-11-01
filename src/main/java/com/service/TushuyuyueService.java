package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TushuyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TushuyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TushuyuyueView;


/**
 * 图书预约
 *
 * @author 
 * @email 
 * @date 2021-03-05 14:09:24
 */
public interface TushuyuyueService extends IService<TushuyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuyuyueVO> selectListVO(Wrapper<TushuyuyueEntity> wrapper);
   	
   	TushuyuyueVO selectVO(@Param("ew") Wrapper<TushuyuyueEntity> wrapper);
   	
   	List<TushuyuyueView> selectListView(Wrapper<TushuyuyueEntity> wrapper);
   	
   	TushuyuyueView selectView(@Param("ew") Wrapper<TushuyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuyuyueEntity> wrapper);
   	
}

