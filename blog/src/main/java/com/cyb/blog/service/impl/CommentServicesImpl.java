package com.cyb.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.CommentMapper;
import com.cyb.blog.dao.MessageMapper;
import com.cyb.blog.dao.UserMapper;
import com.cyb.blog.domain.Comment;
import com.cyb.blog.domain.CommentExample;
import com.cyb.blog.domain.CommentVO;
import com.cyb.blog.domain.Message;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.service.CommentServices;

@Service(value="commentServices")
public class CommentServicesImpl implements CommentServices {

	@Resource
	private CommentMapper commentMapper;
	@Resource
	private MessageMapper messageMapper;
	@Resource
	private UserMapper userMapper;
	
	public long countByExample(CommentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(CommentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Comment record) {
		record.setId(UUID.randomUUID().toString());
		record.setCommentDate(new Date());
		record.setModal(Constant.MODAL_LYB);
		
		Message message = messageMapper.selectByPrimaryKey(record.getBlogId());
		if(message != null) {
			record.setUserId(message.getAuthor());
			return commentMapper.insert(record);
		}else {
			return 0;
		}
	}
	
	public int innerInsert(Comment record) {
		record.setId(UUID.randomUUID().toString());
		record.setCommentDate(new Date());
		record.setModal(Constant.MODAL_LYB_INNER_REP);
		return commentMapper.insert(record);
	}

	public int insertSelective(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Comment> selectByExample(CommentExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comment selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Comment record, CommentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Comment record, CommentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Pagenation getList(Comment commentParam, Pagenation pagenation) {
		String id = commentParam.getBlogId();
		if(StringUtils.isNotBlank(id)) {
			List<CommentVO> commentVOs = new ArrayList<CommentVO>();
			CommentExample example = new CommentExample();
			com.cyb.blog.domain.CommentExample.Criteria criteria = example.createCriteria();
			criteria.andModalEqualTo(Constant.MODAL_LYB);
			criteria.andBlogIdEqualTo(id);
			List<Comment> list = commentMapper.selectByExample(example);
			for(Comment comment : list) {
				CommentVO commentVO = CommentVO.toCommentVO(comment);
				User user = userMapper.selectByPrimaryKey(comment.getUserId());
				commentVO.setUserName(user.getUserName());
				commentVO.setUserImage(user.getImage());
				User commentUser = userMapper.selectByPrimaryKey(comment.getCommentUserId());
				commentVO.setCommentUserName(commentUser.getUserName());
				commentVO.setCommentUserImage(commentUser.getImage());
				commentVOs.add(commentVO);
			}
			pagenation.setPageDatas(commentVOs);
		}
		return pagenation;
	}

	public String innerReplyValidate(User user, Comment commentParam) {
		String id = commentParam.getId();
		if(StringUtils.isNotBlank(id)) {
			Comment comment = commentMapper.selectByPrimaryKey(id);
			String loginedUserId = user.getId();
			String blogUserId = comment.getUserId();
			String commentUserId = comment.getCommentUserId();
			if((loginedUserId.equals(blogUserId) || loginedUserId.equals(commentUserId))) {
				return commentUserId;
			}
		}
		return null;
	}
}
