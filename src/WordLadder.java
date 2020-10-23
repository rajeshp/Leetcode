import java.util.*;

public class WordLadder {

  class BFSItem{
    String id;
    int dist;

    BFSItem(String id, int dist){
      this.id = id;
      this.dist = dist;
    }
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
