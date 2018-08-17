package castal.gamesranking.repository;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.ScoreEntry;
import castal.gamesranking.model.Scoreboard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreboardRepository extends CrudRepository<Scoreboard, Long> {

    @Query("SELECT scoreEntry FROM Scoreboard scoreboard JOIN scoreboard.scoreEntries scoreEntry " +
            "WHERE scoreEntry.player = :player AND scoreboard = :selectedScoreboard")
    ScoreEntry findScoreEntry(@Param("player") Player player, @Param("selectedScoreboard") Scoreboard selectedScoreboard);
}
