package com.fastcampus.ch3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTest2Test {
    @Autowired
    DataSource ds;
    
    @Test
    public void insertUserTest() throws Exception {
    	User user = new User("asdf", "1234", "smith", "aaa@aaa.com", new Date(), "insta", new Date());
    	deleteAll();
    	int rowCnt = insertUser(user);
    	assertTrue(rowCnt==1);
    }
    
    @Test
    public void selcetUserTest() throws Exception {
    	deleteAll();
    	User user1 = new User("gfhj", "1234", "smith", "aaa@aaa.com", new Date(), "insta", new Date());
    	int rowCnt = insertUser(user1);
    	
    	User user2 = selectUser("gfhj");
    	
    	if (user2 == null) {
            System.out.println("User2 is null");
        } else {
            System.out.println("User2 is not null: " + user2.getId());
        }
    	
    	assertEquals(user2.getId(), "gfhj");
    }
    
    @Test
    public void deleteUserTest() throws Exception {
    	deleteAll();
    	int rowCnt = deleteUser("asdf");
    	
    	assertEquals(rowCnt, 0);
    	
    	User user = new User("gfhj", "1234", "smith", "aaa@aaa.com", new Date(), "insta", new Date());
    	rowCnt = insertUser(user);
    	assertEquals(rowCnt, 1);
    	
    	rowCnt = deleteUser("gfhj");
    	assertEquals(rowCnt, 1);
    	
    	assertEquals(selectUser(user.getId()), null);
    }
    
    public int updateUser(User user) throws Exception {
    	return 0;
    }
    
    public int deleteUser(String id) throws Exception {
    	Connection conn = ds.getConnection();

    	String sql = "delete from user_info where id = ?";
    	
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, id);
//    	int rowCnt = pstmt.executeUpdate();
//    	return rowCnt;
    	
    	return pstmt.executeUpdate();
    }
    
    public User selectUser(String id) throws Exception {
    	Connection conn = ds.getConnection();
//    	System.out.println("User ID: " + id);
    	String sql = "select * from user_info where id = ?";
//    	System.out.println("SQL Query: " + sql);
    	
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, id);
    	ResultSet rs = pstmt.executeQuery();
    	
    	if(rs.next()) {
    		User user = new User();
    		user.setId(rs.getString(1));
    		user.setPwd(rs.getString(2));
    		user.setName(rs.getString(3));
    		user.setEmail(rs.getString(4));
    		user.setBirth(new Date(rs.getDate(5).getTime()));
    		user.setSns(rs.getString(6));
    		user.setReg_date(new Date(rs.getDate(7).getTime()));

//    		System.out.println("user found for ID: " + id);
    		return user;
    	}
    	
//    	System.out.println("No user found for ID: " + id);
    	return null;
    }
    
    private void deleteAll() throws Exception{
    	Connection conn = ds.getConnection();
    	    	
    	String sql = "delete from user_info";
    	
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	pstmt.executeUpdate();
	}

	// 사용자 정보를 user_info 테이블에 저장하는 테이블
    public int insertUser(User user) throws Exception {
    	Connection conn = ds.getConnection();
    	
//    	insert into user_info (id, pwd, name, email, birth, sns, reg_date)
//    	values('asdf', '1234', 'smith', 'aaa@aaa.com', '2022-01-02', 'insta', now());
    	
    	String sql = "insert into user_info values(?, ?, ?, ?, ?, ?, now());";
    	
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, user.getId());
    	pstmt.setString(2, user.getPwd());
    	pstmt.setString(3, user.getName());
    	pstmt.setString(4, user.getEmail());
    	pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
    	pstmt.setString(6, user.getSns());
    	
    	int rowCnt = pstmt.executeUpdate();
    	
    	return rowCnt;
    }
    
	@Test
	public void springJdbcConnectionTest() throws Exception {		
//      ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//      DataSource ds = ac.getBean(DataSource.class);

      Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

      System.out.println("conn = " + conn);
      assertTrue(conn!=null);
	}
}
