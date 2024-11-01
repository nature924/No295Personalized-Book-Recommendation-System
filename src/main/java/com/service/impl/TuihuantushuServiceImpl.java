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


import com.dao.TuihuantushuDao;
import com.entity.TuihuantushuEntity;
import com.service.TuihuantushuService;
import com.entity.vo.TuihuantushuVO;
import com.entity.view.TuihuantushuView;

@Service("tuihuantushuService")
public class TuihuantushuServiceImpl extends ServiceImpl<TuihuantushuDao, TuihuantushuEntity> implements TuihuantushuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuihuantushuEntity> page = this.selectPage(
                new Query<TuihuantushuEntity>(params).getPage(),
                new EntityWrapper<TuihuantushuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuihuantushuEntity> wrapper) {
		  Page<TuihuantushuView> page =new Query<TuihuantushuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuihuantushuVO> selectListVO(Wrapper<TuihuantushuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuihuantushuVO selectVO(Wrapper<TuihuantushuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuihuantushuView> selectListView(Wrapper<TuihuantushuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuihuantushuView selectView(Wrapper<TuihuantushuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
