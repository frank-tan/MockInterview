package com.franktan.mockinterview.udacity.graph;

/**
 * Created by tan on 15/03/2016.
 */

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    private T t;
    private List<GraphNode<T>> children;

    public GraphNode(T t) {
        this.t = t;
        children = new ArrayList();
    }

    public void addChild(GraphNode<T> node) {
        children.add(node);
    }

    public void addChildren(List<GraphNode<T>> nodes) {
        children.addAll(nodes);
    }

    public T getT(){
        return t;
    }

    public List<GraphNode<T>> getChildren(){
        return children;
    }
}
