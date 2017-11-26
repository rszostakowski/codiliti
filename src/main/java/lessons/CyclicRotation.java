package lessons;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
https://codility.com/demo/results/trainingA4C4TK-JHG/

 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int[] movedArr = A;
        if(A.length != 0){
            while (K > 0) {
                movedArr = moveElementsByOnePlace(movedArr);
                K--;
            }
        }
        return movedArr;
    }

    private int[] moveElementsByOnePlace(int[] A) {
        int arrLength = A.length;
        int[] temp = new int[arrLength];
        temp[0] = A[arrLength - 1];
        IntStream.range(1, arrLength)
                .forEach(el -> temp[el] = A[el - 1]);
        return temp;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        System.out.println(Arrays.toString(new CyclicRotation().solution(A, 3)));
        System.out.println(Arrays.toString(new CyclicRotation().solution(A, 0)));

        int[] B = {-1, -2, -3, -4};
        System.out.println(Arrays.toString(new CyclicRotation().solution(B, 100)));


        System.out.println(Arrays.toString(new CyclicRotation().solution(new int[0], 100)));
    }
}
