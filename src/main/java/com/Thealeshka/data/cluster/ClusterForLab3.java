package com.Thealeshka.data.cluster;

import com.Thealeshka.data.cluster.vertex.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClusterForLab3 {
    private List<Vertex> list;

    public ClusterForLab3() {
    }

    public List<Vertex> createCluster(int startPoint) {
        list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(new Vertex(i + startPoint * 9));
        }
        int[][] matrix = {{2, 4, 7}, {1, 3, 4, 8}, {2, 5, 6, 9}, {1, 2, 7}, {3, 7}, {3, 8, 9}, {1, 4, 5, 8}, {2, 6, 7, 9}, {3, 6, 7}};



        return getList(matrix, list);
    }

    static List<Vertex> getList(int[][] matrix, List<Vertex> list) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.get(i).setNeighboringVertex(list.get(matrix[i][j] - 1).getId());
            }
        }
        Collections.sort(list, (Comparator.comparingInt(Vertex::getId)));
        return list;
    }
}
