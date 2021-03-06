package com.cyb.blog.domain;

import java.util.Date;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.blog_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private String blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_user_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private String commentUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_containt
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private String commentContaint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_date
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private Date commentDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.modal
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    private String modal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.blog_id
     *
     * @return the value of comment.blog_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public String getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.blog_id
     *
     * @param blogId the value for comment.blog_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user_id
     *
     * @return the value of comment.user_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user_id
     *
     * @param userId the value for comment.user_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_user_id
     *
     * @return the value of comment.comment_user_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public String getCommentUserId() {
        return commentUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_user_id
     *
     * @param commentUserId the value for comment.comment_user_id
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_containt
     *
     * @return the value of comment.comment_containt
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public String getCommentContaint() {
        return commentContaint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_containt
     *
     * @param commentContaint the value for comment.comment_containt
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setCommentContaint(String commentContaint) {
        this.commentContaint = commentContaint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_date
     *
     * @return the value of comment.comment_date
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_date
     *
     * @param commentDate the value for comment.comment_date
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.modal
     *
     * @return the value of comment.modal
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public String getModal() {
        return modal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.modal
     *
     * @param modal the value for comment.modal
     *
     * @mbg.generated Sun Feb 10 22:16:19 CST 2019
     */
    public void setModal(String modal) {
        this.modal = modal;
    }
}