import java.io.File

class Graph {
    private val edges = mutableListOf<Edge>()
    private val _cities = mutableSetOf<String>() // Backing field for private data

    // Expose cities as a read-only property
    val cities: Set<String> get() = _cities

    // Add an edge to the graph
    fun addEdge(city1: String, city2: String, distance: Int) {
        edges.add(Edge(city1, city2, distance))
        _cities.add(city1)
        _cities.add(city2)
    }

    // Load edges from a file
    fun loadFromFile(filename: String) {
        File(filename).forEachLine { line ->
            val parts = line.split(",").map { it.trim() }
            if (parts.size == 3) {
                val city1 = parts[0]
                val city2 = parts[1]
                val distance = parts[2].toInt()
                addEdge(city1, city2, distance)
            }
        }
    }

    // Calculate MST using Kruskal's Algorithm
    fun calculateMST(): Pair<List<Edge>, Int> {
        val parent = mutableMapOf<String, String>()
        val rank = mutableMapOf<String, Int>()

        // Helper function to find the root of a city
        fun find(city: String): String {
            if (parent[city] != city) {
                parent[city] = find(parent[city]!!) // Path compression
            }
            return parent[city]!!
        }

        // Helper function to union two sets
        fun union(city1: String, city2: String) {
            val root1 = find(city1)
            val root2 = find(city2)
            if (root1 != root2) {
                if (rank[root1]!! > rank[root2]!!) {
                    parent[root2] = root1
                } else if (rank[root1]!! < rank[root2]!!) {
                    parent[root1] = root2
                } else {
                    parent[root2] = root1
                    rank[root1] = rank[root1]!! + 1
                }
            }
        }

        // Initialize union-find data structure
        _cities.forEach { city ->
            parent[city] = city
            rank[city] = 0
        }

        // Kruskal's algorithm
        val mstEdges = mutableListOf<Edge>()
        var totalDistance = 0

        edges.sorted().forEach { edge ->
            if (find(edge.city1) != find(edge.city2)) {
                union(edge.city1, edge.city2)
                mstEdges.add(edge)
                totalDistance += edge.distance
            }
        }

        return Pair(mstEdges, totalDistance)
    }
}
