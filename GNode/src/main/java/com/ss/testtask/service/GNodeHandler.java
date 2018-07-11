package com.ss.testtask.service;

import com.ss.testtask.domain.GNode;

import java.util.List;

public interface GNodeHandler {
    List<GNode> walkGraph(GNode node);
    List<List<GNode>> paths(GNode node);
}
