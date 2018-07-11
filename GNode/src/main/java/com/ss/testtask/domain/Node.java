package com.ss.testtask.domain;


import java.util.ArrayList;
import java.util.List;

public class Node implements GNode {
    private String name;
    private List<GNode> gNodes;


    public Node(String name) {
        this.name = name;
        gNodes = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<GNode> getChildren() {
        return gNodes;
    }
}
