import java.util.HashSet;

public class six {
    public static void main(String[] args) {
        int arr[] = {1,2,1,3,4,3,6,5};
        int sum = 10;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            int required = sum - arr[i];
            if(set.contains(required)){
                System.out.println(true);
                return;
            }
            else{
                set.add(arr[i]);
            }
        }
        System.out.println(false);
    }
}
