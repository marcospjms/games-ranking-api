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

    public Ranking saveOrUpdate(Ranking ranking) {
        return this.repository.save(ranking);
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

    public Ranking createRankingEntry(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findRankingEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addRankingEntry(rankingEntry);
        }

        return this.repository.save(ranking);

    }

    public Ranking incrementVictories(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findRankingEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addRankingEntry(rankingEntry);
        }

        rankingEntry.incrementVictories();

        return this.repository.save(ranking);

    }

    public Ranking decreaseVictories(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findRankingEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addRankingEntry(rankingEntry);
        }

        rankingEntry.decreaseVictories();

        return this.repository.save(ranking);

    }

    public Ranking incrementMatches(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findRankingEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addRankingEntry(rankingEntry);
        }

        rankingEntry.incrementMatches();

        return this.repository.save(ranking);

    }

    public Ranking decreaseMatches(Ranking ranking, Player player) {

        RankingEntry rankingEntry = this.repository.findRankingEntry(player, ranking);

        if (rankingEntry == null) {
            rankingEntry = new RankingEntry(player);
            ranking.addRankingEntry(rankingEntry);
        }

        rankingEntry.decreaseMatches();

        return this.repository.save(ranking);

    }


}
