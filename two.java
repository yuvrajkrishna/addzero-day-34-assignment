import java.util.HashSet;
import java.util.Set;

public class two {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,4};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }
}
