package dokumendid.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dokumendid.database.DBConnection;
import dokumendid.models.DocumentModel;

public class DBQuery {
	
	private Connection myConnection;
	private ResultSet resultSet;
	private Statement statement;
	private PreparedStatement preparedStatement;

	/**
	 * Query to get all the documents
	 * 
	 * @return - list of documents
	 */
	public ArrayList<DocumentModel> GetAllDocuments() {
		ArrayList<DocumentModel> documents = new ArrayList<DocumentModel>();
		String sql = "";

		try {
			myConnection = DBConnection.getConnection();
			statement = myConnection.createStatement();
			sql = "SELECT * FROM document INNER JOIN doc_type ON doc_status_type_fk = doc_type";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				DocumentModel document = new DocumentModel();
				document.setName(resultSet.getString("name"));
				document.setDescription(resultSet.getString("description"));
				document.setDocumentType(resultSet.getString("type_name"));
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
			DBConnection.closeResultSet(resultSet);
			DBConnection.close(myConnection);
		}

		return documents;
	}

	/**
	 * Method which validates login and password
	 * @param username
	 * @param password
	 * @return - true, if correct username and password combination.
	 */
	public boolean Login(String username, String password) {
		boolean result = false;
		String sql = "";
		
		try {
			myConnection = DBConnection.getConnection();
			
			statement = myConnection.createStatement();
			sql = "SELECT * FROM f_isCorrectLogin('" + username + "', '" + password + "')";
			//preparedStatement = myConnection.prepareStatement("SELECT * FORM f_isCorrectLogin(?, ?)");
			//preparedStatement.setString(1, username);
			//preparedStatement.setString(2, password);
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				result = resultSet.getBoolean("f_isCorrectLogin");
			}
			
			myConnection.close();
		}

		catch (Exception ex) {
			System.out
					.println("JSP_servlet_bean/ttu.idu0200.db.ArchiveDocDB.getDocsFromDB(String doc_nr):"
							+ ex.getMessage());

		} finally {
			DBConnection.closeStatement(statement);
			DBConnection.closeResultSet(resultSet);
			DBConnection.close(myConnection);
		}
		
		return result;
	}

}
