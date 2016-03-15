package com.franktan.mockinterview.udacity.graph;

import com.franktan.mockinterview.udacity.compressor.StringCompressor;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
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
    public void testGetNextGenerationNodes() throws Exception {
        Set<GraphNode<String>> currentGen = new HashSet();
        currentGen.add(nodeA);
        Set<GraphNode<String>> nextGen = Utilities.getNextGenerationNodes(currentGen);

        assertEquals(3, nextGen.size());
        assertTrue(nextGen.contains(nodeB));
        assertTrue(nextGen.contains(nodeC));
        assertTrue(nextGen.contains(nodeE));

        currentGen.clear();
        currentGen.add(nodeB);
        currentGen.add(nodeC);
        currentGen.add(nodeE);
        nextGen = Utilities.getNextGenerationNodes(currentGen);

        assertEquals(4, nextGen.size());
        assertTrue(nextGen.contains(nodeA));
        assertTrue(nextGen.contains(nodeF));
        assertTrue(nextGen.contains(nodeI));
        assertTrue(nextGen.contains(nodeJ));

        currentGen.clear();
        currentGen.add(nodeL);
        nextGen = Utilities.getNextGenerationNodes(currentGen);

        assertEquals(0,nextGen.size());
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
