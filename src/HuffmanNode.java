/**
 * This class represents each node in the Huffman tree.
 *
 * @author Alexander Telich
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
	private Character inChar;
	private Integer frq;
	private HuffmanNode left;
	private HuffmanNode right;
	
	public HuffmanNode (Character inChar, Integer frq, HuffmanNode left, HuffmanNode
			right) {
		this.inChar = inChar;
		this.frq = frq;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int compareTo(HuffmanNode o) {
		return this.frq - o.frq;
	}
	
}
