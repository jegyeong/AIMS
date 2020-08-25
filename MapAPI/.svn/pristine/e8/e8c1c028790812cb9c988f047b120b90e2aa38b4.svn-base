<%@ page language="java" contentType="text/plain; charset=UTF-8"
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
		String sql = "select cou_loc, cou_name from data_connect";
		pstmt = conn.prepareStatement(sql);
		 rs = pstmt.executeQuery();
		 
		 while(rs.next()){
			 String loc = rs.getString("cou_loc").trim();
			 if(loc.indexOf("(")==0){
				 loc = loc.substring(7);
			 }  
			 if(loc.lastIndexOf("(")>=0){
			 	loc = loc.substring(0, loc.lastIndexOf("("));
			 }
			 
			 //data+= "{\"title\":\""+rs.getString("a_art_name")+"\", \"addr\":\""+rs.getString("a_art_loc")+"\"},";
			 data+= "\n{\"court_addr\":\""+loc+"\", \"title\":\""+rs.getString("cou_name")+"\"},";
		 }
		
		 sql = "delete data_connect";
		 pstmt = conn.prepareStatement(sql);
		 pstmt.executeUpdate();
		 
		 data = data.substring(0, data.length()-1);
		 data +="]";
		out.print(data);		
		
	} catch(Exception e) {
	 	out.println(e.getMessage()+"<br>");
	 	out.println("실패! <br>");
	}
%>
    
    