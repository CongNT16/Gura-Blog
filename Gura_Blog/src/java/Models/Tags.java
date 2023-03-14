/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Tags {
    
    private String post_id;
    private String tag_id;
    private String tag_name;
    
    private int number_post;
    
    

    public String getPost_id() {
        return post_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getNumber_post() {
        return number_post;
    }

    public void setNumber_post(int number_post) {
        this.number_post = number_post;
    }
    
    

    public Tags() {
    }

    public Tags(String tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }
    
    

    public Tags(String post_id, String tag_id, String tag_name) {
        this.post_id = post_id;
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    public Tags(String tag_id, int number_post) {
        this.tag_id = tag_id;
        this.number_post = number_post;
    }
    
    
    
    
    
    
    
    
}
