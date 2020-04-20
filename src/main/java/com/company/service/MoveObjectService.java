package com.company.service;

public interface MoveObjectService {

    void initTable(int height, int width, int Xpos, int Ypos);

    boolean handleCommand(int moveCode);

    String retrievePosition();
}