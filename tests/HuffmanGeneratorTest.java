//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//import static org.junit.Assert.*;
//
//public class HuffmanGeneratorTest {
//
//	@Test
//	public void genCharArr() throws IOException {
//		HuffmanGenerator huffmanGenerator = new HuffmanGenerator();
//		final Integer[] size = {0};
//
//		LinkedHashMap<Character, Integer> linkedHashMap =huffmanGenerator.findFreq("Gadsby.txt");
//
//		linkedHashMap.values().forEach(e -> size[0] += e);
//
//		HuffmanNode root = huffmanGenerator.genNodes(linkedHashMap);
//
//		huffmanGenerator.genTree(root, new StringBuffer());
//
//
//		System.out.print(root.getFrq());
//	}
//
//
//}