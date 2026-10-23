import java.util.HashMap;

class eight {
    public static void main (String args[]) {
        int arr1[] =  {1,2,2,2,1,3,4};
        int arr2[] = {2,2,2,1,1,3,4};
        if (arr1.length != arr2.length) {
            System.out.println(false);
            return ;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i])) {
                System.out.println(false);
                return;
            }
            map.put(arr2[i], map.get(arr2[i]) - 1);
            if (map.get(arr2[i]) < 0) {
                System.out.println(false);
                return ;
            }
        }
        System.out.println(true);
    }
}