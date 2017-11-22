package lessons;

import java.util.HashMap;
import java.util.HashSet;

/*
    https://codility.com/demo/results/training6NQF2P-QNV/
 */

// Time: O(N)
// Space: O(N)
// Performance 44%
public class OddOccurrencesInArray {

    public int solution1(int[] A){
        HashSet set = new HashSet<Integer>();
        int elem = -1;
        for (int el: A) {
            if (set.add(el)) {
                elem =el;
            }
        }
        return elem;
    }

    public int solution2(int[] A){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : A) {
            if( map.containsKey(el)) {
                map.put(el, 2);
            } else {
                map.put(el, 1);
            }
        }
        Result result = new Result();
        map.forEach((key, value) -> {
            if(value == 1) {
                result.oddElement = key;
            }
        });
        return result.oddElement;
    }
}
class Result {
    int oddElement;
}