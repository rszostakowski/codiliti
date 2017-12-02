package lessons;

import java.util.Arrays;
/*
https://codility.com/demo/results/training7ZCM8U-BEP/
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        TapeSums tapeSums = new TapeSums();
        tapeSums.rightSum = Arrays.stream(A).sum();

        int el = 0;
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 2) {
            return Math.abs(A[0] - A[1]);
        }

        while(Math.abs(tapeSums.leftSum - tapeSums.rightSum) <= tapeSums.minDiff && el <= A.length -1) {
            tapeSums.minDiff = Math.abs(tapeSums.leftSum - tapeSums.rightSum);
            tapeSums.leftSum = tapeSums.leftSum + A[el];
            tapeSums.rightSum = tapeSums.rightSum - A[el];
            el++;
        }
        return tapeSums.minDiff;
    }
}
class TapeSums {
    int leftSum = 0;
    int rightSum = 0;
    int minDiff = Integer.MAX_VALUE;
}