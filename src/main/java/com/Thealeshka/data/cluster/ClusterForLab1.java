package com.Thealeshka.data.cluster;

import com.Thealeshka.data.cluster.vertex.Vertex;

import java.util.*;

import static com.Thealeshka.data.cluster.ClusterForLab3.getList;

public class ClusterForLab1 {
    private List<Vertex> list;

    public ClusterForLab1() {
    }

    public List<Vertex> createCluster(int startPoint) {
        list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(new Vertex(i + startPoint * 9));
        }
        //int[][] matrix = {{2, 4, 5}, {1, 3}, {2, 5, 6}, {1, 7}, {1, 3, 7, 9}, {3, 9}, {4, 5, 7}, {7, 9}, {5, 6, 8}};
        int[][] matrix = {{2, 4, 7,9}, {1, 3, 4, 8}, {2, 5, 6, 9}, {1, 2, 7}, {3, 7}, {3, 8, 9}, {1, 4, 5, 8}, {2, 6, 7, 9}, {1,3, 6, 7}};

        return getList(matrix, list);
    }
}
