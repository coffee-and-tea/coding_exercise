package coffee_and_tea.coding_exercise.hackerrank.frequency_queries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(List<Integer> query: queries) {
            System.out.println("Processing query: " + query.get(0) + " " + query.get(1));

            switch(query.get(0)) {
                case 1:
                    int currentFrequency = frequency.getOrDefault(query.get(1), 0);
                    frequency.put(query.get(1), currentFrequency + 1);
                    if(currentFrequency != 0) {
                        if( frequencyCount.get(currentFrequency) == 1)
                            frequencyCount.remove(Integer.valueOf(currentFrequency));
                        else
                            frequencyCount.put(currentFrequency, frequencyCount.get(currentFrequency) - 1);
                    }
                    frequencyCount.put(currentFrequency+1, frequencyCount.getOrDefault(currentFrequency+1, 0) + 1);
                    break;
                case 2:
                    int currentFrequencyValue = frequency.getOrDefault(query.get(1), 0);
                    frequency.put(query.get(1), max(currentFrequencyValue - 1, 0));
                    if(currentFrequencyValue != 0) {
                        if( frequencyCount.get(currentFrequencyValue) == 1 ) {
                            frequencyCount.remove(Integer.valueOf(currentFrequencyValue));
                        } else {
                            frequencyCount.put(currentFrequencyValue, frequencyCount.get(currentFrequencyValue) - 1);
                        }
                        if(currentFrequencyValue != 1)
                            frequencyCount.put(currentFrequencyValue-1, frequencyCount.getOrDefault(currentFrequencyValue-1, 0) + 1);

                    }
                    break;
                case 3:
                    result.add(
                                frequencyCount.containsKey(query.get(1)) ? 1 : 0
                    );
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
