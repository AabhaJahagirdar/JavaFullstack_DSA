public class GenCheckArr {
	
	public static <T> boolean check(T []arr ,T f ,T s) {
		int F=0,S=0;
		for(T t:arr) {
			if(t==f) {
				F=1;
			}
			if((t==s)) {
				S=1;
			}	
		}
		 
		return S==1&&F==1;
	}
	public static void main(String[] args) {
		String arr[]= {"hii" ,"Hello"};
		if(GenCheckArr.check(arr, "hii", "Hello")) {
			System.out.println("Both are Present");
		}
		else {
			System.out.println("Both are Not Present");
		}
	}
}