import edu.udesc.volley.model.Game;
import edu.udesc.volley.model.Team;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class of Game
 * @author Jean Poffo
 */
public class GameTest {
    
    @Test
    public void testWinner() {
        Team team1 = new Team();
        Team team2 = new Team();
        
        Game game = new Game(team1, team2);
        
        for (int iterator = 1; iterator <= 75; iterator++) {
            game.addPointTeamOne();
        }
        
        assertEquals(team1, game.getWinner());
    }
    
}
