import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Main {
    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static void main(String[] args) {
        blockChain.add(new Block("Hi im the first block", "0")); // Changed blockchain to blockChain
        blockChain.add(new Block("Yo im the second block", blockChain.get(blockChain.size() - 1).hash)); // Changed blockchain to blockChain
        blockChain.add(new Block("Hey im the third block", blockChain.get(blockChain.size() - 1).hash)); // Changed blockchain to blockChain

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain); // Added import for Gson
        System.out.println(blockchainJson);
    }
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}