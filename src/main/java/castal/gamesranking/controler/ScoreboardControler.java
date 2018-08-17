package castal.gamesranking.controler;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Scoreboard;
import castal.gamesranking.service.PlayerService;
import castal.gamesranking.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scoreboards")
public class ScoreboardControler {

    @Autowired
    private ScoreboardService scoreboardService;
    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/{id}")
    public Scoreboard findById(@PathVariable("id") Long id) {
        return this.scoreboardService.findById(id);
    }

    @GetMapping()
    public List<Scoreboard> findAll() {
        return this.scoreboardService.findAll();
    }

    @PostMapping()
    public Scoreboard save(@RequestBody Scoreboard scoreboard) {
        scoreboard.setScoreEntries(null);
        return this.scoreboardService.saveOrUpdate(scoreboard);
    }

    @PostMapping(value = "/{scoreboardId}/incrementVictories/{playerId}")
    public Scoreboard incrementVictories(@PathVariable("scoreboardId") Long scoreboardId, @PathVariable("playerId") Long playerId) {
        Scoreboard scoreboard = this.scoreboardService.findById(scoreboardId);
        Player player = this.playerService.findById(playerId);

        if (scoreboard == null) {
            throw new RuntimeException("Scoreboard não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.scoreboardService.incrementVictories(scoreboard, player);
    }

    @PostMapping(value = "/{scoreboardId}/decreaseVictories/{playerId}")
    public Scoreboard decreaseVictories(@PathVariable("scoreboardId") Long scoreboardId, @PathVariable("playerId") Long playerId) {
        Scoreboard scoreboard = this.scoreboardService.findById(scoreboardId);
        Player player = this.playerService.findById(playerId);

        if (scoreboard == null) {
            throw new RuntimeException("Scoreboard não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.scoreboardService.decreaseVictories(scoreboard, player);
    }

    @PostMapping(value = "/{scoreboardId}/incrementMatches/{playerId}")
    public Scoreboard incrementMatches(@PathVariable("scoreboardId") Long scoreboardId, @PathVariable("playerId") Long playerId) {
        Scoreboard scoreboard = this.scoreboardService.findById(scoreboardId);
        Player player = this.playerService.findById(playerId);

        if (scoreboard == null) {
            throw new RuntimeException("Scoreboard não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.scoreboardService.incrementMatches(scoreboard, player);
    }

    @PostMapping(value = "/{scoreboardId}/decreaseMatches/{playerId}")
    public Scoreboard decreaseMatches(@PathVariable("scoreboardId") Long scoreboardId, @PathVariable("playerId") Long playerId) {
        Scoreboard scoreboard = this.scoreboardService.findById(scoreboardId);
        Player player = this.playerService.findById(playerId);

        if (scoreboard == null) {
            throw new RuntimeException("Scoreboard não localizado");
        }

        if (player == null) {
            throw new RuntimeException("Player não localizado");
        }

        return this.scoreboardService.decreaseMatches(scoreboard, player);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        Scoreboard scoreboard = this.scoreboardService.findById(id);
        this.scoreboardService.delete(scoreboard);
        return true;
    }

}
