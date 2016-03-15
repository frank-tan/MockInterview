package com.franktan.mockinterview.udacity.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tan on 15/03/2016.
 */
public class Utilities {

    /**
     * Find if there is a path from start node to end node
     * @param start
     * @param end
     * @param <T>
     * @return true if there is a path from start node to end node
     */
    public static <T> boolean findPath(GraphNode<T> start, GraphNode<T> end) {
        // check null
        if(start == null || end == null) return false;

        // use visitedNodes to record all visited nodes to avoid circular path
        Set<GraphNode<T>> visitedNodes = new HashSet();

        // breadth first search: a set of node in a particular genearation
        Set<GraphNode<T>> nodesOfGeneration = new HashSet();
        nodesOfGeneration.add(start);

        do {
            if(nodesOfGeneration.contains(end)){
                return true;
            }
            // add checked nodes to visited nodes
            visitedNodes.addAll(nodesOfGeneration);

            nodesOfGeneration = getNextGenerationNodes(nodesOfGeneration);

            // remove visited nodes
            nodesOfGeneration.removeAll(visitedNodes);
        } while (nodesOfGeneration.size() > 0);

        return false;
    }

    /**
     * Get all next generation nodes
     * @param nodesOfCurrentGeneration All nodes in the current generation
     * @param <T>
     * @return a set of all next generation nodes
     */
    public static <T> Set<GraphNode<T>> getNextGenerationNodes(Set<GraphNode<T>> nodesOfCurrentGeneration) {
        Set<GraphNode<T>> nextGenerationNodes = new HashSet();

        //get the children of each node of current generation and add them to result set
        for(GraphNode<T> node : nodesOfCurrentGeneration){
            nextGenerationNodes.addAll(node.getChildren());
        }

        return nextGenerationNodes;
    }


}
