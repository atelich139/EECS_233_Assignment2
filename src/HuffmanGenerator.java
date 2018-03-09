import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The HuffmanGenerator class creates a Huffman Encoded file based on an inputted ASCII
 * encoded file.
 *
 * @author Alexander Telich
 */
class HuffmanGenerator {
    
    /**
     * Constructor declaration for generating the Huffman table encoding values from an
     * inputted file.
     *
     * @param fileName String that represents the file name.
     *
     * @throws IOException If the file was unable to be read.
     */
    HuffmanGenerator(String fileName) throws IOException {
        final Integer[] origSize = {0};
        LinkedHashMap<Character, Integer> origMap = findFreq(fileName);
        
        origMap.values().forEach(e -> origSize[0] += Integer.valueOf(e.toString()));
        genEncode(genNodes(findFreq(fileName)), new StringBuffer());
    }
    
    /**
     * This method scans the inputted file and then generates a LinkedHashMap of
     * Characters and their frequencies. I used a LinkedHashMap because I wanted to
     * maintain the sorted input order that results from using '.sorted(
     * .comparingByValue())'.
     *
     * @param inputName String that represents the file name.
     *
     * @return LinkedHashMap of the Characters and their frequencies.
     * @throws IOException If the file is not able to be read.
     */
    private static LinkedHashMap<Character, Integer> findFreq(String inputName) throws
            IOException {
        LinkedHashMap<Character, Integer> freqMap, sortedFreqMap;
        
        Stream<String> lines = Files.lines(Paths.get(inputName));
        freqMap = lines
                .flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt))
                .filter(Character::isDefined).collect(LinkedHashMap::new, (m, c) -> m
                        .merge(c, 1, Integer::sum), LinkedHashMap::putAll);
        
        /* Sorts the frequency map in ascending order of frequencies*/
        sortedFreqMap = freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal)
                                -> oldVal, LinkedHashMap::new));
        
        return sortedFreqMap;
    }
    
    /**
     * Method to generate each HuffmanNode from the sorted frequency map.
     *
     * @param sortedFreqMap LinkedHashMap that has the characters and their frequencies.
     *
     * @return HuffmanNode connected to the other HuffmanNodes in the tree.
     */
    private static HuffmanNode genNodes(LinkedHashMap sortedFreqMap) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(Comparator
                .comparingInt(HuffmanNode::getFrq));
        
        sortedFreqMap.forEach((u, v) -> queue
                .add(new HuffmanNode((Character) u, (Integer) v, null, null)));
        
        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode(null, left.getFrq() + right
                    .getFrq(), left, right);
            
            queue.add(parent);
        }
        return queue.poll();
    }
    
    /**
     * The method to generate the Huffman encoding table. I used the System level
     * 'setProperty' to generate a sort of HashMap of the Characters and their codes
     * that can be used throughout this project structure.
     *
     * @param n    HuffmanNode that starts at the root of the tree.
     * @param code StringBuffer that was used to generate the codes for each Character.
     */
    private void genEncode(HuffmanNode n, StringBuffer code) {
        if (n.isLeaf()) {
            System.setProperty(String.valueOf(n.getInChar()), String.valueOf(code));
        }else {
            code.append('0');
            genEncode(n.getLeft(), code);
            code.deleteCharAt(code.length() - 1);
            
            code.append('1');
            genEncode(n.getRight(), code);
            code.deleteCharAt(code.length() - 1);
        }
    }
}
