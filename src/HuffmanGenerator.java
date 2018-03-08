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
    
    /** This is the size of the alphabet in ASCII */
    private static final int n = 256;
    private Integer origSize = 0;
    
    public HuffmanGenerator() {
    }
    
    public LinkedHashMap findFreq(String inputName) throws IOException {
        LinkedHashMap<Character, Integer> freqMap, sortedFreqMap;
        
        final Integer[] size = {0};
        
        Stream<String> lines = Files.lines(Paths.get(inputName));
        freqMap = lines
                .flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt))
                .filter(Character::isDefined).collect(LinkedHashMap::new, (m, c) -> m
                        .merge(c, 1, Integer::sum), LinkedHashMap::putAll);
        
        sortedFreqMap = freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal)
                                -> oldVal, LinkedHashMap::new));
        
        freqMap.values().forEach(e -> size[0] += (Integer) e);
        origSize = size[0];
        
        return sortedFreqMap;
    }
    
    public HuffmanNode genTree(LinkedHashMap freqMap) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(Comparator
                .comparingInt(HuffmanNode::getFrq));
        
        freqMap.forEach((u, v) -> queue
                .add(new HuffmanNode((Character) u, (Integer) v, null, null)));
        
        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode(null, left.getFrq() + right.getFrq()
                    , left, right);
            queue.add(parent);
        }
        
        
        return queue.poll();
    }
    
    
}
