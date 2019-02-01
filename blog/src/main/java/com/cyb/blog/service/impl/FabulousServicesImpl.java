package com.cyb.blog.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.FabulousMapper;
import com.cyb.blog.domain.Fabulous;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.service.FabulousServices;

@Service(value="fabulousServices")
public class FabulousServicesImpl implements FabulousServices {

	@Resource
	private FabulousMapper fabulousMapper;
	
	public long countByExample(FabulousExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(FabulousExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Fabulous record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Fabulous record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Fabulous> selectByExample(FabulousExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Fabulous selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Fabulous record, FabulousExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Fabulous record, FabulousExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Fabulous record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Fabulous record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
