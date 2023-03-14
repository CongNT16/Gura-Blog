/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Categories {
    
    private String category_id;
    private String category_name;
    private String topic_id;
    
    private int number_topic;

    public int getNumber_topic() {
        return number_topic;
    }

    public void setNumber_topic(int number_topic) {
        this.number_topic = number_topic;
    }
    

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public Categories() {
    }

    public Categories(String category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }
    
    

    public Categories(String category_id, String category_name, String topic_id) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.topic_id = topic_id;
    }

    public Categories(String category_id, int number_topic) {
        this.category_id = category_id;
        this.number_topic = number_topic;
    }
    
    
    
    
    
}
