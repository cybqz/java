package com.cyb.blog.domain;

public class ReadingVO extends Reading {

	private boolean comment = false;
	
	private boolean fablous = false;
	
	private long commentCount = 0;
	
	private long fablousCount = 0;
	
	private long fowardCount = 0;
	
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
	
	public static ReadingVO toBlog(Reading reading) {
		ReadingVO blogVO = new ReadingVO();
		blogVO.setId(reading.getId());
		blogVO.setTitle(reading.getTitle());
		blogVO.setAuthor(reading.getAuthor());
		blogVO.setCreatetime(reading.getCreatetime());
		blogVO.setRecommend(reading.getRecommend());
		blogVO.setImage(reading.getImage());
		return blogVO;
	}
}