package m11.task1;

interface Validation{
	public boolean isValid(String userName, String password);
}
public class Exercise3 {

	public static void main(String[] args) {
		Exercise3 obj = new Exercise3();
		obj.createValidation();

	}
	
	public void createValidation() {
		Validation v = (userName, password)-> userName.equals("Vaishnavi")&&
				password.equals("xyz");
		boolean res = v.isValid("Vaishnavi", "xyz");
		System.out.println("Validation:"+res);
		
	}
}
