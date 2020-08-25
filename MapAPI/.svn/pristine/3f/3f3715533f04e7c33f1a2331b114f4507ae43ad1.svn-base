<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String DB_URL = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	String DB_USER = "team1_201912m";
	String DB_PASSWORD= "java";
	
	Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs;
	String data = "[";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		String sql = "select a_art_name, a_art_loc from a_article";
		pstmt = conn.prepareStatement(sql);
		 rs = pstmt.executeQuery();
		 while(rs.next()){
			 data+= "{\"title\":\""+rs.getString("a_art_name")+"\", \"addr\":\""+rs.getString("a_art_loc")+"\"},";
		 }
		 data = data.substring(0, data.length()-1);
		 data +="]";
		out.print(data);		
		
	} catch(Exception e) {
	 	out.println(e.getMessage()+"<br>");
	 	out.println("실패! <br>");
	}
%>
    
    