package com.Thealeshka.data.cluster;

import com.Thealeshka.data.cluster.vertex.Vertex;
import com.Thealeshka.data.cluster.vertex.comparators.VertexComparator;

import java.util.*;

public class Cluster {
    private List<Vertex> list;

    public Cluster() {
    }

    public List<Vertex> createCluster(int startPoint) {
        list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(new Vertex(i+startPoint*9));
        }
        int[][] matrix = {{2, 4, 5}, {1, 3}, {2, 5, 6}, {1, 7}, {1, 3, 7, 9}, {3, 9}, {4, 5, 7}, {7, 9}, {5, 6, 8}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.get(i).setNeighboringVertex(list.get(matrix[i][j] - 1).getId());
            }
        }
        Collections.sort(list, new VertexComparator());
        return list;
    }
}
