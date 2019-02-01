package com.cyb.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyb.blog.dao.BlogMapper;
import com.cyb.blog.domain.Blog;
import com.cyb.blog.domain.BlogExample;
import com.cyb.blog.domain.BlogVO;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.service.BlogServices;

@Service(value="blogServices")
public class BlogServicesImpl implements BlogServices {

	@Resource
	private BlogMapper blogMapper;
	
	public long countByExample(BlogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(BlogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Blog record) {
		return blogMapper.insert(record);
	}

	public int insertSelective(Blog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Blog> selectByExample(BlogExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Blog selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Blog record, BlogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Blog record, BlogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Blog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Blog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Pagenation getList(Blog blog, Pagenation pagenation) {
		List<BlogVO> result = new ArrayList<BlogVO>();
		BlogExample example = new BlogExample();
		List<Blog> list = blogMapper.selectByExample(example);
		for(Blog b : list) {
			BlogVO blogVO = BlogVO.toBlog(b);
			result.add(blogVO);
		}
		long count = blogMapper.countByExample(example);
		pagenation.setPageCount(count);
		pagenation.setPageDatas(result);
		return pagenation;
	}
}
