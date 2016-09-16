package icantnameapackagepackage.icantnameapackagedefault;

public class Facebook implements IFacebook{
	
	private RelationshipModel relationshipModel;
	
	public Facebook() {
		relationshipModel = new RelationshipModel();
	}
	
	@Override
	public Facebook name(String name) {
		relationshipModel.setName(name);
		return this;
	}
	
	@Override
	public Facebook id(int id) {
		relationshipModel.setId(id);
		return this;
	}

	@Override
	public RelationshipModel build() {
		return relationshipModel;
	}
}
