package com.cyb.blog.domain;

import java.util.Date;

public class Blog {
	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.id
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.title
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.author
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.createtime
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.containt
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    private String containt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.image
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    private String image;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.id
     *
     * @return the value of blog.id
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.id
     *
     * @param id the value for blog.id
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.title
     *
     * @return the value of blog.title
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.title
     *
     * @param title the value for blog.title
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.author
     *
     * @return the value of blog.author
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.author
     *
     * @param author the value for blog.author
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.createtime
     *
     * @return the value of blog.createtime
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.createtime
     *
     * @param createtime the value for blog.createtime
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.containt
     *
     * @return the value of blog.containt
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public String getContaint() {
        return containt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.containt
     *
     * @param containt the value for blog.containt
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public void setContaint(String containt) {
        this.containt = containt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.image
     *
     * @return the value of blog.image
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.image
     *
     * @param image the value for blog.image
     *
     * @mbg.generated Sun Jan 27 13:11:27 CST 2019
     */
    public void setImage(String image) {
        this.image = image;
    }
}