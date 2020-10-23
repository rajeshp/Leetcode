import java.util.*;

public class WordLadder {

  public int ladderLength_old(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordset = new HashSet<>(wordList);

    Map<String, List<String>> map = new HashMap<>();

    for(int i=0;i<wordList.size();i++){
      List<String> listA = map.getOrDefault(wordList.get(i), new LinkedList<>());

      for(int j=i+1; j<wordList.size();j++){
        if(diff(wordList.get(i), wordList.get(j)) == 1){
          List<String> listB = map.getOrDefault(wordList.get(j), new LinkedList<>());
          listA.add(wordList.get(j));
          listB.add(wordList.get(i));
          map.put(wordList.get(j), listB);
        }

      }

      map.put(wordList.get(i), listA);
    }


    if(!map.containsKey(endWord)) return 0;


    int len=0, minlen=Integer.MAX_VALUE;

    if(map.containsKey(beginWord)){
//      minlen = minLadderLength(beginWord, endWord, map, new HashSet<String>(), 1);
        minlen = bfs(beginWord, endWord, map);
      //System.out.println(minlen);
    }else{
      for(int i=0;i<wordList.size();i++){
        if(diff(beginWord, wordList.get(i)) == 1){
          // System.out.println(wordList.get(i));
//          len = 1 + minLadderLength(wordList.get(i), endWord, map, new HashSet<String>(), 1);
            len = bfs(wordList.get(i), endWord, map);

            if(len == Integer.MAX_VALUE)
              minlen = Math.min(len, minlen);
            else
              minlen = Math.min(1 + len, minlen);

            System.out.println(len);

        }
      }
    }

    return  minlen < 0 || minlen > wordList.size() ? 0 : minlen;
  }

  // do dfs on graph
  int minLadderLength(String beginword, String endword, Map<String, List<String>> graph, Set<String> visited, int len){

    if(visited.contains(beginword) || visited.contains(endword)) return len;

    visited.add(beginword);

    if(beginword.equals(endword)){
      visited.remove(beginword);
      //System.out.println(endword);
      return len;
    }





    //System.out.print(beginword + " --> ");



    List<String> list = graph.get(beginword);

    int l=0, minlen=Integer.MAX_VALUE;

    for(String item : list){
      if(!visited.contains(item)){
        l = minLadderLength(item, endword, graph, visited, len+1);

        minlen = Math.min(minlen, l);
      }
    }



    visited.remove(beginword);



    return minlen;
  }


  class BFSItem{
    String id;
    int dist;

    BFSItem(String id, int dist){
      this.id = id;
      this.dist = dist;
    }
  }

  int bfs(String beginword, String endword, Map<String, List<String>> graph){

    Queue<BFSItem> queue = new ArrayDeque<>();

    Set<String> visited = new HashSet<>();

    queue.add(new BFSItem(beginword, 1));

    int mindist = Integer.MAX_VALUE;

    while(!queue.isEmpty()){

      BFSItem currnode = queue.poll();

      if(endword.equals(currnode.id)){
        return currnode.dist;
      }

      visited.add(currnode.id);

      for(String neighbor : graph.get(currnode.id)){
        if(!visited.contains(neighbor))
          queue.add(new BFSItem(neighbor, currnode.dist + 1));

      }

    }




    return  mindist;
  }


  int diff(String s1, String s2){
    int count=0;

    for(int i=0;i<s1.length();i++){
      if(s1.charAt(i) != s2.charAt(i))
        count++;
    }

    return count;
  }




  Map<String, List<String>> transformationMap(List<String> wordList){
    Map<String, List<String>> map = new HashMap<>();
    wordList.forEach( w -> {
      for(int i=0;i<w.length();i++){
        String key = w.substring(0, i) + "*" + w.substring(i+1);
        List<String> list = map.getOrDefault(key, new LinkedList<>());
        list.add(w);
        map.put(key, list);
      }
    });

    return map;
  }



  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    Map<String, List<String>> graph = transformationMap(wordList);

    //if(endWord.equals(beginWord)) return 1;

    Set<String> visited = new HashSet<>();

    Queue<BFSItem> queue = new ArrayDeque<>();
    queue.add(new BFSItem(beginWord,1));

    while(!queue.isEmpty()){

      BFSItem curr = queue.poll();

      if(endWord.equals(curr.id)) return curr.dist;

      visited.add(curr.id);

      for(int i=0;i<curr.id.length();i++){
        String key = curr.id.substring(0, i) + "*" + curr.id.substring(i+1);

        if(graph.containsKey(key)){
          List<String> neighbors = graph.get(key);

          for(String n : neighbors){
            if(!visited.contains(n)){
              queue.add(new BFSItem(n, curr.dist + 1));
            }
          }
        }

      }

    }



    return 0;
  }



  public static void main(String[] args) {

    WordLadder obj = new WordLadder();

    List<String> list = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
    System.out.println(obj.ladderLength("hit", "cog", list));



    List<String> list1= Arrays.asList(new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"});

    System.out.println(obj.ladderLength("qa", "sq", list1));

    List<String> list2 = Arrays.asList(new String[]{"cog"});

    System.out.println(obj.ladderLength("hog", "cog", list2));






    List<String> list3 = Arrays.asList(new String[]{"hot","dot","tog","cog"});

    System.out.println(obj.ladderLength("hit", "cog", list3));


  }

}
