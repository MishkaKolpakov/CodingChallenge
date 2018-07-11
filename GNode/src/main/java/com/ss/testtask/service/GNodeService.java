package com.ss.testtask.service;

import com.ss.testtask.domain.GNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GNodeService implements GNodeHandler {
    private List<GNode> nodesResult;

    public GNodeService() {
        nodesResult = new ArrayList<>();
    }

    @Override
    public List<GNode> walkGraph(GNode node) {
        nodesResult.add(node);
        for (GNode gNode : node.getChildren()) {
            if (!node.getChildren().isEmpty()) {
                walkGraph(gNode);
            }
        }

        return nodesResult;
    }

    @Override
    public List<List<GNode>> paths(GNode position) {
        List<List<GNode>> retLists = new ArrayList<>();

        if(position.getChildren().isEmpty()) {
            List<GNode> leafList = new LinkedList<>();
            leafList.add(position);
            retLists.add(leafList);
        } else {
            for (GNode node : position.getChildren()) {
                List<List<GNode>> nodeLists = paths(node);
                for (List<GNode> nodeList : nodeLists) {
                    nodeList.add(0, position);
                    retLists.add(nodeList);
                }
            }
        }

        return retLists;
    }
}
