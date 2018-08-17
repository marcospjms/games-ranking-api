package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Ranking;
import castal.gamesranking.model.RankingEntry;
import castal.gamesranking.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository repository;

    public Ranking saveOrUpdate(Ranking score) {
        return this.repository.save(score);
    }

    public void delete(Ranking ranking) {
        this.repository.delete(ranking);
    }

    public List<Ranking> findAll() {
        return (List<Ranking>) this.repository.findAll();
    }

    public Ranking findById(Long id) {
        return (Ranking) this.repository.findById(id).get();
    }


    public long count() {
        return this.repository.count();
    }

    public Ranking createScoreEntry(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findScoreEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addScoreEntry(rankingEntry);
        }

        return this.repository.save(ranking);

    }

    public Ranking incrementVictories(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findScoreEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addScoreEntry(rankingEntry);
        }

        rankingEntry.incrementVictories();

        return this.repository.save(ranking);

    }

    public Ranking decreaseVictories(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findScoreEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addScoreEntry(rankingEntry);
        }

        rankingEntry.decreaseVictories();

        return this.repository.save(ranking);

    }

    public Ranking incrementMatches(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findScoreEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addScoreEntry(rankingEntry);
        }

        rankingEntry.incrementMatches();

        return this.repository.save(ranking);

    }

    public Ranking decreaseMatches(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findScoreEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addScoreEntry(rankingEntry);
        }

        rankingEntry.decreaseMatches();

        return this.repository.save(ranking);

    }


}
