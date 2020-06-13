import java.util.*;
import java.lang.*;
public class Trie {
    static int ALPHABET_SIZE = 26;
    static class Trienode{
        Trienode children[] = new Trienode[ALPHABET_SIZE];
        int wc;//word : count
        Trienode(){
            wc = 0;
            for(int i = 0; i < ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }
    static Trienode root;
    public static void insert(String str)
    {
        Trienode temp = root;
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(temp.children[index] == null){
                temp.children[index] = new Trienode();
            }
            temp = temp.children[index];
        }
        temp.wc = temp.wc + 1;
    }
    public static boolean search(String str)
    {
        Trienode temp = root;
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(temp.children[index] == null)
                return false;
            temp = temp.children[index];
        }
        return (temp != null && temp.wc > 0);
    }
    static void Triedelete(String str)
    {
        if(search(str))
        {
            Trienode temp = root;
            for(int i=0; i < str.length(); ++i)
            {
                int index = str.charAt(i) - 'a';
                temp.children[index].wc -=1;
                temp = temp.children[index];
            }
        }
    }
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case) 
        String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
        root = new Trienode(); 
       
        // Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
            insert(keys[i]); 
       
        // Search for different keys 
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("an") == true) 
            System.out.println("an --- " + output[1]); 
        else System.out.println("an --- " + output[0]); 
          
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
        
        System.out.println("Deleting Node Preocessing.....");
        Triedelete("an");
        Triedelete("their");
        System.out.println("Done...");
        if(search("an") == true) 
            System.out.println("an --- " + output[1]); 
        else System.out.println("an --- " + output[0]); 
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
        
        System.out.println("Inserting 'their' in trie...");
        insert("their");
         if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
        
        
    }
}
