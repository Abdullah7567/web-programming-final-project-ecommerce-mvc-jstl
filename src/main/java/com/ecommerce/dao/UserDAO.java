package com.ecommerce.dao;
import com.ecommerce.model.User; import com.ecommerce.util.*; import java.sql.*; import java.util.*;
public class UserDAO {
 private User map(ResultSet rs)throws SQLException{User u=new User();u.setId(rs.getInt("id"));u.setFullName(rs.getString("full_name"));u.setEmail(rs.getString("email"));u.setPassword(rs.getString("password"));u.setPhone(rs.getString("phone"));u.setAddress(rs.getString("address"));u.setRole(rs.getString("role"));u.setCreatedAt(rs.getTimestamp("created_at"));return u;}
 public User findByEmail(String email)throws Exception{try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement("select * from users where email=?")){ps.setString(1,email);try(ResultSet rs=ps.executeQuery()){return rs.next()?map(rs):null;}}}
 public User login(String email,String password)throws Exception{User u=findByEmail(email);return u!=null&&u.getPassword().equals(PasswordUtil.hash(password))?u:null;}
 public boolean emailExists(String email)throws Exception{return findByEmail(email)!=null;}
 public void create(User u)throws Exception{try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement("insert into users(full_name,email,password,phone,address,role) values(?,?,?,?,?,?)")){ps.setString(1,u.getFullName());ps.setString(2,u.getEmail());ps.setString(3,PasswordUtil.hash(u.getPassword()));ps.setString(4,u.getPhone());ps.setString(5,u.getAddress());ps.setString(6,u.getRole()==null?"CUSTOMER":u.getRole());ps.executeUpdate();}}
 public List<User> findAll()throws Exception{List<User> list=new ArrayList<>();try(Connection c=DBUtil.getConnection();Statement st=c.createStatement();ResultSet rs=st.executeQuery("select * from users order by id desc")){while(rs.next())list.add(map(rs));}return list;}
 public int count()throws Exception{try(Connection c=DBUtil.getConnection();Statement st=c.createStatement();ResultSet rs=st.executeQuery("select count(*) from users")){rs.next();return rs.getInt(1);}}
}
