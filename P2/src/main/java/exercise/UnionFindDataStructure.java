package main.java.exercise;
public class UnionFindDataStructure {

    private StudentSolutionImplementation studentSolutionImplementation;
    private int[] parents;

    public UnionFindDataStructure(StudentSolutionImplementation studentSolutionImplementation, int[] parents) {
        this.studentSolutionImplementation = studentSolutionImplementation;
        this.parents = parents;
    }

    public void makeset(int vertexId) {
        parents[vertexId] = vertexId;
    }

    public void union(int representativeId1, int representativeId2) {
        parents[representativeId1] = representativeId2;
    }

    public int findset(int vertexId) {
        return this.studentSolutionImplementation.findset(this, vertexId);
    }

    public int getParent(int vertexId) {
        return parents[vertexId];
    }
}
