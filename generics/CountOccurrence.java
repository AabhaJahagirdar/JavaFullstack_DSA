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
    public static <T> int count(T[] a, T t) 
    {
        int c = 0;
        for (T x : a)
        if (x != null && x.equals(t)) c++;
        return c;
    }

    public static void main(String[] args) {
        Integer[] n = {1, 4, 2, 3};
        String[] s = {"a", "b", "a"};
        System.out.println(count(n, 2)); 
        System.out.println(count(s, "a")); 
    }
}