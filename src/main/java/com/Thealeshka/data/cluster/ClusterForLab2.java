package com.Thealeshka.data.cluster;

import com.Thealeshka.data.cluster.vertex.Vertex;

import java.util.*;

public class ClusterForLab2 {
    private List<Vertex> list;

    public ClusterForLab2() {
    }

    public List<Vertex> createCluster(int startPoint) {
        list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(new Vertex(i + startPoint * 6));
        }
        int[][] matrix = {{2, 5, 6}, {1, 3, 4}, {2, 4, 5}, {2, 3, 6}, {1, 3, 6}, {1, 5, 6}};

        return getList(matrix, list);
    }

    static List<Vertex> getList(int[][] matrix, List<Vertex> list) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.get(i).setNeighboringVertex(list.get(matrix[i][j] - 1).getId());
            }
        }
        Collections.sort(list, ((o1, o2) -> o1.getId() - o2.getId()));
        return list;
    }
}
