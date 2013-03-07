package dokumendid.controllers;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import dokumendid.database.DBQuery;
import dokumendid.models.DocumentModel;

public class DocumentController {

	private DBQuery dbquery = new DBQuery();
	
	/**
	 * Used to get all the document types from database
	 * @return - list of document types in JSON string
	 */
	public String getAllDocumentTypes()
	{
		return encodeDocumentsIntoJSON(dbquery.GetAllDocuments()).toJSONString();
	}
	
	/**
	 * Encodes list into JSON object
	 * @param items
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONObject encodeDocumentsIntoJSON(ArrayList<DocumentModel> items)
	{
		JSONObject prepared = new JSONObject();
		for (DocumentModel item : items) {
			JSONObject aDocument = new JSONObject();
			aDocument.put("name", item.getName());
			aDocument.put("description", item.getDescription());
			aDocument.put("type", item.getDocumentType());
			prepared.put(items.indexOf(item), aDocument);
		}
		return prepared;
	}
	
}
