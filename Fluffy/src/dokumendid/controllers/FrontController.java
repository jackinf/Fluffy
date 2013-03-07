package dokumendid.controllers;

public class FrontController {

	private DocumentController _documentController;
	private PersonController _personController;

	public FrontController() {
		_documentController = new DocumentController();
		_personController = new PersonController();
	}

	public DocumentController getDocumentController() {
		return _documentController;
	}
	
	public PersonController getPersonController() {
		return _personController;
	}

}
