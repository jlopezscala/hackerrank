import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SolutionCompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> resultArray = new ArrayList<>();
        int totalAlice = 0;
        int totalBob = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                totalAlice++;
            } else if (a.get(i) < b.get(i)) {
                totalBob++;
            }
        }
        resultArray.add(totalAlice);
        resultArray.add(totalBob);

        return resultArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
        StringBuffer outputBuffer = new StringBuffer();
        result.stream()
                .map(i -> outputBuffer.append(i.toString()));

        System.out.println(outputBuffer.toString());

        bufferedReader.close();
    }
}

