package com.ss.testtask.service;

import com.ss.testtask.domain.GNode;

import java.util.Iterator;
import java.util.List;

public class TerminalOutput implements Output {

    @Override
    public void displayNodes(List<GNode> nodes) {
        for (GNode gNode : nodes) {
            System.out.print(gNode.getName() + " ");
        }
        System.out.println();
    }

    @Override
    public void displayPaths(List<List<GNode>> paths) {
        System.out.print("(");
        for(List<GNode> path : paths){
            System.out.print("(");
            Iterator<GNode> nodeIterator = path.iterator();
            while (nodeIterator.hasNext()){
                GNode node = nodeIterator.next();
                if(nodeIterator.hasNext()){
                    System.out.print(node.getName() + " ");
                } else {
                    System.out.print(node.getName() + ")");
                }

            }
        }
        System.out.print(")");
    }
}
