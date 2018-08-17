package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.ScoreEntry;
import castal.gamesranking.model.Scoreboard;
import castal.gamesranking.repository.PlayerRepository;
import static org.junit.Assert.*;

import castal.gamesranking.repository.ScoreboardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private ScoreboardRepository scoreboardRepository;

    @InjectMocks
    private PlayerService playerService;

    @InjectMocks
    private ScoreboardService scoreboarService;

    @Test
    public void testIncrementVictories() {
        Scoreboard scoreboard = new Scoreboard();
        Player player = new Player("Marcos Paulo");
        ScoreEntry scoreEntry = new ScoreEntry(player);
        when(this.scoreboardRepository.findScoreEntry(player, scoreboard)).thenReturn(scoreEntry);
        when(this.scoreboardRepository.save(scoreboard)).thenReturn(scoreboard);

        assertEquals(scoreboard, scoreboarService.incrementVictories(scoreboard, player));

        assertEquals(1L, scoreEntry.getVictories());
        assertEquals(1L, scoreEntry.getMatches());
    }

    @Test
    public void testDecreaseVictories() {
        Scoreboard scoreboard = new Scoreboard();
        Player player = new Player("Marcos Paulo");
        ScoreEntry scoreEntry = new ScoreEntry(player);
        scoreEntry.incrementVictories();
        scoreEntry.incrementVictories();
        scoreEntry.incrementVictories();
        when(this.scoreboardRepository.findScoreEntry(player, scoreboard)).thenReturn(scoreEntry);
        when(this.scoreboardRepository.save(scoreboard)).thenReturn(scoreboard);

        assertEquals(scoreboard, scoreboarService.decreaseVictories(scoreboard, player));

        assertEquals(2L, scoreEntry.getVictories());
        assertEquals(2L, scoreEntry.getVictories());
    }

    @Test
    public void testIncrementMatchs() {
        Scoreboard scoreboard = new Scoreboard();
        Player player = new Player("Marcos Paulo");
        ScoreEntry scoreEntry = new ScoreEntry(player);

        when(this.scoreboardRepository.findScoreEntry(player, scoreboard)).thenReturn(scoreEntry);
        when(this.scoreboardRepository.save(scoreboard)).thenReturn(scoreboard);

        assertEquals(scoreboard, scoreboarService.incrementMatches(scoreboard, player));

        assertEquals(1L, scoreEntry.getMatches());
        assertEquals(0L, scoreEntry.getVictories());
    }

    @Test
    public void testDecreaseMatchs() {
        Scoreboard scoreboard = new Scoreboard();
        Player player = new Player("Marcos Paulo");
        ScoreEntry scoreEntry = new ScoreEntry(player);
        scoreEntry.incrementMatches();
        scoreEntry.incrementMatches();
        scoreEntry.incrementMatches();
        when(this.scoreboardRepository.findScoreEntry(player, scoreboard)).thenReturn(scoreEntry);
        when(this.scoreboardRepository.save(scoreboard)).thenReturn(scoreboard);

        assertEquals(scoreboard, scoreboarService.decreaseMatches(scoreboard, player));

        assertEquals(2L, scoreEntry.getMatches());
        assertEquals(0L, scoreEntry.getVictories());
    }
}
