import java.util.*;
import java.lang.*;
public class CountNoOfDistinctRowinBinaryMatrix {
    static int BINARY_SIZE = 2; //for 0 and 1
    static class Trienode{
        Trienode children[] = new Trienode[BINARY_SIZE];
        int wc;//word : count
        Trienode(){
            wc = 0;
            for(int i = 0; i < BINARY_SIZE; i++){
                children[i] = null;
            }
        }
    }
    static Trienode root;
    public static boolean insert(String str)
    {
        //System.out.println(str);
        Trienode temp = root;
        boolean flag = false;
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i)-'0';
            //System.out.println(index+" ==");
            if(temp.children[index] == null){
                temp.children[index] = new Trienode();
                flag = true;
            }
            temp = temp.children[index];
        }
        if(flag == true)
             temp.wc = temp.wc + 1;
        return flag;
    }
    
    public static void main(String args[])
    {
        // Given Matix with Binary Values
        
        
        //m X n matrix---> 4 X 4
        //String keys[] = {"1000","1001","1000","0001"}; 
        
        //m X n matrix---> 6 X 6
        String keys[] = {"100000","100100","100101","100001","10000","100100"}; 
        
        root = new Trienode(); 
        // Construct trie 
        int i; 
        int count = 0;
        for (i = 0; i < keys.length ; i++) 
            if(insert(keys[i]))
                count++;
        System.out.println("No of Distinct row in Binary Matrix : "+count);
       
    }
}