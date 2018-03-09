import java.io.IOException;

public class HuffmanCompressor {
    
    private static void compress(String toEncode, String toCompress) throws IOException {
        
        HuffmanGenerator encd = new HuffmanGenerator(toCompress);
        
        System.out.println(System.getProperty("a"));
        
        
        
        
        
    }
    
    
    public static void main(String[] args) {
        try {
            HuffmanCompressor.compress("Gadsby.txt", "Dictionary_rev.txt");
        }catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    
    
}
