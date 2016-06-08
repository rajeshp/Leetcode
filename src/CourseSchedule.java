import java.util.*;

/**
 * Created by prajesh on 5/30/16.
 */
public class CourseSchedule {


    Set<Integer> whiteSet= new HashSet<>();
    Set<Integer> graySet= new HashSet<>();
    Set<Integer> blackSet= new HashSet<>();




    class Graph{

        int vertexes;

        Map<Integer, List<Integer>> adjList;

        Graph(int  x) {
            vertexes = x;
            adjList =  new HashMap<Integer,List<Integer>>();
        }

        public void addEdge(int source, int dest){

            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());


            adjList.get(source).add(dest);
        }

        List<Integer> getNeighbours(int source){
            return adjList.get(source);
        }

    }


    public static void main(String[] args) {

        CourseSchedule obj = new CourseSchedule();


        int[][] input = new int[2][2];

        input[0] = new int[]{0,1};
        input[1] = new int[]{1,0};



        obj.canFinish(5, input);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(numCourses);

        for(int i=0;i<prerequisites.length;i++){
                graph.addEdge(prerequisites[i][0],prerequisites[i][1]);
        }



        return dfs(graph);
    }

    boolean dfs(Graph graph){

        for(int i=0;i<graph.vertexes;i++)
            whiteSet.add(i);




        for(int vertex : whiteSet){

          if(!dfsVisit(graph, vertex,-1))
              return false;

        }

        for(int vertex : graySet){

            if(!dfsVisit(graph, vertex,-1))
                return false;

        }

        return true;
    }


    boolean dfsVisit(Graph graph, int source, int parent){

     if(whiteSet.contains(source)){

         whiteSet.remove(source);
         graySet.add(source);

         for(int neighbour : graph.getNeighbours(source)){
             if(graySet.contains(neighbour))
                 return false;

             if(whiteSet.contains(neighbour)){
                 dfsVisit(graph, neighbour, source);
             }

         }

     }

        blackSet.add(source);

        return true;
    }
}


