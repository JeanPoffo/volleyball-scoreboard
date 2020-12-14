package edu.udesc.volley.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class of Game
 * @author Jean Poffo
 */
public class Game {
    
    private final List<Set> sets;
    
    private final Team teamOne;
    
    private final Team teamTwo;

    public Game(Team teamOne, Team teamTwo) {
        this.sets = new ArrayList();
        
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }    
    
    public List getSets() {
        return sets;
    }
    
    private void addSet(Set set) {
        this.sets.add(set);
    }

    private boolean isTieBreak() {
        return this.sets.size() >= 4; 
    }
    
    public Team getTeamOne() {
        return teamOne;
    }

    public void addPointTeamOne() {
        this.teamOne.addPoint();
        this.updateGameStatus();
    }
    
    public void removePointTeamOne() {
        this.teamOne.addPoint();
        this.updateGameStatus();
    }
    
    public Team getTeamTwo() {
        return teamTwo;
    }
    
    public void addPointTeamTwo() {
        this.teamTwo.addPoint();
        this.updateGameStatus();
    }
    
    public void removePointTeamTwo() {
        this.teamTwo.addPoint();
        this.updateGameStatus();
    }
    
    private void resetTeamsPoints() {
        this.teamOne.setPoints(0);
        this.teamTwo.setPoints(0);
    }
    
    private void updateGameStatus() {
        if(isWinnerOfSet(this.teamOne, this.teamTwo)) {
            this.addSet(new Set(this.teamOne));
            this.resetTeamsPoints();
        }
        
        if(isWinnerOfSet(this.teamTwo, this.teamOne)) {
            this.addSet(new Set(this.teamTwo));
            this.resetTeamsPoints();
        }
    }
    
    private boolean isWinnerOfSet(Team team, Team teamCompare) {
        if(this.isTieBreak()) {
            if(team.getPoints() == 20) return true;
            if(team.getPoints() >= 15 && (team.getPoints() - teamCompare.getPoints()) >= 2) return true;    
        }
        else {
            if(team.getPoints() == 30) return true;
            if(team.getPoints() >= 25 && (team.getPoints() - teamCompare.getPoints()) >= 2) return true;
        }
        
        return false;
    }
    
    public Team getWinner() {
        if(getSetsTeamOne() == 3) return this.teamOne;
        if(getSetsTeamTwo() == 3) return this.teamTwo;
        
        return null;
    }
    
    public int getSetsTeamOne() {
        int teamOneSets = 0;
        
        for(Set set: this.sets) {
            if(set.getTeam().equals(this.teamOne)) teamOneSets++;
        }
        
        return teamOneSets;
    }

    public int getSetsTeamTwo() {
        int teamTwoSets = 0;
        
        for(Set set: this.sets) {
            if(set.getTeam().equals(this.teamTwo)) teamTwoSets++;
        }
        
        return teamTwoSets;
    }
    
    @Override
    public String toString() {
        return "Pontuação do Time " + this.teamOne.getName() + ": " + this.teamOne.getPoints() + "\n" +
               "Pontuação do Time " + this.teamTwo.getName()+ ": " + this.teamTwo.getPoints();
    }
    
}
