package icantnameapackagepackage.icantnameapackagedefault;

public class EyeDeeIfier {
	
	private volatile int currentId = 0;
	
	public int getId(){
		return currentId++;
	}
	
	public void resetId(){
		currentId = 0;
	}
	
}
