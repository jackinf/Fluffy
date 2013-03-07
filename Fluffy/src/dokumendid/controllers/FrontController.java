package dokumendid.controllers;

public class FrontController {
	
	private DocumentController documentController;
	
	public FrontController()
	{
		documentController = new DocumentController();
	}
	
	public DocumentController getDocumentController()
	{
		return documentController;
	}

}
