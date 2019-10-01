package com.Thealeshka.data.graph;

import com.Thealeshka.data.cluster.ClusterForLab2;
import com.Thealeshka.data.cluster.vertex.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Tree implements Graph {
    private int clusterCount;
    private List<Vertex> resultList;

    {
        resultList = new ArrayList<>();
    }

    @Override
    public List<Vertex> generateResultList(int clusterCount) {
        ClusterForLab2 clusterForLab2 = new ClusterForLab2();
        for (int i = 0; i < clusterCount; i++) {
            for (Vertex vertex : clusterForLab2.createCluster(i)) {
                resultList.add(add(vertex, i));
            }
        }
        return null;
    }

    private Vertex add(Vertex vertex, int iterator) {
        switch (vertex.getId() - iterator * clusterCount) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

        }
    }

}
