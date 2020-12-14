package edu.udesc.volley.controller;

import edu.udesc.volley.model.Game;
import edu.udesc.volley.model.Team;
import edu.udesc.volley.view.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class of System
 * @author Jean Poffo
 */
public class ControllerSystem implements Observed {
    
    private List<Observer> observers;

    private Game game;
    
    private static ControllerSystem instance;

    private ControllerSystem() {
        this.observers = new ArrayList<>();
        this.game = new Game(new Team(), new Team());
    }
    
    public static ControllerSystem getInstance() {
        if(instance == null) {
            instance = new ControllerSystem();
        }
        return instance;
    }
    
    public void callAddPointTeamOne() {
        this.game.addPointTeamOne();
        this.notifyAllData();
    }
    
    public void callAddPointTeamTwo() {
        this.game.addPointTeamTwo();
        this.notifyAllData();
    }
    
    public void callNewGame(String nameTeamOne, String nameTeamTwo) {
        this.game = new Game(new Team(nameTeamOne), new Team(nameTeamTwo));
        
        this.notifyAllData();
    }

    private void notifyAllData() {
        this.notifyUpdateSetTeamOne();
        this.notifyUpdateSetTeamTwo();
        this.notifyUpdatePointTeamOne();
        this.notifyUpdatePointTeamTwo();
        this.notifyUpdateGameWinner();
    }
    
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyUpdateNameTeamOne() {
        this.observers.forEach(observer -> observer.updateNameTeamOne(this.game.getTeamOne().getName()));
    }

    @Override
    public void notifyUpdateNameTeamTwo() {
        this.observers.forEach(observer -> observer.updateNameTeamTwo(this.game.getTeamTwo().getName()));
    }

    @Override
    public void notifyUpdateSetTeamOne() {
        this.observers.forEach(observer -> observer.updateSetTeamOne(this.game.getSetsTeamOne()));
    }

    @Override
    public void notifyUpdateSetTeamTwo() {
        this.observers.forEach(observer -> observer.updateSetTeamTwo(this.game.getSetsTeamTwo()));
    }
    
    @Override
    public void notifyUpdatePointTeamOne() {
        this.observers.forEach(observer -> observer.updatePointTeamOne(this.game.getTeamOne().getPoints()));
    }

    @Override
    public void notifyUpdatePointTeamTwo() {
        this.observers.forEach(observer -> observer.updatePointTeamTwo(this.game.getTeamTwo().getPoints()));
    }

    @Override
    public void notifyUpdateGameWinner() {
        this.observers.forEach(observer -> observer.updateGameWinner(this.game.getWinner()));
    }
    
}
