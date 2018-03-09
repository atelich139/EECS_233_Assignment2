/**
 * This class represents each node in the Huffman tree.
 *
 * @author Alexander Telich
 */
public class HuffmanNode {
    private Character inChar;
    private Integer frq;
    private HuffmanNode left, right;
    
    /**
     * Constructor for the HuffmanNode class. Instance fields and getter methods do not
     * differ from the definitions described in this comment.
     *
     * @param inChar Character that represents the node's character.
     * @param frq    Integer representing how number of times the character was in file.
     * @param left   HuffmanNode that is the left child of the current node.
     * @param right  HuffmanNode that is the right child of the current node.
     */
    public HuffmanNode(Character inChar, Integer frq, HuffmanNode left, HuffmanNode
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
    
    /**
     * Method to determine whether a HuffmanNode is a leaf node in the tree.
     *
     * @return boolean that is true if the node is a leaf, otherwise false.
     */
    public boolean isLeaf() {
        assert ((getLeft() == null) && (getRight() == null)) || ((getLeft() != null) &&
                getRight() != null);
        
        return getLeft() == null && getRight() == null;
    }
}
