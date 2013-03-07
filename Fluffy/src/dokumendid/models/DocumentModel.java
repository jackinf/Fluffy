package dokumendid.models;

public class DocumentModel {

	/*
	 * Declarations
	 */

	private String _name;
	private String _description;
	private String _senders;
	private Integer _answerDate;
	private String _format;
	private String _documentType;

	/*
	 * Setters
	 */

	public void setName(String name) {
		_name = name;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setSenders(String senders) {
		_senders = senders;
	}

	public void setAnswerDate(Integer answerDate) {
		_answerDate = answerDate;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public void setDocumentType(String documentType) {
		_documentType = documentType;
	}

	/*
	 * Getters
	 */

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}

	public String getSenders() {
		return _senders;
	}

	public Integer getAnswerDate() {
		return _answerDate;
	}

	public String getFormat() {
		return _format;
	}

	public String getDocumentType() {
		return _documentType;
	}

}
