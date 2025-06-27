/*Following all problem statements solve using generics 

(do not use collection framework- upload it on GitHub and share specific file link on chat)
 
1) Count Occurrence of Element

Explanation -> Given a generic array and target element ,count how many times the element appears
 
2)Liner Search

Explanation -> Given a generic array and target element ,return its index , if not found return -1
 
3)Find Minimum and Maximum from array

Explanation -> from array return Min and Max value
 */

public class CountOccurrence {
	
	public static <T> int count(T arr[] , T target ) {
		int c=0;
		for(T t : arr) {
			if (t.equals(target)) {
				c++;
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		String arr[]= {"Hii" ,"Hii" ,"Hello"};
		System.out.println(" 'Hii' Occurrce in array for "+CountOccurrence.count(arr, "Hii")+" times");
	}

}