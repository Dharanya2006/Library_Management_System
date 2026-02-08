package in.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kce.book.bean.BookBean;
import in.kce.book.util.DBUtil;

public class BookDAO {
	public int createBook(BookBean bookBean) {
		try {
		Connection connection =DBUtil.getDBConnection();
		PreparedStatement ps=connection.prepareStatement("Insert into Book_tbl VALUES(?,?,?,?,?)");
		ps.setString(1,bookBean.getIsbn());
		ps.setString(2, bookBean.getBookName());
		ps.setString(3, String.valueOf(bookBean.getBookType()));
		ps.setInt(4, bookBean.getAuthor().getAuthorCode());
		ps.setFloat(5,bookBean.getCost());
		int rs=ps.executeUpdate();
		if(rs>0) {
			return 1;	
		}
	}catch(Exception e) {  
		e.printStackTrace();
	}
		return 0;
}
	public BookBean fetchBook(String isbn) {
			try {
		        Connection connection = DBUtil.getDBConnection();
		        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Book_tbl WHERE isbn = ?");
		        ps.setString(1, isbn);
		        ResultSet rs = ps.executeQuery();
		        if(rs.next()) {
		        	BookBean b=new BookBean();
		        	 b.setIsbn(rs.getString(1));
		             b.setBookName(rs.getString(2));
		             b.setBookType(rs.getString(3).charAt(0));
		             b.setAuthor(new AuthorDAO().getAuthor(rs.getInt(4)));
		            b.setCost(rs.getFloat(5));
		            return b;
		        }
		    }   
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
			return null;
	}
}