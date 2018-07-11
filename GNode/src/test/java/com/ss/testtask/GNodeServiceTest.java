package com.ss.testtask;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.ss.testtask.domain.GNode;
import com.ss.testtask.domain.Node;
import com.ss.testtask.service.GNodeService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class GNodeServiceTest {
    private Node A;
    private Node B;
    private Node C;
    private Node D;
    private Node E;
    private Node F;
    private Node G;
    private Node H;
    private Node I;
    private GNodeService nodeService;

    @Before
    public void init() {
        A = new Node("A");
        B = new Node("B");
        C = new Node("C");
        D = new Node("D");
        E = new Node("E");
        F = new Node("F");
        G = new Node("G");
        H = new Node("H");
        I = new Node("I");

        A.getChildren().add(B);
        A.getChildren().add(C);
        A.getChildren().add(D);
        B.getChildren().add(E);
        B.getChildren().add(F);
        C.getChildren().add(G);
        C.getChildren().add(H);
        C.getChildren().add(I);

        nodeService = new GNodeService();
    }

    @Test
    public void checkWalkGraphFromRoot() {
        List<GNode> expectedList = Arrays.asList(A, B, C, D, E, F, G, H, I);
        List<GNode> actualList = nodeService.walkGraph(A);

        assertTrue(expectedList.containsAll(actualList));
    }

    @Test
    public void checkWalkGraphFromLeaf() {
        List<GNode> expectedList = Collections.singletonList(D);
        List<GNode> actualList = nodeService.walkGraph(D);

        assertTrue(expectedList.containsAll(actualList));
    }

    @Test
    public void checkWalkGraphFromMiddleElement() {
        List<GNode> expectedList = Arrays.asList(B, E, F);
        List<GNode> actualList = nodeService.walkGraph(B);

        assertTrue(expectedList.containsAll(actualList));
    }

    @Test
    public void checkPathsFromRoot() {
        List<List<GNode>> expectedList = Arrays.asList(Arrays.asList(A, B, E), Arrays.asList(A, B, F), Arrays.asList(A, C, G),
                Arrays.asList(A, C, H), Arrays.asList(A, C, I), Arrays.asList(A, D));
        List<List<GNode>> actualList = nodeService.paths(A);

        assertTrue(expectedList.containsAll(actualList));
    }

    @Test
    public void checkPathsFromMiddleElement() {
        List<List<GNode>> expectedList = Arrays.asList(Arrays.asList(B, E), Arrays.asList(B, F));
        List<List<GNode>> actualList = nodeService.paths(B);

        assertTrue(expectedList.containsAll(actualList));
    }

    @Test
    public void checkPathsFromLeaf() {
        List<List<GNode>> expectedList = Collections.singletonList(Collections.singletonList(E));
        List<List<GNode>> actualList = nodeService.paths(E);

        assertTrue(expectedList.containsAll(actualList));
    }
}
