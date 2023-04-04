package main.java.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueue {

    private StudentSolutionImplementation studentSolutionImplementation;
    private Map<Integer, Integer> vertexIdToHeapIndex = new HashMap<Integer, Integer>();
    private List<WeightedValue<Integer>> heap = new ArrayList<WeightedValue<Integer>>();

    public PriorityQueue(StudentSolutionImplementation studentSolutionImplementation) {
        this.studentSolutionImplementation = studentSolutionImplementation;
        this.heap.add(null);
    }

    public void add(double weight, int vertexId) {
        Integer index = this.vertexIdToHeapIndex.get(vertexId);
        if (index != null) {
            return;
        }
        this.vertexIdToHeapIndex.put(vertexId, this.heap.size());
        this.heap.add(new WeightedValue<Integer>(weight, vertexId));
        this.heapifyUp(this.heap.size() - 1);
    }

    public void swap(int index1, int index2) {
        if (0 < index1 && index1 < this.heap.size() && 0 < index2 && index2 < this.heap.size()) {
            WeightedValue<Integer> content1 = this.heap.get(index1);
            WeightedValue<Integer> content2 = this.heap.get(index2);
            this.vertexIdToHeapIndex.put(content1.value, index2);
            this.vertexIdToHeapIndex.put(content2.value, index1);
            this.heap.set(index1, content2);
            this.heap.set(index2, content1);
        }
    }

    public double getWeight(int index) {
        if (0 < index && index < this.heap.size()) {
            return this.heap.get(index).getWeight();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.heap.size() <= 1;
    }

    public int length() {
        return this.heap.size();
    }

    public int removeFirst() {
        int size = this.heap.size();
        if (size > 1) {
            int minVertexId = this.heap.get(1).value;
            this.swap(1, size - 1);
            this.vertexIdToHeapIndex.remove(minVertexId);
            this.heap.remove(size - 1);
            this.heapifyDown(1);
            return minVertexId;
        } else {
            return -1;
        }
    }

    public void decreaseWeight(double weight, int vertexId) {
        Integer index = this.vertexIdToHeapIndex.get(vertexId);
        if (index == null) {
            return;
        }
        WeightedValue<Integer> entry = this.heap.get(index);
        if (entry.getWeight() > weight) {
            entry.setWeight(weight);
            this.heapifyUp(index);
        }
    }

    private void heapifyUp(int position) {
        this.studentSolutionImplementation.heapifyUp(this, position);
    }

    private void heapifyDown(int position) {
        this.studentSolutionImplementation.heapifyDown(this, position);
    }

    private static class WeightedValue<ValueT> {
        private Double weight;
        private ValueT value;

        public WeightedValue(Double weight, ValueT value) {
            this.weight = weight;
            this.value = value;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public ValueT getValue() {
            return value;
        }

        public void setValue(ValueT value) {
            this.value = value;
        }
    }

}
