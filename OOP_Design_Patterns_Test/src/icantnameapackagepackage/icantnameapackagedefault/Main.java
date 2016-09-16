package icantnameapackagepackage.icantnameapackagedefault;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		EyeDeeIfier idifier = (EyeDeeIfier)BeanGetter.getBean("eyeDeeIfier");
		System.out.println(idifier.getId() + " " + idifier.getId() + " " + idifier.getId());
		idifier.resetId();
		FacebookFactory facebookFactory = (FacebookFactory)BeanGetter.getBean("facebookFactory");
		List<RelationshipModel> relationships = new ArrayList<RelationshipModel>();
		List<String> names = new ArrayList<String>();
		names.add("Dan");
		names.add("Josh");
		names.add("Praveen");
		for(String name: names){
			IFacebook facebook = facebookFactory.createFacebook();
			facebook.name(name);
			facebook.id(idifier.getId());
			RelationshipModel relationship = facebook.build();
			relationships.add(relationship);
		}
		for(RelationshipModel relation: relationships){
			System.out.println(relation.getName() + " with ID: " + relation.getId());
		}
	}

}
