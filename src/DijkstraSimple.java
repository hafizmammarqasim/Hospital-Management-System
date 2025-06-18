public class DijkstraSimple {
final int INF = 999999;

private final String[] nodeNames = {
        "Hospital", "Johar Town", "Ali Town", "Canal View", "UET", "Sanda",
        "Samanabad", "GPO", "Anarkali", "High Court", "GCU"
};

private final int numNodes = nodeNames.length;

private final int[][] graph = new int[numNodes][numNodes];

public DijkstraSimple() {
    for (int i = 0; i < numNodes; i++) {
        for (int j = 0; j < numNodes; j++) {

            if (i == j)
                graph[i][j] = 0;
            else
                graph[i][j] = INF;

        }
    }


    setEdge("Hospital", "Johar Town", 5);
    setEdge("Hospital", "Ali Town", 8);
    setEdge("Johar Town", "Canal View", 4);
    setEdge("Ali Town", "Canal View", 3);
    setEdge("Canal View", "UET", 6);
    setEdge("UET", "Sanda", 2);
    setEdge("Sanda", "Samanabad", 4);
    setEdge("Samanabad", "GPO", 3);
    setEdge("GPO", "Anarkali", 2);
    setEdge("Anarkali", "High Court", 2);
    setEdge("High Court", "GCU", 3);
    setEdge("Johar Town", "Samanabad", 10);
    setEdge("Ali Town", "Sanda", 9);
    setEdge("GCU", "Hospital", 12); // Return edge
}

private void setEdge(String from, String to, int distance) {
    int i = getIndex(from);
    int j = getIndex(to);
    if (i != -1 && j != -1) {
        graph[i][j] = distance;
    }
}

public void displayLocationMenu() {
    for (int i = 1; i < numNodes; i++) {
        System.out.println(i + ". " + nodeNames[i]);
    }
}

public int getNumNodes() {
    return numNodes;
}

public String getLocationName(int index) {
    return nodeNames[index];
}

private int getIndex(String name) {
    for (int i = 0; i < numNodes; i++) {
        if (nodeNames[i].equalsIgnoreCase(name)) {
            return i;
        }
    }
    return -1;
}

public void dijkstra(String startName, String endName) {
    int start = getIndex(startName);
    int end = getIndex(endName);

    if (start == -1 || end == -1) {
        System.out.println("Invalid start or end location.");
        return;
    }

    int[] dist = new int[numNodes];
    boolean[] visited = new boolean[numNodes];
    int[] prev = new int[numNodes];

    for (int i = 0; i < numNodes; i++) {
        dist[i] = INF;
        visited[i] = false;
        prev[i] = -1;
    }

    dist[start] = 0;

    for (int i = 0; i < numNodes - 1; i++) {
        int u = getMinIndex(dist, visited);
        if (u == -1) break;

        visited[u] = true;

        for (int v = 0; v < numNodes; v++) {
            if (!visited[v] && graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
                prev[v] = u;
            }
        }
    }

    System.out.println("\n📍 Shortest path from " + startName + " to " + endName + ":");
    if (dist[end] == INF) {
        System.out.println("No path.");
    } else {
        printPath(prev, end);
        System.out.println("\nDistance: " + dist[end] + " km");
    }
}

private int getMinIndex(int[] dist, boolean[] visited) {
    int min = INF, idx = -1;
    for (int i = 0; i < numNodes; i++) {
        if (!visited[i] && dist[i] < min) {
            min = dist[i];
            idx = i;
        }
    }
    return idx;
}

private void printPath(int[] prev, int current) {
    if (prev[current] == -1) {
        System.out.print(nodeNames[current]);
        return;
    }
    printPath(prev, prev[current]);
    System.out.print(" → " + nodeNames[current]);
}
}
