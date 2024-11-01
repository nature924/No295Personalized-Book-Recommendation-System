package com.entity.view;

import com.entity.TuihuantushuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 退换图书
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-05 14:09:24
 */
@TableName("tuihuantushu")
public class TuihuantushuView  extends TuihuantushuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TuihuantushuView(){
	}
 
 	public TuihuantushuView(TuihuantushuEntity tuihuantushuEntity){
 	try {
			BeanUtils.copyProperties(this, tuihuantushuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
