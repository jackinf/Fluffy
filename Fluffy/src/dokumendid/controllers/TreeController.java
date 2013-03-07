package dokumendid.controllers;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import dokumendid.database.DBQuery;
import dokumendid.models.CategoryModel;

public class TreeController {

	private DBQuery dbquery = new DBQuery();

	public JSONObject GetWholeTree() {
		return encodeCategoriesIntoJSON(dbquery.GetWholeTree());
	}

	/**
	 * Encodes list into JSON object
	 * 
	 * @param items
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONObject encodeCategoriesIntoJSON(ArrayList<CategoryModel> items) {
		JSONObject prepared = new JSONObject();
		for (CategoryModel item : items) {
			if (item.getLevel() == 1) {
				JSONObject combination = new JSONObject();
				combination.put("parent", item.getCatalogName());
				JSONObject children = new JSONObject();
				for (CategoryModel qwer : items) {
					if (qwer.getLevel() == 2 && qwer.getParent().getCategoryID() == item.getCategoryID())
						children.put(qwer.getCategoryID(), qwer.getCatalogName());
				}
				combination.put("children", children);
				prepared.put(item.getCategoryID(), combination);
			}
		}
		return prepared;
		/*
		for (CategoryModel item : items) {
			JSONObject aCategory = new JSONObject();
			aCategory.put("id", item.getCategoryID());
			aCategory.put("catalog_name", item.getCatalogName());
			aCategory.put("level", item.getLevel());
			aCategory.put("parentID", item.getParent() != null ? item
					.getParent().getCategoryID() : 0);
			prepared.put(items.indexOf(item), aCategory);
		}
		return prepared;
		*/
	}

}
