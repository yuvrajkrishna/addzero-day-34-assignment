import java.util.HashMap;
import java.util.Map;

public class seven {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 1, 3, 1, 3, 3, 5 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int max = 0;

        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            int curr = me.getValue();

            if (curr > max) {
                max = me.getKey();
            }
        }
        System.out.println(max);
    }
}
