import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class HuffmanGeneratorTest {
	
	@Test
	public void genCharArr() {
		HuffmanGenerator huffmanGenerator = new HuffmanGenerator();
		
		huffmanGenerator.findFreq("Gadsby.txt");
		
//		huffmanGenerator.genTree(frequencies);
		
	}
}