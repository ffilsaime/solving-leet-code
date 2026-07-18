package com.florebencia.filsaime;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingProblems {

    //for leetcode problem: https://leetcode.com/problems/all-paths-from-source-to-target/description
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        bt(start, solution, graph, 0);
        return solution;
    }

    private void bt(List<Integer> subList, List<List<Integer>> answer, int[][] graph, int index){
        //when is a solution complete? When we've made it to the last index
        if (index == graph.length - 1){
            List<Integer> newList = new ArrayList<>(subList);
            answer.add(newList);
            return;
        }

        List<Integer> newList = new ArrayList<>(subList);
        // try with just a regular i = 0
        for (int i = 0; i < graph[index].length; i++){
            newList.add(graph[index][i]);
            bt(newList, answer, graph, graph[index][i]);
            newList.remove(newList.size() - 1);
        }
    }
    //end of leetcode problem

}
