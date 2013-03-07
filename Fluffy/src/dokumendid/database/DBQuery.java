package dokumendid.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dokumendid.models.dbconnection;

public class DBQuery {

	public ArrayList<String> TestDatabase() {
		ArrayList<String> items = new ArrayList<String>();;
		String sql = "";
		Connection myConnection = null;
		ResultSet DokHulk = null;
		Statement statement = null;
		
		try {
			myConnection = dbconnection.getConnection();
			statement = myConnection.createStatement();
			sql = "select * from doc_type";
			DokHulk = statement.executeQuery(sql);
			while (DokHulk.next())
			{
				items.add(DokHulk.getString("type_name"));
			}
			myConnection.close();
		}

		catch (Exception ex) {
			System.out
					.println("JSP_servlet_bean/ttu.idu0200.db.ArchiveDocDB.getDocsFromDB(String doc_nr):"
							+ ex.getMessage());

		} finally {
			dbconnection.closeStatement(statement);
			dbconnection.closeResultSet(DokHulk);
			dbconnection.close(myConnection);
		}

		return items;
	}
	
}
