package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TuihuantushuEntity;
import com.entity.view.TuihuantushuView;

import com.service.TuihuantushuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 退换图书
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-05 14:09:24
 */
@RestController
@RequestMapping("/tuihuantushu")
public class TuihuantushuController {
    @Autowired
    private TuihuantushuService tuihuantushuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuihuantushuEntity tuihuantushu, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			tuihuantushu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TuihuantushuEntity> ew = new EntityWrapper<TuihuantushuEntity>();
		PageUtils page = tuihuantushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuihuantushu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuihuantushuEntity tuihuantushu, HttpServletRequest request){
        EntityWrapper<TuihuantushuEntity> ew = new EntityWrapper<TuihuantushuEntity>();
		PageUtils page = tuihuantushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuihuantushu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuihuantushuEntity tuihuantushu){
       	EntityWrapper<TuihuantushuEntity> ew = new EntityWrapper<TuihuantushuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuihuantushu, "tuihuantushu")); 
        return R.ok().put("data", tuihuantushuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuihuantushuEntity tuihuantushu){
        EntityWrapper< TuihuantushuEntity> ew = new EntityWrapper< TuihuantushuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuihuantushu, "tuihuantushu")); 
		TuihuantushuView tuihuantushuView =  tuihuantushuService.selectView(ew);
		return R.ok("查询退换图书成功").put("data", tuihuantushuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuihuantushuEntity tuihuantushu = tuihuantushuService.selectById(id);
        return R.ok().put("data", tuihuantushu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuihuantushuEntity tuihuantushu = tuihuantushuService.selectById(id);
        return R.ok().put("data", tuihuantushu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuihuantushuEntity tuihuantushu, HttpServletRequest request){
    	tuihuantushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuihuantushu);
        tuihuantushuService.insert(tuihuantushu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuihuantushuEntity tuihuantushu, HttpServletRequest request){
    	tuihuantushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuihuantushu);
        tuihuantushuService.insert(tuihuantushu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TuihuantushuEntity tuihuantushu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuihuantushu);
        tuihuantushuService.updateById(tuihuantushu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuihuantushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TuihuantushuEntity> wrapper = new EntityWrapper<TuihuantushuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = tuihuantushuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
