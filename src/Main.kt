fun main() {
    val graph = Graph()

    while (true) {
        println("\nMenu:")
        println("1. Load Data")
        println("2. Calculate Minimum Spanning Tree (MST)")
        println("3. Exit")
        print("Enter your choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter the file name (e.g., distances.txt): ")
                val filename = readLine()
                if (!filename.isNullOrBlank()) {
                    try {
                        graph.loadFromFile(filename)
                        println("Data loaded successfully from $filename.")
                    } catch (e: Exception) {
                        println("Error loading file: ${e.message}")
                    }
                } else {
                    println("Invalid file name.")
                }
            }
            2 -> {
                if (graph.cities.isEmpty()) {
                    println("No data loaded. Please load data first.")
                } else {
                    println("Calculating Minimum Spanning Tree (MST)...")
                    val (mstEdges, totalDistance) = graph.calculateMST()
                    println("Minimum Spanning Tree:")
                    mstEdges.forEach { edge ->
                        println("${edge.city1} - ${edge.city2}: ${edge.distance} km")
                    }
                    println("Total Cable Length Required: $totalDistance km")
                }
            }
            3 -> {
                println("Exiting program. Goodbye!")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}
