import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Procedures {
	  String connectionUrl = "jdbc:sqlserver://titan.csse.rose-hulman.edu:1433;" +
	 	         "databaseName=metal;user=zhangb2;password=Hyhy5920!";
	  Connection con = null;
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
public String del (String sname){
		  
	 try {		  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
        	 String SQL2 = "EXEC del @sname =?";
        	 stmt = con.prepareStatement(SQL2);
        	 stmt.setString(1, sname);

	         try{
	        	 rs = stmt.executeQuery();
	         }
	         finally{
	        	 return "Success!";
	         }
      }

      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {}
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
	return "fail";
	  }	
public String del_com (String cname){
	  
	 try {		  
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);
       	 String SQL2 = "EXEC recommendation @cname =?";
       	 stmt = con.prepareStatement(SQL2);
       	 stmt.setString(1, cname);

	         try{
	        	 rs = stmt.executeQuery();
	         }
	         finally{
	        	 return "Success!";
	         }
     }

     catch (Exception e) {
        e.printStackTrace();
     }
     finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (stmt != null) try { stmt.close(); } catch(Exception e) {}
        if (con != null) try { con.close(); } catch(Exception e) {}
     }
	return "fail";
	  }	
public void g_comment (String score, String content,String aid,String uid){
	  
	  try {

		  
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       con = DriverManager.getConnection(connectionUrl);
       String SQL = "EXEC give_comment @score =?, @content = ?, @aid = ?, @uid = ? ";
       
       stmt = con.prepareStatement(SQL);
       stmt.setString(1, score);
       stmt.setString(2, content);
       stmt.setString(3, aid);
       stmt.setString(4, uid);
       rs = stmt.executeQuery();
    }
	  
    catch (Exception e) {
  	  //System.out.println(e);
    }
}
public ResultSet tour_information (String keyword){
	  
	  try {

		  
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 con = DriverManager.getConnection(connectionUrl);
// String SQL = "select Band.name as bname, Tour.name as tname, [Time], place from Tour,Band where Tour.name = ? and Tour.bid = band.bid";
 String SQL = "EXEC tour_info @keyword =?";
 stmt = con.prepareStatement(SQL);
 stmt.setString(1, keyword);
 rs = stmt.executeQuery();
 return rs;
}
	  
catch (Exception e) {
	  System.out.println(e);
}
	  return rs;
}
public String get_level (String keyword) throws SQLException {
	  
	  try {

		  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
con = DriverManager.getConnection(connectionUrl);
String SQL = "EXEC get_level @keyword =?";

stmt = con.prepareStatement(SQL);
stmt.setString(1, keyword);
rs = stmt.executeQuery();
}
	  
catch (Exception e) {
	  System.out.println(e);
}
	  return rs.getString(1);
}
public ResultSet member_information (String keyword){
	  
	  try {

		  
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   con = DriverManager.getConnection(connectionUrl);
   String SQL = "EXEC mem_info @keyword =?";
   
   stmt = con.prepareStatement(SQL);
   stmt.setString(1, keyword);
   rs = stmt.executeQuery();
   return rs;
}
	  
catch (Exception e) {
	  System.out.println(e);
}
	  return rs;
}

public ResultSet album_information (String keyword){
	  
	  try {

		  
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     con = DriverManager.getConnection(connectionUrl);
     String SQL = "EXEC album_info @keyword =?";
     
     stmt = con.prepareStatement(SQL);
     stmt.setString(1, keyword);
     rs = stmt.executeQuery();
     return rs;
  }
	  
  catch (Exception e) {
	  System.out.println(e);
  }
	  return rs;
}
	  
public ResultSet fav (String uid){
		  
		  try {

			  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         String SQL = "EXEC fav @uid =?";
	         
	         stmt = con.prepareStatement(SQL);
	         stmt.setString(1, uid);
	         rs = stmt.executeQuery();
	         return rs;
	      }
		  
	      catch (Exception e) {
	    	  System.out.println(e);
	      }
		  return rs;
	  }

public String recommend (String uid){
	  
	  try {

		  
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   con = DriverManager.getConnection(connectionUrl);
   String SQL = "EXEC reco @uid1 =?, @uid2 =?, @uid3 =?";
   
   stmt = con.prepareStatement(SQL);
   stmt.setString(1, uid);
   stmt.setString(2, uid);
   stmt.setString(3, uid);
   rs = stmt.executeQuery();
   String t = "";
   if(rs!=null){
	   while (rs.next()) {
		  	 t = rs.getString(1);
		  	 return t;
		  }
   }
   
   return t;
}
	  
catch (Exception e) {
//	  System.out.println(e);
}
	  return "";
}

