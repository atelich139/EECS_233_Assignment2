/**
 * This class represents each node in the Huffman tree.
 *
 * @author Alexander Telich
 */
public class HuffmanNode {
	private Character inChar;
	private Integer frq;
	private HuffmanNode left, right;
	
	public HuffmanNode (Character inChar, Integer frq, HuffmanNode left, HuffmanNode
			right) {
		this.inChar = inChar;
		this.frq = frq;
		this.left = left;
		this.right = right;
	}
    
    public Character getInChar() {
        return inChar;
    }
    
    public Integer getFrq() {
        return frq;
    }
    
    public HuffmanNode getLeft() {
        return left;
    }
    
    public HuffmanNode getRight() {
        return right;
    }
    
    public boolean isLeaf() {
	    assert ((getLeft() == null) && (getRight() == null)) || ((getLeft() != null) &&
                getRight() != null);
	    
	    return getLeft() == null && getRight() == null;
    }
    
    public int compareTo(HuffmanNode n) {
	    return this.getFrq() - n.getFrq();
    }
    
}
