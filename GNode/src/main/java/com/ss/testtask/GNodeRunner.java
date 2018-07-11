package com.ss.testtask;

import com.ss.testtask.domain.GNode;
import com.ss.testtask.domain.Node;
import com.ss.testtask.service.GNodeService;
import com.ss.testtask.service.Output;
import com.ss.testtask.service.TerminalOutput;

import java.util.List;

public class GNodeRunner {
    public static void main(String[] args) {
        GNodeService nodeService = new GNodeService();
        Output outputService = new TerminalOutput();

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");

        A.getChildren().add(B);
        A.getChildren().add(C);
        A.getChildren().add(D);

        B.getChildren().add(E);
        B.getChildren().add(F);

        C.getChildren().add(G);
        C.getChildren().add(H);
        C.getChildren().add(I);

        List<GNode> nodes = nodeService.walkGraph(B);
        List<List<GNode>> paths = nodeService.paths(B);

        outputService.displayNodes(nodes);
        outputService.displayPaths(paths);
    }
}
