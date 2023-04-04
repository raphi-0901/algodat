package main.java.exercise;

import main.java.framework.InstanceSet;
import main.java.framework.graph.GraphUtil;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.*;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.Map;


public class InstanceSetImplementation extends InstanceSet<InstanceImplementation, StudentSolutionImplementation, ResultImplementation, VerifierImplementation, SimpleWeightedGraph<VertexImplementation, EdgeImplementation>> {

    public InstanceSetImplementation(Path instanceSetPath, Path outputPath) {
        super(instanceSetPath, outputPath, ResultImplementation.class);
    }

    @Override
    protected InstanceImplementation instanceFromCsv(String line) {
        String[] splitLine = line.split(",", 5);
        SimpleWeightedGraph<VertexImplementation, EdgeImplementation> graph = this.getAdditionalInput(splitLine[2]);
        String[] relevantVertices = splitLine[4].split(",");
        int[] parsedRelevantVertices = new int[relevantVertices.length];
        for (int i = 0; i < relevantVertices.length; i++) {
            parsedRelevantVertices[i] = Integer.parseInt(relevantVertices[i]);
        }
        return new InstanceImplementation(splitLine[1], Integer.parseInt(splitLine[0]), graph, Double.parseDouble(splitLine[3]), parsedRelevantVertices);
    }

    @Override
    protected StudentSolutionImplementation provideStudentSolution() {
        return new StudentSolutionImplementation();
    }

    @Override
    protected VerifierImplementation provideVerifier() {
        return new VerifierImplementation();
    }

    @Override
    protected SimpleWeightedGraph<VertexImplementation, EdgeImplementation> parseAdditionalInput(BufferedReader reader) {
        SimpleWeightedGraph<VertexImplementation, EdgeImplementation> graph = new SimpleWeightedGraph<VertexImplementation, EdgeImplementation>(EdgeImplementation.class);;

        VertexProvider<VertexImplementation> vertexProvider = (String id, Map<String, Attribute> attributes) -> new VertexImplementation(Integer.parseInt(id));
        EdgeProvider<VertexImplementation, EdgeImplementation> edgeProvider = (VertexImplementation from, VertexImplementation to, String label, Map<String, Attribute> attributes) -> new EdgeImplementation(from, to);

        try {
            GraphMLImporter<VertexImplementation, EdgeImplementation> importer = GraphUtil.createImporter(vertexProvider, edgeProvider, "length");
            importer.importGraph(graph, reader);
            return graph;
        } catch(ImportException e) {
            return null;
        }
    }

}
