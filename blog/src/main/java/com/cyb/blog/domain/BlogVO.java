package com.cyb.blog.domain;

public class BlogVO extends Blog {

	private int commentCount = 0;
	
	private int fablousCount = 0;
	
	private int fowardCount = 0;

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getFablousCount() {
		return fablousCount;
	}

	public void setFablousCount(int fablousCount) {
		this.fablousCount = fablousCount;
	}

	public int getFowardCount() {
		return fowardCount;
	}

	public void setFowardCount(int fowardCount) {
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