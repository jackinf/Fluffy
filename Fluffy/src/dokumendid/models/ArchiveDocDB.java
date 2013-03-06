package dokumendid.models;

import java.sql.*;

public class ArchiveDocDB {

	public String TestDatabase() {
		String out_text = "";
		String sql = "";
		java.sql.Connection myConnection = null;
		ResultSet DokHulk = null;
		Statement st = null;
		try {
			myConnection = dbconnection.getConnection();
			st = myConnection.createStatement();
			sql = "select * from doc_type";
			DokHulk = st.executeQuery(sql);
			myConnection.close();
		}

		catch (Exception ex) {
			System.out
					.println("JSP_servlet_bean/ttu.idu0200.db.ArchiveDocDB.getDocsFromDB(String doc_nr):"
							+ ex.getMessage());

		} finally {
			dbconnection.closeStatement(st);
			dbconnection.closeResultSet(DokHulk);
			dbconnection.close(myConnection);
		}

		return out_text;
	}

}
