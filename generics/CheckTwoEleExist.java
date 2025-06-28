/* 
6)Check if Two elements exists in array
  Given Generic array and two elements ,check if both exist in array and return index where it present
*/
public class CheckTwoEleExist {
    public static <T> int[] find(T[] arr,T target1,T target2){
	    int index[]= {-1,-1};
	    for(int i=0;i<arr.length;i++){
		    if (arr[i].equals(target1)){index[0]=i;}
		    if (arr[i].equals(target2)) { index[1]=i;}
	    }
	    return index;
    }

    public static <T>void display(T arr[] ,T target1,T target2)
    {
	    int []index = find(arr,target1, target2);
	    if(index[0]>=0 && index[1]>=0){
		    System.out.println("\n\nBoth are Present ");
		    System.out.println(target1+" at index "+index[0]);
		    System.out.println(target2+" at index "+index[1]);
	    }
	    else {
		    System.out.println("\n\nBoth are not Present");
	    }
    }

    public static void main(String[] args) {
	    Integer []arr= {10,20,30,40};
	    CheckTwoEleExist.display(arr, 10, 40);
    }
}