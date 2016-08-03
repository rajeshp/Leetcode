package basic;

import java.util.List;

/**
 * Created by prajesh on 8/2/16.
 */
public class Trie {

    TrieNode root = new TrieNode();

    //only for ascii char based strings
    class TrieNode{
        TrieNode[] children = new TrieNode[256];
        boolean leaf=false;
    }

    private void add(TrieNode root, String s, int index){

        if(index < s.length() && root!=null){

            if(root.children[s.charAt(index)]==null){
                TrieNode temp = new TrieNode();
                root.children[s.charAt(index)]=temp;

                if(index==s.length()-1)
                    temp.leaf=true;
            }



                add(root.children[s.charAt(index)],s,index+1);
        }

  }


   public void add(String s){
       add(this.root, s, 0);
   }

    //prints all words stored in trie, useful for debugging
    public void printAllWords(TrieNode root, String s){

        if(root.leaf)
            System.out.println(s.toString());

        if(root!=null) {

            TrieNode[] children = root.children;




            for(int i=0;i<children.length;i++){
                if(children[i]!=null)
                    printAllWords(children[i], s+(char)i);
            }

        }
    }

    //find all strings starting with prefix
    List<String> search(TrieNode root, String prefix){

        int i=0;

        while(i<prefix.length()){

            root = root.children[prefix.charAt(i)];

            if(root==null)
                return null;

            i++;
        }

        printAllWords(root,prefix);

        return null;
    }

    boolean delete(String s){

    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("dog");
        trie.add("cat");
        trie.add("dodged");
        trie.add("catterpillar");
        trie.add("camping");


        //trie.printAllWords(trie.root,"");
        trie.search(trie.root,"ca");
        trie.search(trie.root,"dog");
    }

}
