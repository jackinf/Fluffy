package dokumendid.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import dokumendid.controllers.FrontController;
import dokumendid.helpers.TableDrawer;

@SuppressWarnings("serial")
public class DocServlet extends HttpServlet {

	/*
	 * Declarations
	 */
	private FrontController frontController;

	/**
	 * Initialization of HttpServlet
	 */
	public void init() {
		frontController = new FrontController();
	}

	/**
	 * HTTP Get
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Locale[] supportedLocales = { new Locale("et", "ESTONIA"),
				Locale.ENGLISH };
		Locale currentLocale = supportedLocales[0];
		ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle",
				currentLocale);
		String ButtonText = labels.getString("LABEL_RUNDOCQUERY_BUTTON");

		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/rakarh1.css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Dokumendid (from servlet)</p><button>" + ButtonText
				+ "</button>");

		// Database test: gets documents from database and outputs into HTML
		// table
		out.println("<p>Informatsioon andmebaasist: "
				+ TableDrawer.DrawDocumentTable(frontController
						.getDocumentController().getAllDocumentTypes())
				+ " </p>");

		// Authentication test: gets true or false depending on username and
		// password
		out.println("<p>Username: juhan<br />Password: juhan<br />Is it correct: "
				+ frontController.getPersonController().Login("juhan", "juhan")
				+ "</p>");
		out.println("<p>Username: juhan<br />Password: tanel<br />Is it correct: "
				+ frontController.getPersonController().Login("juhan", "tanel")
				+ "</p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * Server Info
	 */
	public String getServletInfo() {
		return "DocServlet";
	}

	/**
	 * HTTP Post
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
}