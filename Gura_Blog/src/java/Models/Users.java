/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;



/**
 *
 * @author nguye
 */
public class Users {

    private String user_id;
    private String user_account;
    private String user_email;
    private String user_password;
    private String user_create_date;
    private String user_create_time;
    
    private String user_firstname;
    private String user_lastname;
    private String user_gender;
    private String user_dob;
    private String user_phone;
    private String user_address;
    
    private String user_avatar;
    private String user_about;
    
    private String role_id;
    
    private int number_count;

    public String getUser_id() {
        return user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_create_date() {
        return user_create_date;
    }

    public String getUser_create_time() {
        return user_create_time;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public String getUser_dob() {
        return user_dob;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public String getUser_about() {
        return user_about;
    }

    public String getRole_id() {
        return role_id;
    }

    

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_create_date(String user_create_date) {
        this.user_create_date = user_create_date;
    }

    public void setUser_create_time(String user_create_time) {
        this.user_create_time = user_create_time;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public void setUser_about(String user_about) {
        this.user_about = user_about;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public int getNumber_count() {
        return number_count;
    }

    public void setNumber_count(int number_count) {
        this.number_count = number_count;
    }

    

    public Users() {
    }

    public Users(String user_id, String user_account, String user_email, String user_password, String user_create_date, String user_create_time) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_create_date = user_create_date;
        this.user_create_time = user_create_time;
    }

    public Users(String user_id, String role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    

    public Users(String user_id, String user_account, String user_email, String user_password, String user_create_date, String user_create_time, String user_firstname, String user_lastname, String user_gender, String user_dob, String user_phone, String user_address, String user_avatar, String user_about, String role_id) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_create_date = user_create_date;
        this.user_create_time = user_create_time;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_gender = user_gender;
        this.user_dob = user_dob;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_avatar = user_avatar;
        this.user_about = user_about;
        this.role_id = role_id;
    }

    public Users(String user_id, int number_count) {
        this.user_id = user_id;
        this.number_count = number_count;
    }

    
    
  


}
