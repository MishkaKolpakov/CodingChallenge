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
        if(!node.getChildren().isEmpty()){
            for (GNode gNode : node.getChildren()) {
                walkGraph(gNode);
            }
        }

        return nodesResult;
    }

    @Override
    public List<List<GNode>> paths(GNode position) {
        List<List<GNode>> pathsList = new ArrayList<>();

        if (position.getChildren().isEmpty()) {
            List<GNode> leafList = new LinkedList<>();
            leafList.add(position);
            pathsList.add(leafList);
        } else {
            for (GNode node : position.getChildren()) {
                List<List<GNode>> nodeLists = paths(node);
                for (List<GNode> nodeList : nodeLists) {
                    nodeList.add(0, position);
                    pathsList.add(nodeList);
                }
            }
        }

        return pathsList;
    }
}
