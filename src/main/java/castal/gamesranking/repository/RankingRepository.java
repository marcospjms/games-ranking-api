package castal.gamesranking.repository;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Ranking;
import castal.gamesranking.model.RankingEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Long> {

    @Query("SELECT scoreEntry FROM Ranking ranking JOIN ranking.scoreEntries scoreEntry " +
            "WHERE scoreEntry.player = :player AND ranking = :selectedRanking")
    RankingEntry findScoreEntry(@Param("player") Player player, @Param("selectedRanking") Ranking selectedRanking);
}
