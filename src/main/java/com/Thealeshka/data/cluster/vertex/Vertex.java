package com.Thealeshka.data.cluster.vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private Integer id;
    private List<Integer> neighboringVertex;

    {
        neighboringVertex = new ArrayList<Integer>();
    }

    public Vertex() {
    }

    public Vertex(Integer id) {
        this.id = id;
    }

    public Vertex(Integer id, List<Integer> neighboringVertex) {
        this.id = id;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getNeighboringVertex() {
        return neighboringVertex;
    }

    public void setNeighboringVertex(List<Integer> neighboringVertex) {
        this.neighboringVertex = neighboringVertex;
    }

    public void setNeighboringVertex(Integer vertex) {
        this.neighboringVertex.add(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", neighboringVertex=" + neighboringVertex +
                '}';
    }
}
