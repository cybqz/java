package com.cyb.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.BlogMapper;
import com.cyb.blog.dao.CommentMapper;
import com.cyb.blog.dao.FabulousMapper;
import com.cyb.blog.domain.Blog;
import com.cyb.blog.domain.BlogExample;
import com.cyb.blog.domain.BlogVO;
import com.cyb.blog.domain.CommentExample;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.domain.FabulousExample.Criteria;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.service.BlogServices;
import com.cyb.blog.service.UserServices;
import com.cyb.blog.utils.UserValidate;

@Service(value="blogServices")
public class BlogServicesImpl implements BlogServices {

	@Resource
	private UserServices userServices;
	@Resource
	private BlogMapper blogMapper;
	@Resource
	private FabulousMapper fabulousMapper;
	@Resource
	private CommentMapper commentMapper;
	
	public long countByExample(BlogExample example) {
		return blogMapper.countByExample(example);
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
		record.setCreatetime(new Date());
		record.setId(UUID.randomUUID().toString());
		return blogMapper.insert(record);
	}

	public int insertSelective(Blog record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Blog> selectByExample(BlogExample example) {
		// TODO Auto-generated method stub
		return blogMapper.selectByExample(example);
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
		BlogExample example = new BlogExample();
		long count = countByExample(example);
		pagenation.setDataCount(count);
		if(count > 0 && pagenation.searcha) {
			List<BlogVO> result = new ArrayList<BlogVO>();
			example.setPagenation(pagenation);
			example.setOrderByClause("createtime desc");
			List<Blog> list = selectByExample(example);
			UserValidate validate = new UserValidate();
			User user = validate.isLoginAuthenticated();
			for(Blog b : list) {
				BlogVO blogVO = BlogVO.toBlogVO(b);
				
				//设置作者用户名
				User author = userServices.selectByPrimaryKey(b.getAuthor());
				blogVO.setAuthorName(author.getUserName());
				
				//查询点赞数量
				FabulousExample fabulousExample = new FabulousExample();
				Criteria criteria = fabulousExample.createCriteria();
				criteria.andBlogIdEqualTo(b.getId());
				long fabulousCount = fabulousMapper.countByExample(fabulousExample);
				blogVO.setFablousCount(fabulousCount);
				
				//查询评论数量
				CommentExample commentExample = new CommentExample();
				com.cyb.blog.domain.CommentExample.Criteria commentCriteria = commentExample.createCriteria();
				commentCriteria.andBlogIdEqualTo(b.getId());
				long commentCount = commentMapper.countByExample(commentExample);
				blogVO.setCommentCount(commentCount);
				
				if(user != null) {
					//查询当前用户点赞数量
					criteria.andUserIdEqualTo(user.getId());
					long userFabulousCount = fabulousMapper.countByExample(fabulousExample);
					blogVO.setFablous(userFabulousCount==0);
					
					//查询当前用户评论数量
					commentCriteria.andUserIdEqualTo(user.getId());
					long usercommentCount = commentMapper.countByExample(commentExample);
					blogVO.setComment(usercommentCount==0);
				}
				result.add(blogVO);
			}
			pagenation.setPageDatas(result);
		}
		return pagenation;
	}
}
