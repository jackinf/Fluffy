package dokumendid.controllers;

public class FrontController {

	/*
	 * Declarations
	 */

	private DocumentController _documentController;
	private PersonController _personController;
	private TreeController _treeController;

	/*
	 * Constructor
	 */

	public FrontController() {
		_documentController = new DocumentController();
		_personController = new PersonController();
		_treeController = new TreeController();
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
	
	public TreeController getTreeController() {
		return _treeController;
	}

}
