data class Edge(val city1: String, val city2: String, val distance: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int = this.distance.compareTo(other.distance)
}
