package com.sbt.codeit.bot;

import com.sbt.codeit.core.control.GameController;
import com.sbt.codeit.core.control.ServerListener;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Bot implements ServerListener {

    private GameController controller;
    private Character id;
    private Character baseId;
    public int i = 0;

    public Bot(GameController controller) {
        this.controller = controller;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void setBaseId(Character baseId) {
        this.baseId = baseId;
    }

    public void update(ArrayList<ArrayList<Character>> arrayList) throws RemoteException {
        if (!arrayList.get(i).contains('H')) {
            controller.start(this); //начинаем ехать сразу и больше не останавливаемся
            controller.down(this); //поворачиваем направо
            controller.fire(this); //стреляем всегда, когда это возможно
        }
        else {
            controller.stop(this);
            controller.start(this);
            controller.right(this);
            controller.fire(this);
        }
        i++;
    }

    public String getName() {
        return "Q_Q";
    }
}