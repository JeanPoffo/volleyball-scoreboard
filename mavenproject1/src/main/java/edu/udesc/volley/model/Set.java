package edu.udesc.volley.model;

/**
 * Model class of Set
 * @author Jean Poffo
 */
public class Set {
    
    private Team team;

    public Set(Team team) {
        this.team = team;
    }
    
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
}
