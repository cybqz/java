package com.cyb.blog.domain;

import java.util.Date;

public class Reading {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reading.id
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reading.title
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reading.author
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reading.createtime
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reading.recommend
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    private String recommend;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reading.image
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    private String image;
    
    private String modal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reading.id
     *
     * @return the value of reading.id
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reading.id
     *
     * @param id the value for reading.id
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reading.title
     *
     * @return the value of reading.title
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reading.title
     *
     * @param title the value for reading.title
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reading.author
     *
     * @return the value of reading.author
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reading.author
     *
     * @param author the value for reading.author
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reading.createtime
     *
     * @return the value of reading.createtime
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reading.createtime
     *
     * @param createtime the value for reading.createtime
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reading.recommend
     *
     * @return the value of reading.recommend
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public String getRecommend() {
        return recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reading.recommend
     *
     * @param recommend the value for reading.recommend
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reading.image
     *
     * @return the value of reading.image
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reading.image
     *
     * @param image the value for reading.image
     *
     * @mbg.generated Mon Feb 04 09:10:23 CST 2019
     */
    public void setImage(String image) {
        this.image = image;
    }

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}
}