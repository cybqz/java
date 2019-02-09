package com.cyb.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cyb.blog.dao.CommentMapper;
import com.cyb.blog.dao.FabulousMapper;
import com.cyb.blog.dao.MessageMapper;
import com.cyb.blog.domain.CommentExample;
import com.cyb.blog.domain.CommentExample.CriteriaComment;
import com.cyb.blog.domain.FabulousExample;
import com.cyb.blog.domain.FabulousExample.Criteria;
import com.cyb.blog.domain.Message;
import com.cyb.blog.domain.MessageExample;
import com.cyb.blog.domain.MessageVO;
import com.cyb.blog.domain.User;
import com.cyb.blog.entity.Pagenation;
import com.cyb.blog.service.MessageServices;
import com.cyb.blog.utils.Validate;

@Service(value="messageServices")
public class MessageServicesImpl implements MessageServices {

	@Resource
	private MessageMapper messageMapper;
	@Resource
	private FabulousMapper fabulousMapper;
	@Resource
	private CommentMapper commentMapper;
	
	public long countByExample(MessageExample example) {
		return messageMapper.countByExample(example);
	}

	public int deleteByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Message record) {
		record.setId(UUID.randomUUID().toString());
		record.setCreatetime(new Date());
		return messageMapper.insert(record);
	}

	public int insertSelective(Message record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Message> selectByExample(MessageExample example) {
		return messageMapper.selectByExample(example);
	}

	public Message selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(Message record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Message record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Pagenation getList(Message message, Pagenation pagenation) {
		MessageExample example = new MessageExample();
		long count = countByExample(example);
		pagenation.setDataCount(count);
		if(count > 0 && pagenation.searcha) {
			List<MessageVO> result = new ArrayList<MessageVO>();
			example.setPagenation(pagenation);
			List<Message> list = selectByExample(example);
			Validate validate = new Validate();
			User user = validate.isLogin();
			for(Message m : list) {
				MessageVO messageVO = MessageVO.toMessageVO(m);
				
				//查询点赞数量
				FabulousExample fabulousExample = new FabulousExample();
				Criteria criteria = fabulousExample.createCriteria();
				criteria.andBlogIdEqualTo(m.getId());
				long fabulousCount = fabulousMapper.countByExample(fabulousExample);
				messageVO.setFablousCount(fabulousCount);
				
				//查询评论数量
				CommentExample commentExample = new CommentExample();
				CriteriaComment commentCriteria = commentExample.createCriteria();
				commentCriteria.andBlogIdEqualTo(m.getId());
				long commentCount = commentMapper.countByExample(commentExample);
				messageVO.setCommentCount(commentCount);
				
				if(user != null) {
					//查询当前用户点赞数量
					criteria.andUserIdEqualTo(user.getId());
					long userFabulousCount = fabulousMapper.countByExample(fabulousExample);
					messageVO.setFablous(userFabulousCount==0);
					
					//查询当前用户评论数量
					commentCriteria.andUserIdEqualTo(user.getId());
					long usercommentCount = commentMapper.countByExample(commentExample);
					messageVO.setComment(usercommentCount==0);
				}
				result.add(messageVO);
			}
			pagenation.setPageDatas(result);
		}
		return pagenation;
	}

}
