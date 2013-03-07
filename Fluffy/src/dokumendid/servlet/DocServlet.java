package dokumendid.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import dokumendid.controllers.DocumentController;
import dokumendid.controllers.FrontController;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class DocServlet extends HttpServlet {

	private FrontController frontController;
	
	public void init() {
		frontController = new FrontController();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Locale[] supportedLocales = { new Locale("et", "ESTONIA"), Locale.ENGLISH };
		Locale currentLocale = supportedLocales[0];
		ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle",
				currentLocale);
		String ButtonText = labels.getString("LABEL_RUNDOCQUERY_BUTTON");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/rakarh1.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Dokumendid (from servlet)</p><button>" + ButtonText + "</button>");
		out.println("<p>Informatsioon andmebaasist: " + frontController.getDocumentController().getAllDocumentTypes() + " </p>");
		out.println("</body>");
		out.println("</html>");
	}

	public String getServletInfo() {
		return "DocServlet";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		doGet(request, response);
	}
}