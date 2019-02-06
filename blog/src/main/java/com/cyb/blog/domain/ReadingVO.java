package com.cyb.blog.domain;

public class ReadingVO extends Reading {

	private long commentCount = 0;
	
	private long fablousCount = 0;
	
	private long fowardCount = 0;

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