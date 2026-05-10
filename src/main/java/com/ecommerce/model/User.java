package com.ecommerce.model;
import java.sql.Timestamp;
public class User {
    private int id; private String fullName,email,password,phone,address,role; private Timestamp createdAt;
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getFullName(){return fullName;} public void setFullName(String v){this.fullName=v;}
    public String getEmail(){return email;} public void setEmail(String v){this.email=v;}
    public String getPassword(){return password;} public void setPassword(String v){this.password=v;}
    public String getPhone(){return phone;} public void setPhone(String v){this.phone=v;}
    public String getAddress(){return address;} public void setAddress(String v){this.address=v;}
    public String getRole(){return role;} public void setRole(String v){this.role=v;}
    public Timestamp getCreatedAt(){return createdAt;} public void setCreatedAt(Timestamp v){this.createdAt=v;}
}
