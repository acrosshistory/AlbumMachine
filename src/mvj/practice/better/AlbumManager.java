package mvj.practice.better;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class AlbumManager {



	private DataSource ds;

	public AlbumManager(DataSource ds) {
		this.ds = ds;
	}
	public List<Album> allRecords(){
	List<Album> quotes = new ArrayList<Album>();

		try {
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("select * from record");
	
			// TODO Auto-generated catch block
			while(results.next()) {
				quotes.add(new Album(results.getString("album"), results.getString("artist")));
				//System.out.println("Quote:" + results.getString("text"),
					//	+"->" + results.getString("author"));
			}
			
			results.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	
		return quotes;
	}
	public boolean newAlbum(Album Album) {
		boolean ok = true;
		
		try{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into quote (text, author) values(?,?)");
			
			statement.setString(1,  Album.getAlbum());
			statement.setString(2,  Album.getArtist());
			
			statement.execute();
			ok = true;
			
			
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		return ok;
	}

}
