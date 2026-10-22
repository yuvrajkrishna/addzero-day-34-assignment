import java.util.HashMap;
import java.util.Map;

public class five {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 1, 2, 3, 4, 5 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry me : map.entrySet()) {
            System.out.println(me.getKey() + " " + me.getValue());
        }
    }
}
