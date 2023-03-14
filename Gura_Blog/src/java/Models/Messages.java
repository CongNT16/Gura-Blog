/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Messages {

    private String message_id;
    private String message_detail;
    private String user_send_name;
    private String user_send_email;

    private String message_create_date;
    private String message_create_time;

    public String getMessage_id() {
        return message_id;
    }

    public String getMessage_detail() {
        return message_detail;
    }

    public String getUser_send_name() {
        return user_send_name;
    }

    public String getUser_send_email() {
        return user_send_email;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public void setMessage_detail(String message_detail) {
        this.message_detail = message_detail;
    }

    public void setUser_send_name(String user_send_name) {
        this.user_send_name = user_send_name;
    }

    public void setUser_send_email(String user_send_email) {
        this.user_send_email = user_send_email;
    }

    public String getMessage_create_date() {
        return message_create_date;
    }

    public String getMessage_create_time() {
        return message_create_time;
    }

    public void setMessage_create_date(String message_create_date) {
        this.message_create_date = message_create_date;
    }

    public void setMessage_create_time(String message_create_time) {
        this.message_create_time = message_create_time;
    }

    public Messages() {
    }

    public Messages(String message_id, String message_detail, String user_send_name, String user_send_email) {
        this.message_id = message_id;
        this.message_detail = message_detail;
        this.user_send_name = user_send_name;
        this.user_send_email = user_send_email;
    }

    public Messages(String message_id, String message_detail, String user_send_name, String user_send_email, String message_create_date, String message_create_time) {
        this.message_id = message_id;
        this.message_detail = message_detail;
        this.user_send_name = user_send_name;
        this.user_send_email = user_send_email;
        this.message_create_date = message_create_date;
        this.message_create_time = message_create_time;
    }

}
