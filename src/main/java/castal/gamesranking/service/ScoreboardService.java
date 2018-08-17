package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Scoreboard;
import castal.gamesranking.repository.PlayerRepository;
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

    public long count() {
        return this.repository.count();
    }


}
