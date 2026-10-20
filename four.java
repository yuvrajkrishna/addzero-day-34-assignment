import java.util.HashSet;

public class four {
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};
        int arr2 [] = {2,3,3,4};
        HashSet <Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            set.add(arr[i]);
        }
        for(int i = 0 ; i < arr2.length ; i++){
            set2.add(arr2[i]);
        }
        if(set.containsAll(set2)){
            System.out.println(true);
        }
        else{
        System.out.println(false);
        }
    }
}
