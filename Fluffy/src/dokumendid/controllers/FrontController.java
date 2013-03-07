package dokumendid.controllers;

public class FrontController {

	/*
	 * Declarations
	 */

	private DocumentController _documentController;
	private PersonController _personController;

	/*
	 * Constructor
	 */

	public FrontController() {
		_documentController = new DocumentController();
		_personController = new PersonController();
	}

	/*
	 * Getters
	 */

	public DocumentController getDocumentController() {
		return _documentController;
	}

	public PersonController getPersonController() {
		return _personController;
	}

}
