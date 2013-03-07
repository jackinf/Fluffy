package dokumendid.controllers;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import dokumendid.database.DBQuery;

public class DocumentController {

	private DBQuery dbquery = new DBQuery();
	
	/**
	 * Used to get all the document types from database
	 * @return - list of document types in JSON string
	 */
	public String getAllDocumentTypes()
	{
		return encodeList(dbquery.TestDatabase()).toJSONString();
	}
	
	/**
	 * Encodes list into JSON object
	 * @param items
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONObject encodeList(ArrayList<String> items)
	{
		JSONObject prepared = new JSONObject();
		for (String item : items)
			prepared.put(items.indexOf(item), item);
		return prepared;
	}
	
}
