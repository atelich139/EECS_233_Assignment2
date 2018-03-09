import java.io.IOException;

/**
 * HuffmanCompressor class is where the program generates the encoded output file and
 * where the main method is run.
 *
 * @author Alexander Telich
 */
public class HuffmanCompressor {
    
    /**
     * This method takes two files and generates a Huffman Encoding Table from one of
     * the files and then uses that table to compress the other file.
     *
     * @param toEncode   String file name of the file to use to make the encoding table.
     * @param toCompress String file name of the file that will be compressed.
     *
     * @throws IOException thrown if either of the files could not be read.
     */
    private static void compress(String toEncode, String toCompress) throws IOException {
        
        HuffmanGenerator encd = new HuffmanGenerator(toCompress);
        
        System.out.println(System.getProperty("a"));
        
        
    }
    
    /**
     * Main method to run the program.
     *
     * @param args String[] that contains the program's arguments.
     */
    public static void main(String[] args) {
        try {
            HuffmanCompressor.compress("Gadsby.txt", "Dictionary_rev.txt");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
