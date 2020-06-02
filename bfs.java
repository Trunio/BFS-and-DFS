import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list 
// representation 
class Graph
{
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists
    static String result2="";

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }


    // Constructor 
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph 
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }



    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
                result2 = result2 + "(" + v + "" + "," + n + ")" + " ";
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS()
    {
        String result="";
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i=0; i<V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);

    }


    // prints BFS traversal from a given source s 
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V];
        String result="";

        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it 
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it 
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                    result=result+"(" + s + "" + "," + n + ")" + " ";
                }
            }
        }
        System.out.println(result);
    }

    static Graph zczytajhelper(String txt) throws IOException {
        File f = new File(txt);     //Creation of File Descriptor for input file
        FileReader fr = new FileReader(f);   //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        int wiersz = -1;
        int miejsce = -1;

        while ((c = br.read()) != -1)         //Read char by Char
        {
            char character = (char) c;
            int numericValue = Character.getNumericValue(c);
            if (wiersz == -1 && miejsce == -1) {
              //  System.out.println(numericValue);
                Graph g = new Graph(numericValue);
                return g;
            }
        }
        return null;
    }


 static void zczytaj(String txt) throws IOException {
    File f = new File(txt);     //Creation of File Descriptor for input file
    FileReader fr = new FileReader(f);   //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
    int c = 0;
    int wiersz=-1;
    int miejsce=-1;

    Graph g = zczytajhelper(txt);
    while ((c = br.read()) != -1)         //Read char by Char
    {
        char character = (char) c;
        int numericValue = Character.getNumericValue(c);
        if(wiersz==-1 && miejsce==-1){
          //  System.out.println(numericValue);
        }

        if(numericValue==1){
            g.addEdge(wiersz,miejsce);
        //    System.out.println(wiersz + " " + miejsce);

        }

        if(c>=48 && c<=57){
            miejsce++;
        }

        if(c=='\n'){
            wiersz++;
            miejsce=0;
        }
        //converting integer to char//Display the Character
    }
  //  System.out.println("liczba wierszy" + wiersz + "liczba miejsc" + miejsce);
     System.out.println("BFS");
     g.BFS(0);
     System.out.println("-----------------------------");
     System.out.println("DFS");
     g.DFS();
     System.out.println(result2);
}


    // Driver method to 
    public static void main(String args[]) throws IOException {


    zczytaj("C:\\Users\\kondr\\Desktop\\Nowy folder\\algorytmy\\src\\test.txt");


    }


}
// This code is contributed by Aakas