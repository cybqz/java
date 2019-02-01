package com.cyb.blog.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.FowardMapper;
import com.cyb.blog.domain.Foward;
import com.cyb.blog.domain.FowardExample;
import com.cyb.blog.service.FowardServices;

@Service(value="FowardServices")
public class FowardServicesImpl implements FowardServices {

	@Resource
	private FowardMapper fowardMapper;
	
	public long countByExample(FowardExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(FowardExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Foward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Foward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Foward> selectByExample(FowardExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Foward selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Foward record, FowardExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Foward record, FowardExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Foward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Foward record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
