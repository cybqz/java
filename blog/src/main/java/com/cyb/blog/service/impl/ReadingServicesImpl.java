package com.cyb.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.FabulousMapper;
import com.cyb.blog.dao.ReadingMapper;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.domain.FabulousExample.Criteria;
import com.cyb.blog.domain.Reading;
import com.cyb.blog.domain.ReadingExample;
import com.cyb.blog.domain.ReadingExample.CriteriaReading;
import com.cyb.blog.domain.ReadingVO;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.service.ReadingServices;

@Service(value="readingServices")
public class ReadingServicesImpl implements ReadingServices {

	@Resource
	private ReadingMapper readingMapper;
	@Resource
	private FabulousMapper fabulousMapper;
	
	public long countByExample(ReadingExample example) {
		// TODO Auto-generated method stub
		return 0;
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
		return null;
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
		long count = readingMapper.countByExample(example);
		pagenation.setDataCount(count);
		if(count > 0 && pagenation.searcha) {
			List<ReadingVO> result = new ArrayList<ReadingVO>();
			example.setPagenation(pagenation);
			CriteriaReading readingCriteria = example.createCriteria();
			readingCriteria.andModalEqualTo(reading.getModal());
			List<Reading> list = readingMapper.selectByExample(example);
			for(Reading r : list) {
				ReadingVO readingVO = ReadingVO.toBlog(r);
				FabulousExample fabulousExample = new FabulousExample();
				Criteria criteria = fabulousExample.createCriteria();
				criteria.andBlogIdEqualTo(r.getId());
				long fabulousCount = fabulousMapper.countByExample(fabulousExample);
				readingVO.setFablousCount(fabulousCount);
				result.add(readingVO);
			}
			pagenation.setPageDatas(result);
		}
		return pagenation;
	}
}
