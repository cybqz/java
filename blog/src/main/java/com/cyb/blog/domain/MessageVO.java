package com.cyb.blog.domain;

public class MessageVO extends Message{
	
private boolean comment = false;
	
	private boolean fablous = false;

	private long commentCount = 0;
	
	private long fablousCount = 0;
	
	private long fowardCount = 0;
	
	private String userName;
	
	private String userImage;
	
	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}

	public boolean isFablous() {
		return fablous;
	}

	public void setFablous(boolean fablous) {
		this.fablous = fablous;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public long getFablousCount() {
		return fablousCount;
	}

	public void setFablousCount(long fablousCount) {
		this.fablousCount = fablousCount;
	}

	public long getFowardCount() {
		return fowardCount;
	}

	public void setFowardCount(long fowardCount) {
		this.fowardCount = fowardCount;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public static MessageVO toMessageVO(Message message) {
		MessageVO messageVO = new MessageVO();
		messageVO.setId(message.getId());
		messageVO.setCreatetime(message.getCreatetime());
		messageVO.setMessage(message.getMessage());
		messageVO.setImage(message.getImage());
		return messageVO;
	}
}