package castal.gamesranking.repository;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Scoreboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreboardRepository extends CrudRepository<Scoreboard, Long> {
}
