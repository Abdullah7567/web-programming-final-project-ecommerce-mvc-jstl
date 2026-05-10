package com.ecommerce.dao;
import com.ecommerce.model.Category; import com.ecommerce.util.DBUtil; import java.sql.*; import java.util.*;
public class CategoryDAO {
 private Category map(ResultSet rs)throws SQLException{Category x=new Category();x.setId(rs.getInt("id"));x.setName(rs.getString("name"));x.setDescription(rs.getString("description"));x.setActive(rs.getBoolean("is_active"));return x;}
 public List<Category> findActive()throws Exception{return query("select * from categories where is_active=1 order by name");}
 public List<Category> findAll()throws Exception{return query("select * from categories order by id desc");}
 private List<Category> query(String sql)throws Exception{List<Category> l=new ArrayList<>();try(Connection c=DBUtil.getConnection();Statement st=c.createStatement();ResultSet rs=st.executeQuery(sql)){while(rs.next())l.add(map(rs));}return l;}
 public Category findById(int id)throws Exception{try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement("select * from categories where id=?")){ps.setInt(1,id);try(ResultSet rs=ps.executeQuery()){return rs.next()?map(rs):null;}}}
 public void save(Category x)throws Exception{try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement("insert into categories(name,description,is_active) values(?,?,?)")){ps.setString(1,x.getName());ps.setString(2,x.getDescription());ps.setBoolean(3,x.isActive());ps.executeUpdate();}}
 public void update(Category x)throws Exception{try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement("update categories set name=?,description=?,is_active=? where id=?")){ps.setString(1,x.getName());ps.setString(2,x.getDescription());ps.setBoolean(3,x.isActive());ps.setInt(4,x.getId());ps.executeUpdate();}}
 public void softDelete(int id)throws Exception{try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement("update categories set is_active=0 where id=?")){ps.setInt(1,id);ps.executeUpdate();}}
 public int count()throws Exception{try(Connection c=DBUtil.getConnection();Statement st=c.createStatement();ResultSet rs=st.executeQuery("select count(*) from categories")){rs.next();return rs.getInt(1);}}
}
