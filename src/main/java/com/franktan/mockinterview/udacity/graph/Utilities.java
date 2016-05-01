package com.franktan.mockinterview.udacity.graph;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

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

        // breadth first search
        Queue<GraphNode<T>> searchQueue = new LinkedBlockingQueue<GraphNode<T>>();
        searchQueue.add(start);

        // loop the search queue until it is empty
        while(!searchQueue.isEmpty()) {
            GraphNode<T> currentNode = searchQueue.poll();
            if(currentNode == end) {
                return true;
            }
            // add current node to visited nodes, so we can avoid circular path
            visitedNodes.add(currentNode);
            Set<GraphNode<T>> childrenNodes = getChildrenNodes(currentNode);
            childrenNodes.removeAll(visitedNodes);
            // add all children nodes that are not visited to the search queue
            searchQueue.addAll(childrenNodes);
        }

        return false;
    }

    public static <T> Set<GraphNode<T>> getChildrenNodes(GraphNode<T> currentNode) {
        Set<GraphNode<T>> childrenNodes = new HashSet();
        childrenNodes.addAll(currentNode.getChildren());
        return childrenNodes;
    }
}
