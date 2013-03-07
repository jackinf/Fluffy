package dokumendid.helpers;

import org.json.simple.JSONObject;

public class TableDrawer {

	public static String DrawDocumentTable(JSONObject documents) {
		String outputTable = "<table border=1>";
		outputTable += "<tr><th>Name</th><th>Description</th><th>Type</th></tr>";
		
		try {
			for (int i = 0; i < documents.size(); i++) {
				JSONObject line = (JSONObject) documents.get(i);
				outputTable += "<tr>";
				outputTable += "<td>" + line.get("name") + "</td>";
				outputTable += "<td>" + line.get("description") + "</td>";
				outputTable += "<td>" + line.get("type") + "</td>";
				outputTable += "</tr>";
			}
		} catch (Exception ex) {
			System.out
					.println("Error drawing table at dokumendid.helpers.TableDrawer.DrawDocumentTable");
		}

		outputTable += "</table>";
		return outputTable;
	}

}
