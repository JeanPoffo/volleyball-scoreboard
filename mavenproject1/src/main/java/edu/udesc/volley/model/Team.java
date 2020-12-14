package edu.udesc.volley.model;

/**
 * Model class of Teams
 * @author Jean Poffo
 */
public class Team {
    
    private String name;
    
    private int points;

    public Team(String name) {
        this.name = name;
    }

    public Team() {}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void addPoint() {
        this.points++;
    }
    
    public void removePoint() {
        this.points--;
    }
    
}
