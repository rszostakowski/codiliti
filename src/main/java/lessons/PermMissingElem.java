package lessons;

import java.util.Arrays;
/*
https://codility.com/demo/results/trainingKUHERF-RW8/
 */
public class PermMissingElem {
    public int solution(int[] A) {
        Container container = new Container();
        return Arrays.stream(A)
                .sorted()
                .filter(obj -> isCurrentNumBiggerThanPrevious(obj, container))
                .map(el -> el - 1)
                .findFirst()
                .orElseGet(() -> {
                    if (A.length != 0) {
                        return A[A.length - 1] + 1;
                    }
                    return 1;
                });
    }

    private boolean isCurrentNumBiggerThanPrevious(int obj, Container container) {
        if (obj != container.previous + 1) {
            return true;
        }
        container.previous = obj;
        return false;
    }
}

class Container {
    int previous = 0;
}