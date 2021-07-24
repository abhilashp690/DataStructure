package Graph.GraphRepresentation.MatrixRepresentation;

public class AbstractAdjacencyMatrix {
        private int[][] matrix;

        public AbstractAdjacencyMatrix(int totalVertices) {
            matrix = new int[totalVertices][totalVertices];
        }

        public void addEdge(int source , int destination) {
            matrix[source][destination] = 1;
        }

        public int[][] getMatrix() {
            return matrix;
        }
}

