package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Ranking;
import castal.gamesranking.model.RankingEntry;
import castal.gamesranking.repository.PlayerRepository;
import static org.junit.Assert.*;

import castal.gamesranking.repository.RankingRepository;
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
    private RankingRepository rankingRepository;

    @InjectMocks
    private PlayerService playerService;

    @InjectMocks
    private RankingService scoreboarService;

    @Test
    public void testIncrementVictories() {
        Ranking ranking = new Ranking();
        Player player = new Player("Marcos Paulo");
        RankingEntry rankingEntry = new RankingEntry(player);
        when(this.rankingRepository.findScoreEntry(player, ranking)).thenReturn(rankingEntry);
        when(this.rankingRepository.save(ranking)).thenReturn(ranking);

        assertEquals(ranking, scoreboarService.incrementVictories(ranking, player));

        assertEquals(1L, rankingEntry.getVictories());
        assertEquals(1L, rankingEntry.getMatches());
    }

    @Test
    public void testDecreaseVictories() {
        Ranking ranking = new Ranking();
        Player player = new Player("Marcos Paulo");
        RankingEntry rankingEntry = new RankingEntry(player);
        rankingEntry.incrementVictories();
        rankingEntry.incrementVictories();
        rankingEntry.incrementVictories();
        when(this.rankingRepository.findScoreEntry(player, ranking)).thenReturn(rankingEntry);
        when(this.rankingRepository.save(ranking)).thenReturn(ranking);

        assertEquals(ranking, scoreboarService.decreaseVictories(ranking, player));

        assertEquals(2L, rankingEntry.getVictories());
        assertEquals(2L, rankingEntry.getVictories());
    }

    @Test
    public void testIncrementMatchs() {
        Ranking ranking = new Ranking();
        Player player = new Player("Marcos Paulo");
        RankingEntry rankingEntry = new RankingEntry(player);

        when(this.rankingRepository.findScoreEntry(player, ranking)).thenReturn(rankingEntry);
        when(this.rankingRepository.save(ranking)).thenReturn(ranking);

        assertEquals(ranking, scoreboarService.incrementMatches(ranking, player));

        assertEquals(1L, rankingEntry.getMatches());
        assertEquals(0L, rankingEntry.getVictories());
    }

    @Test
    public void testDecreaseMatchs() {
        Ranking ranking = new Ranking();
        Player player = new Player("Marcos Paulo");
        RankingEntry rankingEntry = new RankingEntry(player);
        rankingEntry.incrementMatches();
        rankingEntry.incrementMatches();
        rankingEntry.incrementMatches();
        when(this.rankingRepository.findScoreEntry(player, ranking)).thenReturn(rankingEntry);
        when(this.rankingRepository.save(ranking)).thenReturn(ranking);

        assertEquals(ranking, scoreboarService.decreaseMatches(ranking, player));

        assertEquals(2L, rankingEntry.getMatches());
        assertEquals(0L, rankingEntry.getVictories());
    }
}
