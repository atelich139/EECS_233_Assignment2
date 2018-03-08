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
    
    public LinkedHashMap findFreq(String inputName) {
        List<Character> list = new LinkedList<>();
        LinkedHashMap<Character, Integer> freq = new LinkedHashMap<>();
        
        final Integer[] size = {0};
        
        try (Stream<String> lines = Files.lines(Paths.get(inputName))) {
            list = lines
                    .flatMap(line -> IntStream.range(0, line.length())
                            .mapToObj(line::charAt)).
                            filter(Character::isDefined)
                    .collect(Collectors.toList());
            freq = lines.flatMap(line -> IntStream.range(0, line.length()).mapToObj
                    (line::charAt)).filter(Character::isDefined).collect
                    (LinkedHashMap::new, (m, c) -> m .merge(c, 1, Integer::sum), LinkedHashMap::putAll);
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        freq.values().forEach(e -> size[0] += (Integer) e);
        origSize = size[0];
        System.out.print(list);
        System.out.print(freq);
        System.out.print(origSize);
    
        return freq;
    }
    
    public void genTree(LinkedHashMap frequencies) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        
        
        
        
        
    }
    
    
    
    
    
}
