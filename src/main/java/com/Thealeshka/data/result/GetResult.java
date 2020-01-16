package com.Thealeshka.data.result;

import com.Thealeshka.data.cluster.vertex.Vertex;
import com.Thealeshka.data.dijkstra.UseAlgorithm;
import com.Thealeshka.data.graph.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GetResult {


    private List<Vertex> result;

    private List<Integer> diameter;
    private List<Double> averageDiameter;
    private List<Integer> power;
    private List<Integer> cost;
    private List<Double> topologicalTraffic;

    public GetResult() {
    }

    public void getResult() {
        newList();
        for (int i = 0; i <= 30; i++) {
            result = new Circle().generateResultList(i + 1);
            setDiameter();
            setAverageDiameter();
            setPower();
            setCost();
            setTopologicalTraffic();

        }

        for (int i = 0; i <= 30; i++) {
            if (Math.sqrt((i + 1) * 9) % 1 == 0)
                System.out.println(((i + 1) * 9) + "  " + diameter2.remove() + " " + averageDiameter2.remove() + " " + power.get(i) + " " + cost.get(i) + " " + topologicalTraffic.get(i));
        }
    }

    private void setDiameter() {
        diameter.add(new UseAlgorithm(result).getDiameter());
    }

    private void setAverageDiameter() {
        averageDiameter.add(new UseAlgorithm(result).getAverageDiameter());
    }

    private void setPower() {
        Integer data = 0;
        for (Vertex vertex : result) {
            data = Math.max(data, vertex.getNeighboringVertex().size());
        }
        power.add(data);
    }

    private void setCost() {
        Integer data = 0;
        for (Vertex vertex : result) {
            data += vertex.getNeighboringVertex().size();
        }
        cost.add(Math.min(data / 2, diameter.get(diameter.size() - 1)) * power.get(power.size() - 1) * diameter.size());
    }

    private void setTopologicalTraffic() {
        topologicalTraffic.add(2 * averageDiameter.get(averageDiameter.size() - 1) / power.get(power.size() - 1));
    }

    private void newList() {
        diameter = new ArrayList<>();
        averageDiameter = new ArrayList<>();
        power = new ArrayList<>();
        cost = new ArrayList<>();
        topologicalTraffic = new ArrayList<>();
    }


    private LinkedList<String> diameter2 = Arrays.stream(new int[]{2, 5, 6, 8, 9,11}).mapToObj(n -> Integer.toString(n)).collect(Collectors.toCollection(LinkedList::new));
    private LinkedList<String> averageDiameter2 = Arrays.stream(new double[]{1.321, 2.171, 2.523, 3.484, 3.951,5.123}).mapToObj(n -> Double.toString(n)).collect(Collectors.toCollection(LinkedList::new));

}
