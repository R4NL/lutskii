package com.Thealeshka.data.graph;

import com.Thealeshka.data.cluster.Cluster;
import com.Thealeshka.data.cluster.vertex.Vertex;
import com.Thealeshka.data.cluster.vertex.comparators.VertexComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Circle {
    private int clusterCount;
    private List<Integer> firstList;
    private List<Integer> lastList;
    private List<Vertex> resultList;

    public Circle(int clusterCount) {
        this.clusterCount = clusterCount;
        start();
    }

    public Circle() {
        start();
    }

    private void start() {
        resultList = new ArrayList<>();
        firstList = new ArrayList<>();
        lastList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            firstList.add(3 * i);
            lastList.add(1 + 3 * (i - 1));
        }
    }

    public List<Vertex> generateResultList(int clusterCount) {
        this.clusterCount = clusterCount;
        Cluster cluster = new Cluster();
        for (int i = 0; i < clusterCount; i++) {
            for (Vertex vertex : cluster.createCluster(i)) {
                resultList.add(add(vertex, i));
            }
        }
        makeCircle();
        Collections.sort(resultList, new VertexComparator());
        return resultList;
    }

    private Vertex addFirst(Vertex vertex, int iterator, int cluster) {
        if ((cluster + 9 * (iterator + 1)) <= (clusterCount * 9)) {
            vertex.getNeighboringVertex().add(cluster - 2 + 9 * (iterator + 1));
        }
        return vertex;
    }

    private Vertex addLast(Vertex vertex, int iterator, int cluster) {
        if ((cluster + 9 * (iterator - 1)) > 0) {
            vertex.getNeighboringVertex().add(cluster + 2 + 9 * (iterator - 1));
        }
        return vertex;
    }

    private Vertex add(Vertex vertex, int iterator) {
        if (firstList.contains(vertex.getId() - 9 * iterator)) {
            return addFirst(vertex, iterator, vertex.getId() - 9 * iterator);
        } else {
            if (lastList.contains(vertex.getId() - 9 * iterator)) {
                return addLast(vertex, iterator, vertex.getId() - 9 * iterator);
            } else {
                return vertex;
            }
        }
    }

    private void makeCircle() {
        for (int i = 0; i < 3; i++) {
            resultList.get(lastList.get(i) - 1).getNeighboringVertex().add(resultList.get(resultList.size() - 10 + firstList.get(i)).getId());
            resultList.get(resultList.size() - 10 + firstList.get(i)).getNeighboringVertex().add(lastList.get(i));
        }
    }

    public List<Vertex> getResultList() {
        return resultList;
    }

}