public ResultSet song_info (String sname){
	  
	  try {

		  
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       con = DriverManager.getConnection(connectionUrl);
       String SQL = "EXEC song_info @sname =?";
       
       stmt = con.prepareStatement(SQL);
       stmt.setString(1, sname);
       rs = stmt.executeQuery();
       return rs;
    }
	  
    catch (Exception e) {
  	  System.out.println(e);
    }
	  return rs;
}

@SuppressWarnings("finally")
public String like(String id, String sid){
		  
		  try {	
			  
			  	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         con = DriverManager.getConnection(connectionUrl);
		         String SQL = "EXEC like1 @sid =?, @id =?";
		         stmt = con.prepareStatement(SQL);
		         stmt.setString(1, sid);
		         stmt.setString(2, id);
		         rs = stmt.executeQuery();
		         String t = "";
		         while (rs.next()) {
		        	 t = rs.getString(1);
			         
			     }
		         if(t == null || t == ""){
			  
			  
			  
			  
			  
			  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);

	        	 String SQL2 = "EXEC likes @sid =?, @id =?";
	        	 stmt = con.prepareStatement(SQL2);
	        	 stmt.setString(1, sid);
		         stmt.setString(2, id);
		         try{
		        	 rs = stmt.executeQuery();
		         }
		         finally{
		        	 return "Success!";
		         }

	      }
		         else {
		        	 return "duplicate";
		         }
		  }
		  
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
		return "FAIL";
}
public String login(String username, String password){
	try {
			  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			  Matcher m = p.matcher(username);
			  boolean b = m.find();

			  if (b){
				  //return "username contains special characters";
				  throw new Exception("username contains special characters");
			  }
			     
			  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         String SQL = "EXEC login @username =?, @hash =?";
	         int hash = password.hashCode();
//	         System.out.print(SQL);
	         stmt = con.prepareStatement(SQL);
	         stmt.setString(1, username);
	         stmt.setInt(2, hash);
	         rs = stmt.executeQuery();
	        	
	         while (rs.next()) {
	        	 LoginInfo.setType(rs.getString(2));
	        	 
		         String temp = (rs.getString(1));
		         String SQLt = "EXEC login2 @u1 =? , @u2 =?, @u3 =?";
		         stmt = con.prepareStatement(SQLt);
		         stmt.setString(1, temp);
		         stmt.setString(2, temp);
		         stmt.setString(3, temp);
		         try {
		        	 stmt.executeQuery();
		         }
		         catch (Exception e){
		        	 return temp;
		         }
//		         System.out.println(temp);
		         return temp;
		     }

	         String temp = "No valid username/password found!";
	         return temp;
	      }
		  
	      catch (Exception e) {
//	         e.printStackTrace();
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
	return "Error! username contains special characters.";
}
public String Register(String name, String username, String password){
		  
		  try {
			  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			  Matcher m = p.matcher(username);
			  boolean b = m.find();

			  if (b){
				  //return "username contains special characters";
				  throw new Exception("username contains special characters");
			  }
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         String SQL = "EXEC reg1 @username = ? ";

//	         System.out.print(SQL);
	         stmt = con.prepareStatement(SQL);
	         stmt.setString(1, username);
	         rs = stmt.executeQuery();
	         String t = "";
	         while (rs.next()) {
	        	 t = rs.getString("Username");
		         System.out.println(t);
		     }
	         if(t == null || t == ""){
//	        	 System.out.println(t + "b");
	        	 
	        	 String SQL2 = "EXEC reg2 @name =?, @username =? @hash =?";
	        	 int hash = password.hashCode();
	        	 stmt = con.prepareStatement(SQL2);
	        	 stmt.setString(1, name);
	        	 stmt.setString(2, username);
		         stmt.setInt(3, hash);
//		         rs = stmt.executeQuery();
//		         String s = "";
//		         while (rs.next()){
//		        	 t = (rs.getString(1));
//		         }
//		         return t;
		         try{
		        	 rs = stmt.executeQuery();
		         }
		         finally{
		        	 return "Success!";
		         }


		         
	         }
	         else{
//	        	 System.out.println(t);
	        	 return "This user name has already been used";
	         }

	      }

	      catch (Exception e) {
//	         e.printStackTrace();
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
		return "Error! username contains special characters.";
	  }
	  
	  
	  public ResultSet Search (String keyword, String type){
		  
		  try {
//			  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//			  Matcher m = p.matcher(keyword);
//			  boolean b = m.find();
//
//			  if (b){
//				  throw new Exception("keyword contains special characters");
//			  }
			     
			  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         String SQL = "SELECT * FROM "+ type +" WHERE charindex (?,Name) != 0 ";
	         
//	         System.out.print(SQL);
	         stmt = con.prepareStatement(SQL);
	         stmt.setString(1, keyword);
	         rs = stmt.executeQuery();
	         return rs;
	      }
		  
	      catch (Exception e) {
	    	  System.out.println(e);
//	         e.printStackTrace();
	      }
//	      finally {
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
//	         if (con != null) try { con.close(); } catch(Exception e) {}
//	      }
		  return rs;
	  }
public ResultSet comment (String keyword){
		  
		  try {
//			  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//			  Matcher m = p.matcher(keyword);
//			  boolean b = m.find();
//
//			  if (b){
//				  throw new Exception("keyword contains special characters");
//			  }
			     
			  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         String SQL = "EXEC comment @keyword= ?";
	         
//	         System.out.print(SQL);
	         stmt = con.prepareStatement(SQL);
	         stmt.setString(1, keyword);
	         rs = stmt.executeQuery();
	         return rs;
	      }
		  
	      catch (Exception e) {
	    	  System.out.println(e);
//	         e.printStackTrace();
	      }
//	      finally {
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
//	         if (con != null) try { con.close(); } catch(Exception e) {}
//	      }
		  return rs;
	  }
	  public ResultSet Detail (String keyword, String type){
		  
		  try {
//			  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//			  Matcher m = p.matcher(keyword);
//			  boolean b = m.find();
//
//			  if (b){
//				  throw new Exception("keyword contains special characters");
//			  }
			     
			  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(connectionUrl);
	         String SQL = "SELECT * FROM "+type+" WHERE Name = ?";
	        
	         stmt = con.prepareStatement(SQL);
	         stmt.setString(1, keyword); 
	         rs = stmt.executeQuery();
	         return rs;
	      }
		  
	      catch (Exception e) {
	    	  System.out.println(e);
//	         e.printStackTrace();
	      }
//	      finally {
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
//	         if (con != null) try { con.close(); } catch(Exception e) {}
//	      }
		  return rs;
	  }
	  
	  
	  public ResultSet Relation (String keyword, String selfType, String targetType){
		  
		  try {
//			  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//			  Matcher m = p.matcher(keyword);
//			  boolean b = m.find();
//
//			  if (b){
//				  throw new Exception("keyword contains special characters");
//			  }
			 String tempID = "";
			 if (selfType == "Album"){
				 tempID = "Aid";
			 }else if(selfType == "Songs"){
				 tempID = "Sid";
			 }else if(selfType == "Member"){
				 tempID = "Mid";
			 }else if(selfType == "Tour"){
				 tempID = "Tid";
			 }else if(selfType == "Band"){
				 tempID = "Bid";
			 }else{
				 
			 }
			 if(targetType == "Album"){
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         con = DriverManager.getConnection(connectionUrl);
		         String SQL = "SELECT "+ targetType +".Name FROM "+ selfType + "," + targetType + ",[Band makes Albums] WHERE " + selfType + "." + tempID + "= [Band makes Albums]."+tempID + " and [Band makes Albums].Aid = Album.Aid and " + selfType + ".Name = '" + keyword + "' ";
		         //System.out.println(SQL);
		         stmt = con.prepareStatement(SQL);
//		         stmt.setString(1, targetType);
//		         stmt.setString(2, keyword);
		         rs = stmt.executeQuery();
		         return rs;
			 }
			 
			 else{
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         con = DriverManager.getConnection(connectionUrl);
		         String SQL = "SELECT "+ targetType +".Name FROM "+ selfType + "," + targetType +" WHERE " + selfType + "." + tempID + "= "+ targetType + "."+tempID + " and " + selfType + ".Name = '" + keyword + "' ";
		         //System.out.println(SQL);
		         stmt = con.prepareStatement(SQL);
//		         stmt.setString(1, targetType);
//		         stmt.setString(2, keyword);
		         rs = stmt.executeQuery();
		         return rs;
			 }

	      }
		  
	      catch (Exception e) {
	    	  System.out.println(e);
//	         e.printStackTrace();
	      }
//	      finally {
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
//	         if (con != null) try { con.close(); } catch(Exception e) {}
//	      }
		  return rs;
	  }
  public ResultSet get_comment (String keyword, String selfType, String targetType){
		  
		  try {
//		
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         con = DriverManager.getConnection(connectionUrl);
		         String SQL = "SELECT "+ targetType +".Content FROM "+ selfType + "," + targetType +" WHERE " + selfType + "." + "Aid" + "= "+ targetType + "."+"Aid" + " and " + selfType + ".Name = '" + keyword + "' ";
		        // System.out.println(SQL);
		         stmt = con.prepareStatement(SQL);
//		         stmt.setString(1, targetType);
//		         stmt.setString(2, keyword);
		         rs = stmt.executeQuery();
		         return rs;

	      }
		  
	      catch (Exception e) {
	    	  System.out.println(e);
//	         e.printStackTrace();
	      }
//	      finally {
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
//	         if (con != null) try { con.close(); } catch(Exception e) {}
//	      }
		  return rs;
	  }
}

