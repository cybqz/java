package com.cyb.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.CommentMapper;
import com.cyb.blog.dao.FabulousMapper;
import com.cyb.blog.dao.ReadingMapper;
import com.cyb.blog.domain.CommentExample;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.domain.FabulousExample.Criteria;
import com.cyb.blog.domain.Reading;
import com.cyb.blog.domain.ReadingExample;
import com.cyb.blog.domain.ReadingExample.CriteriaReading;
import com.cyb.blog.domain.ReadingVO;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.service.ReadingServices;
import com.cyb.blog.utils.Validate;

@Service(value="readingServices")
public class ReadingServicesImpl implements ReadingServices {

	@Resource
	private ReadingMapper readingMapper;
	@Resource
	private FabulousMapper fabulousMapper;
	@Resource
	private CommentMapper commentMapper;
	
	public long countByExample(ReadingExample example) {
		return readingMapper.countByExample(example);
	}

	public int deleteByExample(ReadingExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Reading record) {
		record.setCreatetime(new Date());
		record.setId(UUID.randomUUID().toString());
		return readingMapper.insert(record);
	}

	public int insertSelective(Reading record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Reading> selectByExample(ReadingExample example) {
		// TODO Auto-generated method stub
		return readingMapper.selectByExample(example);
	}

	public Reading selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Reading record, ReadingExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Reading record, ReadingExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Reading record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Reading record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Pagenation getList(Reading reading, Pagenation pagenation) {
		ReadingExample example = new ReadingExample();
		long count = countByExample(example);
		pagenation.setDataCount(count);
		if(count > 0 && pagenation.searcha) {
			List<ReadingVO> result = new ArrayList<ReadingVO>();
			example.setPagenation(pagenation);
			CriteriaReading readingCriteria = example.createCriteria();
			readingCriteria.andModalEqualTo(reading.getModal());
			List<Reading> list = selectByExample(example);
			Validate validate = new Validate();
			User user = validate.isLogin();
			for(Reading r : list) {
				ReadingVO readingVO = ReadingVO.toBlog(r);
				
				//查询点赞数量
				FabulousExample fabulousExample = new FabulousExample();
				Criteria criteria = fabulousExample.createCriteria();
				criteria.andBlogIdEqualTo(r.getId());
				long fabulousCount = fabulousMapper.countByExample(fabulousExample);
				readingVO.setFablousCount(fabulousCount);
				
				//查询评论数量
				CommentExample commentExample = new CommentExample();
				com.cyb.blog.domain.CommentExample.Criteria commentCriteria = commentExample.createCriteria();
				commentCriteria.andBlogIdEqualTo(r.getId());
				long commentCount = commentMapper.countByExample(commentExample);
				readingVO.setCommentCount(commentCount);
				
				if(user != null) {
					//查询当前用户点赞数量
					criteria.andUserIdEqualTo(user.getId());
					long userFabulousCount = fabulousMapper.countByExample(fabulousExample);
					readingVO.setFablous(userFabulousCount==0);
					
					//查询当前用户评论数量
					commentCriteria.andUserIdEqualTo(user.getId());
					long usercommentCount = commentMapper.countByExample(commentExample);
					readingVO.setComment(usercommentCount==0);
				}
				result.add(readingVO);
			}
			pagenation.setPageDatas(result);
		}
		return pagenation;
	}
}
