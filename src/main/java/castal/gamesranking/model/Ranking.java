package castal.gamesranking.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RankingEntry> rankingEntries;

    public Ranking() {
    }

    public Ranking(Set<RankingEntry> rankingEntries) {
        this.rankingEntries = rankingEntries;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RankingEntry> getRankingEntries() {
        return rankingEntries;
    }

    public void setRankingEntries(Set<RankingEntry> rankingEntries) {
        this.rankingEntries = rankingEntries;
    }

    public void addRankingEntry(RankingEntry rankingEntry) {
        if (this.rankingEntries == null) {
            this.rankingEntries = new HashSet<>();
        }
        this.rankingEntries.add(rankingEntry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranking that = (Ranking) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rankingEntries=" + rankingEntries +
                '}';
    }
}
