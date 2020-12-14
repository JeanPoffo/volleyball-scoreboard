package edu.udesc.volley.view;

import edu.udesc.volley.model.Team;

/**
 * Observer Interface
 * @author Jean Poffo
 */
public interface Observer {
    
    public void updateNameTeamOne(String name);
    
    public void updateNameTeamTwo(String name);
    
    public void updateSetTeamOne(int set);
    
    public void updateSetTeamTwo(int set);
    
    public void updatePointTeamOne(int point);
    
    public void updatePointTeamTwo(int point);
    
    public void updateGameWinner(Team team);
    
}
