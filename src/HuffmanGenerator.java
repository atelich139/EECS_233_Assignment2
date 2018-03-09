import java.awt.*;
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
public class HuffmanGenerator {
    
    
    HuffmanGenerator(String fileName) throws IOException {
        final Integer[] origSize = {0};
        
        LinkedHashMap<Character, Integer> origMap = findFreq(fileName);
        
        origMap.values().forEach(e -> origSize[0] += Integer.valueOf(e.toString()));
        
        genEncode(genNodes(findFreq(fileName)), new StringBuffer());
        
    }
    
    private static LinkedHashMap<Character, Integer> findFreq(String inputName) throws
            IOException {
        LinkedHashMap<Character, Integer> freqMap, sortedFreqMap;
        
        Stream<String> lines = Files.lines(Paths.get(inputName));
        freqMap = lines
                .flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt))
                .filter(Character::isDefined).collect(LinkedHashMap::new, (m, c) -> m
                        .merge(c, 1, Integer::sum), LinkedHashMap::putAll);
        
        sortedFreqMap = freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal)
                                -> oldVal, LinkedHashMap::new));
        
        return sortedFreqMap;
    }
    
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
    
    
    public void genEncode(HuffmanNode n, StringBuffer code) {
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
