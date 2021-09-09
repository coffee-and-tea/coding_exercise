package coffee_and_tea.coding_exercise.hackerrank.sherlock_anagrams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SherlockAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int anagramsCount = 0;

        // i is the length to compare from 1 to size of s - 1
        for(int i = 1; i < s.length(); i++) {

            // build size of i of substrings to compare from s
            final int finalI = i;
            var substrings = IntStream.range(0, s.length() + 1 - i)
                    .mapToObj(
                            j -> s.substring(j, j + finalI).chars().sorted().mapToObj(k -> String.valueOf((char)k)).collect(Collectors.joining())
                    ).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

           for(Long repeats:  substrings.values()) {
               anagramsCount += repeats * (repeats - 1) / 2;
           }
        }

        return anagramsCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
