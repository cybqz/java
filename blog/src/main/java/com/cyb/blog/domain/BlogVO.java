package com.cyb.blog.domain;

public class BlogVO extends Blog {
	
	private boolean fablous = false;

	private long commentCount = 0;
	
	private long fablousCount = 0;
	
	private long fowardCount = 0;
	
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
	
	public static BlogVO toBlog(Blog blog) {
		BlogVO blogVO = new BlogVO();
		blogVO.setId(blog.getId());
		blogVO.setTitle(blog.getTitle());
		blogVO.setAuthor(blog.getAuthor());
		blogVO.setCreatetime(blog.getCreatetime());
		blogVO.setContaint(blog.getContaint());
		blogVO.setImage(blog.getImage());
		return blogVO;
	}
}