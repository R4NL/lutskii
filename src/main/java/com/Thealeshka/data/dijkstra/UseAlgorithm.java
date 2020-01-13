package com.Thealeshka.data.dijkstra;

import com.Thealeshka.data.cluster.vertex.Vertex;
import com.Thealeshka.data.dijkstra.Graph.Graph;
import com.Thealeshka.data.dijkstra.Graph.Node;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UseAlgorithm {
    private List<Vertex> list;
    private List<Node> nodeList;

    public UseAlgorithm(List<Vertex> list) {
        this.list = list;
    }

    private Graph algorithm() {
        nodeList = new ArrayList<>();
        for (Vertex vertex : list) {
            nodeList.add(new Node(String.valueOf(vertex.getId())));
        }

        for (Node node : nodeList) {
            for (Integer integer : list.get(nodeList.indexOf(node)).getNeighboringVertex()) {
                node.addDestination(nodeList.get(integer - 1), 1);
            }
        }
        Graph graph = new Graph();
        for (Node node : nodeList) {
            graph.addNode(node);
        }
        return graph;
    }

    public int getDiameter() {
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            for (Node node : new Dijkstra().calculateShortestPathFromSource(algorithm(), nodeList.get(i)).getNodes()) {
                res = Math.max(res, node.getDistance());
            }
        }
        //System.out.println(res);
        return res;
    }

    public double getAverageDiameter() {
        double res = 0;
        double calc = 0;
        for (int i = 0; i < list.size(); i++) {
            for (Node node : new Dijkstra().calculateShortestPathFromSource(algorithm(), nodeList.get(i)).getNodes()) {
                res += node.getDistance();
                calc++;
            }

        }
        res /= calc;
        BigDecimal bd = new BigDecimal(Double.toString(res));
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
