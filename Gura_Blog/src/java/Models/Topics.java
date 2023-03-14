/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Topics {
    
    private String topic_id;
    private String topic_name;
    private String post_id;
    private String category_id;
    
    private int number_post;

    public String getTopic_id() {
        return topic_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public int getNumber_post() {
        return number_post;
    }

    public void setNumber_post(int number_post) {
        this.number_post = number_post;
    }
    
    

    public Topics() {
    }

    public Topics(String topic_id, String topic_name, String category_id) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.category_id = category_id;
    }
    
    

    public Topics(String topic_id, String topic_name, String post_id, String category_id) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.post_id = post_id;
        this.category_id = category_id;
    }

    public Topics(String topic_id, int number_post) {
        this.topic_id = topic_id;
        this.number_post = number_post;
    }
    
    
    
    
    
    
}
