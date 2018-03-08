import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class HuffmanGeneratorTest {
	
	@Test
	public void genCharArr() throws IOException {
		HuffmanGenerator huffmanGenerator = new HuffmanGenerator();
		
		LinkedHashMap<Character, Integer> linkedHashMap =huffmanGenerator.findFreq("Gadsby.txt");
		
		HuffmanNode root = huffmanGenerator.genTree(linkedHashMap);
		
		System.out.print(root.getLeft().getLeft().getRight().getLeft().getLeft().getFrq
                ());
		
//		System.out.print(root.getFrq());
	}
}