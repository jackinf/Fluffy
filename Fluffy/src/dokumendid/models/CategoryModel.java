package dokumendid.models;

public class CategoryModel {

	/*
	 * Declarations
	 */

	private Integer _categoryID;
	private String _catalogName;
	private Integer _level;
	private CategoryModel _parent;

	/*
	 * Setters
	 */
	
	public void setCategoryID(Integer categoryID) {
		_categoryID = categoryID;
	}

	public void setCatalogName(String catalogName) {
		_catalogName = catalogName;
	}

	public void setLevel(Integer level) {
		_level = level;
	}

	public void setParent(CategoryModel parent) {
		_parent = parent;
	}

	/*
	 * Getters
	 */
	
	public Integer getCategoryID() {
		return _categoryID;
	}
	
	public String getCatalogName() {
		return _catalogName;
	}

	public Integer getLevel() {
		return _level;
	}

	public CategoryModel getParent() {
		return _parent;
	}
}
