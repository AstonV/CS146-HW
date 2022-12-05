package com.example;

import algs4.*;

public class ShortestPaths {
    /*
    Monotonic shortest path.
    Given an edge-weighted digraph G,
    design an ElogE algorithm to find a monotonic shortest path from s to every other vertex.
    */
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    /*
    1. Sort edges of each vertex, ascending or descending
    2. relax edges using Dijkstra algorithm, check monotonic condition before check distTo
     */

    //1. add reverse method in EdgeWeightedDigraph class
    public Iterable<DirectedEdge> skippablePath(EdgeWeightedDigraph G,int s, int t) {
        DijkstraSP spaths = new DijkstraSP(G, s);
        DijkstraSP tpaths = new DijkstraSP(G.reverse(), t);

        double min = Double.MAX_VALUE;
        DirectedEdge skippable = null;

        for (DirectedEdge e : G.edges()) {
            int v = e.from();
            int w = e.to();
            if (spaths.distTo(v) + tpaths.distTo(w) < min) {
                skippable = e;
                min = spaths.distTo(v) + tpaths.distTo(w);
            }
        }

        Stack<DirectedEdge> skippablepath = new Stack<DirectedEdge>();
        Stack<DirectedEdge> tmp = new Stack<DirectedEdge>();

        for (DirectedEdge e : tpaths.pathTo(skippable.to())) skippablepath.push(e);
        skippablepath.push(skippable);
        for (DirectedEdge e : spaths.pathTo(skippable.from())) tmp.push(e);
        for (DirectedEdge e : tmp) skippablepath.push(e);
        return skippablepath;
    }


}
