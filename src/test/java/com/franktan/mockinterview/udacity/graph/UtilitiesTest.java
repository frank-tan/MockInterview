package com.franktan.mockinterview.udacity.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by tan on 15/03/2016.
 */
public class UtilitiesTest {
    GraphNode<String> nodeA;
    GraphNode<String> nodeB;
    GraphNode<String> nodeC;
    GraphNode<String> nodeD;
    GraphNode<String> nodeE;
    GraphNode<String> nodeF;
    GraphNode<String> nodeG;
    GraphNode<String> nodeH;
    GraphNode<String> nodeI;
    GraphNode<String> nodeJ;
    GraphNode<String> nodeK;
    GraphNode<String> nodeL;

    @Before
    public void setUp() {
        nodeA = new GraphNode("A");
        nodeB = new GraphNode("B");
        nodeC = new GraphNode("C");
        nodeD = new GraphNode("D");
        nodeE = new GraphNode("E");
        nodeF = new GraphNode("F");
        nodeG = new GraphNode("J");
        nodeH = new GraphNode("H");
        nodeI = new GraphNode("I");
        nodeJ = new GraphNode("J");
        nodeK = new GraphNode("K");
        nodeL = new GraphNode("L");

        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeE);

        nodeB.addChild(nodeA);
        nodeB.addChild(nodeF);

        nodeC.addChild(nodeA);
        nodeC.addChild(nodeI);
        nodeC.addChild(nodeJ);

        nodeD.addChild(nodeK);

        nodeE.addChild(nodeA);
        nodeE.addChild(nodeF);

        nodeF.addChild(nodeB);
        nodeF.addChild(nodeE);

        nodeG.addChild(nodeH);

        nodeH.addChild(nodeG);

        nodeI.addChild(nodeC);
        nodeI.addChild(nodeJ);

        nodeJ.addChild(nodeC);
        nodeJ.addChild(nodeI);

        nodeK.addChild(nodeD);
    }

    @Test
    public void testGetChildrenNodes() throws Exception {
        Set<GraphNode<String>> nextGen = Utilities.getChildrenNodes(nodeA);

        assertEquals(3, nextGen.size());
        assertTrue(nextGen.contains(nodeB));
        assertTrue(nextGen.contains(nodeC));
        assertTrue(nextGen.contains(nodeE));
    }

    @Test
    public void testFindPath() throws Exception {
        assertTrue(Utilities.findPath(nodeA,nodeC));
        assertTrue(Utilities.findPath(nodeA,nodeI));
        assertTrue(Utilities.findPath(nodeA,nodeJ));
        assertTrue(Utilities.findPath(nodeA,nodeF));
        assertTrue(Utilities.findPath(nodeA,nodeB));
        assertTrue(Utilities.findPath(nodeA,nodeE));

        assertTrue(Utilities.findPath(nodeI,nodeF));
        assertTrue(Utilities.findPath(nodeE,nodeJ));

        assertTrue(Utilities.findPath(nodeH,nodeG));
        assertTrue(Utilities.findPath(nodeG,nodeH));

        assertFalse(Utilities.findPath(nodeA, nodeH));
        assertFalse(Utilities.findPath(nodeA, nodeG));
        assertFalse(Utilities.findPath(nodeJ, nodeD));
        assertFalse(Utilities.findPath(nodeF,nodeK));
        assertFalse(Utilities.findPath(nodeC,nodeL));
        assertFalse(Utilities.findPath(nodeL,nodeG));
        assertFalse(Utilities.findPath(nodeD,nodeL));
    }
}
