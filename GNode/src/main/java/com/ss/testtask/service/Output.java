package com.ss.testtask.service;

import com.ss.testtask.domain.GNode;

import java.util.List;

public interface Output {
    void displayNodes(List<GNode> nodes);
    void displayPaths(List<List<GNode>> paths);
}
