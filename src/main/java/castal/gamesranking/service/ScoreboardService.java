package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.ScoreEntry;
import castal.gamesranking.model.Scoreboard;
import castal.gamesranking.repository.ScoreboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreboardService {
    @Autowired
    private ScoreboardRepository repository;

    public Scoreboard saveOrUpdate(Scoreboard score) {
        return this.repository.save(score);
    }

    public void delete(Scoreboard scoreboard) {
        this.repository.delete(scoreboard);
    }

    public List<Scoreboard> findAll() {
        return (List<Scoreboard>) this.repository.findAll();
    }

    public Scoreboard findById(Long id) {
        return (Scoreboard) this.repository.findById(id).get();
    }


    public long count() {
        return this.repository.count();
    }

    public Scoreboard incrementVictory(Scoreboard scoreboard, Player player) {

        ScoreEntry scoreEntry = this.repository.findScoreEntry(player, scoreboard);

        if (scoreEntry == null) {
            scoreEntry = new ScoreEntry(player);
            scoreboard.addScoreEntry(scoreEntry);
        }

        scoreEntry.incrementVictories();

        return this.repository.save(scoreboard);

    }

    public Scoreboard decrementVictory(Scoreboard scoreboard, Player player) {

        ScoreEntry scoreEntry = this.repository.findScoreEntry(player, scoreboard);

        if (scoreEntry == null) {
            scoreEntry = new ScoreEntry(player);
            scoreboard.addScoreEntry(scoreEntry);
        }

        scoreEntry.decrementVictories();

        return this.repository.save(scoreboard);

    }

    public Scoreboard incrementMatches(Scoreboard scoreboard, Player player) {

        ScoreEntry scoreEntry = this.repository.findScoreEntry(player, scoreboard);

        if (scoreEntry == null) {
            scoreEntry = new ScoreEntry(player);
            scoreboard.addScoreEntry(scoreEntry);
        }

        scoreEntry.incrementMatches();

        return this.repository.save(scoreboard);

    }

    public Scoreboard decrementMatches(Scoreboard scoreboard, Player player) {

        ScoreEntry scoreEntry = this.repository.findScoreEntry(player, scoreboard);

        if (scoreEntry == null) {
            scoreEntry = new ScoreEntry(player);
            scoreboard.addScoreEntry(scoreEntry);
        }

        scoreEntry.decrementMatches();

        return this.repository.save(scoreboard);

    }


}
