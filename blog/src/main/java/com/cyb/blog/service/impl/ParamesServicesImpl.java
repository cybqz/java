package com.cyb.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyb.blog.dao.ParamesMapper;
import com.cyb.blog.domain.Parames;
import com.cyb.blog.domain.ParamesExample;
import com.cyb.blog.service.ParamesServices;

@Service(value="paramesServices")
public class ParamesServicesImpl implements ParamesServices {
	
	@Resource
	private ParamesMapper paramesMapper;

	public long countByExample(ParamesExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(ParamesExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Parames record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Parames record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Parames> selectByExample(ParamesExample example) {
		return paramesMapper.selectByExample(example);
	}

	public Parames selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Parames record, ParamesExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Parames record, ParamesExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Parames record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Parames record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
