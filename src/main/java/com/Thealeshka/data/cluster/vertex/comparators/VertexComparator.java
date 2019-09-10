package com.Thealeshka.data.cluster.vertex.comparators;

import com.Thealeshka.data.cluster.vertex.Vertex;

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {
    @Override
    public int compare(Vertex o1, Vertex o2) {
        if ((o1 == null) && (o2 == null)) {
            return 0;
        }
        if ((o1 != null) && (o2 == null)) {
            return 1;
        }
        if ((o1 == null) && (o2 != null)) {
            return -1;
        }
        if (o1.getId() > o2.getId()) {
            return 1;
        } else {
            if (o1.getId() < o2.getId()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
