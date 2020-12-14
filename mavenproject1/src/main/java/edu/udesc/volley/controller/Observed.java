package edu.udesc.volley.controller;

import edu.udesc.volley.view.Observer;

/**
 * Observed
 * @author Jean Poffo
 */
public interface Observed {
    
    public void addObserver(Observer observer);
    
    public void removeObserver(Observer observer);
    
    public void notifyUpdateNameTeamOne();
    
    public void notifyUpdateNameTeamTwo();
    
    public void notifyUpdateSetTeamOne();
    
    public void notifyUpdateSetTeamTwo();
    
    public void notifyUpdatePointTeamOne();
    
    public void notifyUpdatePointTeamTwo();
    
    public void notifyUpdateGameWinner();
    
}
