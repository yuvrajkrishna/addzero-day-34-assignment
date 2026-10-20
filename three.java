import java.util.HashSet;

public class three {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,4};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();
         for (int i = 0; i < arr.length; i++) {
            if(!set.add(arr[i])){
                dup.add(arr[i]);
            }
            else{
                set.add(arr[i]);
            }
        }
        for(int i = 0 ; i < arr.length;  i++){
            if(!dup.contains(arr[i])){
                System.out.println(arr[i]);
            }
        }
        
    }
}
