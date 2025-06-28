/*
5)Find middle element
  Given generic array, return the middle element
*/
public class FindMiddleElement {
	public static <T> String findMid(T t[]){
		int midIndex = t.length;
		return (midIndex % 2 ==0)?"Mid Elements are "+t[midIndex/2-1]+" And "+t[midIndex/2]: "Mid Element is "+t[midIndex/2];
	}

	public static void main(String[] args) {
		String []str= {"APPLE","BANANA","CAT","DOG","COW","GOAT"};
		System.out.println("\n\n\n"+FindMiddleElement.findMid(str));
	}
}