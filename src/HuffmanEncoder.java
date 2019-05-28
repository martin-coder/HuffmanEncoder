import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class HuffmanEncoder {

    private static final int INITIAL_AMOUNT = 256;    // 2 times 128 (all possible ASCII values) for max load factor of 0.50

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/SampleFile");

        Map charFreqMap = makeFreqMap(inputFile);



    }


    private static Map<Character, Integer> makeFreqMap(File inputFile) throws IOException {
        Map<Character, Integer> charFreqMap = new HashMap<Character, Integer>();

        InputStream inputStream = new FileInputStream(inputFile);
        Reader      bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream, StandardCharsets.US_ASCII));

        int data = bufferedReader.read();
        while (data != -1) {
            char c = (char) data;

            // If char exists in charFreqMap, add 1 to value
            if (charFreqMap.containsKey(c)) {
                charFreqMap.replace(c, (int) charFreqMap.get(c) + 1);
            }
            //  If char doesn't exist in charFreqMap, add it and initialize freq value to 1
            else {
                charFreqMap.put(c, 1);
            }
            data = bufferedReader.read();   //  Read next char
        }

        bufferedReader.close();

        return charFreqMap;
    }
}
