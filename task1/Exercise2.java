package m11.task1;

import java.util.Scanner;

interface AddSpaces {
	public String getSpacesAdded(String str);
}
public class Exercise2 {

	public static void main(String[] args) {
		Exercise2 obj = new Exercise2();
		obj.generateSpace();

	}
	public void generateSpace() {
		AddSpaces a = (s)->{
			char c[]= s.toCharArray();
			StringBuffer s1 = new StringBuffer();
			for(char i:c) {
				s1.append(i);
				s1.append(' ');
			}
			String s2 = s1.toString();
			return s2;
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:\n");
		String str = new String(sc.nextLine());
		String res = a.getSpacesAdded(str);
		System.out.println("Answer :"+res);
	}

}
