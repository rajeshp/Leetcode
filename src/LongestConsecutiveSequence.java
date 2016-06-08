import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 6/7/16.
 */
public class LongestConsecutiveSequence {

    class UnionFind{

        class Node{
            int val;
            Node parent;
            int rank;

            Node(int x){
                val = x;
                rank=1;
            }

        }

        Map<Integer, Node> map = new HashMap<>();


        public void makeSet(int x){
            Node node = new Node(x);
            map.put(x, node);
        }

        public Node findSet(int x){
            Node node=map.get(x);

            if(node==null)
                return null;

            Node root=node;

            while(root.parent!=null){
                root=root.parent;
            }

            node.parent=root;

            return root;
        }

        public Node union(int a, int b){
            Node rootA = findSet(a);
            Node rootB = findSet(b);

            if(rootA.rank>rootB.rank){
                rootB.parent=rootA;
                rootA.rank++;

            }else{
                rootA.parent=rootB;
                rootB.rank++;
            }

            return null;
        }

        public int findMaxRank(){

            int max=0;

            for(int n : map.keySet()){
                if(map.get(n).rank > max)
                    max=map.get(n).rank;
            }

            return max;
        }


    }



    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();


        UnionFind unionFind = new UnionFind();

        for(int i=0;i<nums.length;i++){

            UnionFind.Node prev = unionFind.findSet(nums[i]-1);

            UnionFind.Node next = unionFind.findSet(nums[i]+1);


            if(prev==null && next==null)
                unionFind.makeSet(nums[i]);
            else
                if(prev!=null){
                    unionFind.union(nums[i-1],nums[i]);

                }
            else
                if(next!=null){
                    unionFind.union(nums[i],nums[i+1]);
                }


        }


        return unionFind.findMaxRank();
    }



    public static void main(String[] args) {

        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        System.out.println(lcs.longestConsecutive(new int[]{100,4,200,2,3,1}));

    }

}
