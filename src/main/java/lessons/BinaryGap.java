package lessons;

import java.util.Arrays;

public class BinaryGap {
    public int solution(int N) {
        String binaryInt = Integer.toBinaryString(N);
        String[] splitted = binaryInt.split("1");
        return Arrays.stream(splitted)
                .map(String::length)
                .mapToInt(i -> i)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().solution(1041));
    }
}
