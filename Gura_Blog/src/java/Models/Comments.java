/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Comments {
    
    private String comment_id;
    private String user_id;
    private String post_id;
    private String comment_parent_id;
    private String comment_detail;
    
    
    private String comment_create_date;
    private String comment_create_time;
    
    private String comment_status;

    public String getComment_id() {
        return comment_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getComment_parent_id() {
        return comment_parent_id;
    }

    public String getComment_detail() {
        return comment_detail;
    }

    public String getComment_create_date() {
        return comment_create_date;
    }

    public String getComment_create_time() {
        return comment_create_time;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setComment_parent_id(String comment_parent_id) {
        this.comment_parent_id = comment_parent_id;
    }

    public void setComment_detail(String comment_detail) {
        this.comment_detail = comment_detail;
    }

    public void setComment_create_date(String comment_create_date) {
        this.comment_create_date = comment_create_date;
    }

    public void setComment_create_time(String comment_create_time) {
        this.comment_create_time = comment_create_time;
    }

    public String getComment_status() {
        return comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }
    
    

    public Comments() {
    }

    public Comments(String comment_id, String user_id, String post_id, String comment_parent_id, String comment_detail, String comment_create_date, String comment_create_time,String comment_status) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.comment_parent_id = comment_parent_id;
        this.comment_detail = comment_detail;
        this.comment_create_date = comment_create_date;
        this.comment_create_time = comment_create_time;
        this.comment_status = comment_status;
    }
    
    
    
}
