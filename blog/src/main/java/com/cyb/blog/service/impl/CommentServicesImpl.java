package com.cyb.blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.CommentMapper;
import com.cyb.blog.dao.MessageMapper;
import com.cyb.blog.domain.Comment;
import com.cyb.blog.domain.CommentExample;
import com.cyb.blog.domain.Message;
import com.cyb.blog.entity.Constant;
import com.cyb.blog.service.CommentServices;

@Service(value="commentServices")
public class CommentServicesImpl implements CommentServices {

	@Resource
	private CommentMapper commentMapper;
	@Resource
	private MessageMapper messageMapper;
	
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
}
