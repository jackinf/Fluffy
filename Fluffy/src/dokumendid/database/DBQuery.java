package dokumendid.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dokumendid.database.DBConnection;
import dokumendid.models.DocumentModel;

public class DBQuery {

	public ArrayList<DocumentModel> GetAllDocuments() {
		ArrayList<DocumentModel> documents = new ArrayList<DocumentModel>();
		String sql = "";
		Connection myConnection = null;
		ResultSet DokHulk = null;
		Statement statement = null;

		try {
			myConnection = DBConnection.getConnection();
			statement = myConnection.createStatement();
			sql = "SELECT * FROM document INNER JOIN doc_type ON doc_status_type_fk = doc_type";
			DokHulk = statement.executeQuery(sql);
			while (DokHulk.next()) {
				DocumentModel document = new DocumentModel();
				document.setName(DokHulk.getString("name"));
				document.setDescription(DokHulk.getString("description"));
				document.setDocumentType(DokHulk.getString("type_name"));
				documents.add(document);
			}
			myConnection.close();
		}

		catch (Exception ex) {
			System.out
					.println("JSP_servlet_bean/ttu.idu0200.db.ArchiveDocDB.getDocsFromDB(String doc_nr):"
							+ ex.getMessage());

		} finally {
			DBConnection.closeStatement(statement);
			DBConnection.closeResultSet(DokHulk);
			DBConnection.close(myConnection);
		}

		return documents;
	}

}
