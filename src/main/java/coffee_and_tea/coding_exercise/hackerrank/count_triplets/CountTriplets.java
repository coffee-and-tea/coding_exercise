package coffee_and_tea.coding_exercise.hackerrank.count_triplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        if(r == 1) {
            Map<Long, Integer> counts = new HashMap<>();
            for(Long val : arr) {
                counts.put(val, counts.getOrDefault(val, 0)+1);
            }
            return counts.values().stream().filter(i -> i > 2).mapToLong(
                    i -> LongStream.range(i-2, i+1).reduce(1, (a, b) ->  a*b)/6
            ).sum();
        } else {
            Map<Long, Integer> multipleRcount = new HashMap<>();
            Map<Long, Integer> multipleRRCount = new HashMap<>();
            long result = 0;
            for (Long val : arr) {
                multipleRcount.put(val * r, multipleRcount.getOrDefault(val * r, 0) + 1);
                multipleRRCount.put(val * r, multipleRRCount.getOrDefault(val * r, 0) + multipleRcount.getOrDefault(val, 0));
                result += multipleRRCount.getOrDefault(val, 0);
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}