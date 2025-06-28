import java.util.Arrays;
/*4)Check if an array is sorted
    Given generic array, check if it is sorted in non-descending order
*/
public class ArrSortCheck {
public static <T> boolean isShorted(T[] arr)
{
	for (int i=1;i<arr.length;i++) {
		if((int)arr[i-1]>(int)arr[i]) {
			return false;
		}
	}
	return true;
	
}

public static void main(String[] args) {

	Integer arr[] = {20,10,30,40};
	Arrays.sort(arr); //Sorting the array 
	if(ArrSortCheck.isShorted(arr)) {
		System.out.println("\n\nSorted");//Output 
	}else {
		System.out.println("\n\nNot sorted");
	}
}
}