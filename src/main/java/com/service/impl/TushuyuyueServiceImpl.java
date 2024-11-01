package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TushuyuyueDao;
import com.entity.TushuyuyueEntity;
import com.service.TushuyuyueService;
import com.entity.vo.TushuyuyueVO;
import com.entity.view.TushuyuyueView;

@Service("tushuyuyueService")
public class TushuyuyueServiceImpl extends ServiceImpl<TushuyuyueDao, TushuyuyueEntity> implements TushuyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushuyuyueEntity> page = this.selectPage(
                new Query<TushuyuyueEntity>(params).getPage(),
                new EntityWrapper<TushuyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushuyuyueEntity> wrapper) {
		  Page<TushuyuyueView> page =new Query<TushuyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TushuyuyueVO> selectListVO(Wrapper<TushuyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TushuyuyueVO selectVO(Wrapper<TushuyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TushuyuyueView> selectListView(Wrapper<TushuyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushuyuyueView selectView(Wrapper<TushuyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
