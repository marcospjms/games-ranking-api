package castal.gamesranking.controler;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Ranking;
import castal.gamesranking.service.PlayerService;
import castal.gamesranking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rankings")
public class RankingControler {

    @Autowired
    private RankingService rankingService;
    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/{id}")
    public Ranking findById(@PathVariable("id") Long id) {
        return this.rankingService.findById(id);
    }

    @GetMapping()
    public List<Ranking> findAll() {
        return this.rankingService.findAll();
    }

    @PostMapping()
    public Ranking save(@RequestBody Ranking ranking) {
        ranking.setScoreEntries(null);
        return this.rankingService.saveOrUpdate(ranking);
    }

    @PutMapping()
    public Ranking update(@RequestBody Ranking ranking) {
        Ranking stored = rankingService.findById(ranking.getId());
        ranking.setScoreEntries(stored.getScoreEntries()); // Não permitir mudar as entries pelo update
        return this.rankingService.saveOrUpdate(ranking);
    }

    @PutMapping(value = "/{rankingId}/createScoreEntry/{playerId}")
    public Ranking createScoreEntry(@PathVariable("rankingId") Long rankingId, @PathVariable("playerId") Long playerId) {
        Ranking ranking = this.rankingService.findById(rankingId);
        Player player = this.playerService.findById(playerId);

        return this.rankingService.createScoreEntry(ranking, player);
    }

    @PutMapping(value = "/{rankingId}/incrementVictories/{playerId}")
    public Ranking incrementVictories(@PathVariable("rankingId") Long rankingId, @PathVariable("playerId") Long playerId) {
        Ranking ranking = this.rankingService.findById(rankingId);
        Player player = this.playerService.findById(playerId);

        if (ranking == null) {
            throw new RuntimeException("Ranking não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.rankingService.incrementVictories(ranking, player);
    }

    @PutMapping(value = "/{rankingId}/decreaseVictories/{playerId}")
    public Ranking decreaseVictories(@PathVariable("rankingId") Long rankingId, @PathVariable("playerId") Long playerId) {
        Ranking ranking = this.rankingService.findById(rankingId);
        Player player = this.playerService.findById(playerId);

        if (ranking == null) {
            throw new RuntimeException("Ranking não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.rankingService.decreaseVictories(ranking, player);
    }

    @PutMapping(value = "/{rankingId}/incrementMatches/{playerId}")
    public Ranking incrementMatches(@PathVariable("rankingId") Long rankingId, @PathVariable("playerId") Long playerId) {
        Ranking ranking = this.rankingService.findById(rankingId);
        Player player = this.playerService.findById(playerId);

        if (ranking == null) {
            throw new RuntimeException("Ranking não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.rankingService.incrementMatches(ranking, player);
    }

    @PutMapping(value = "/{rankingId}/decreaseMatches/{playerId}")
    public Ranking decreaseMatches(@PathVariable("rankingId") Long rankingId, @PathVariable("playerId") Long playerId) {
        Ranking ranking = this.rankingService.findById(rankingId);
        Player player = this.playerService.findById(playerId);

        if (ranking == null) {
            throw new RuntimeException("Ranking não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.rankingService.decreaseMatches(ranking, player);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        Ranking ranking = this.rankingService.findById(id);
        this.rankingService.delete(ranking);
        return true;
    }

}
