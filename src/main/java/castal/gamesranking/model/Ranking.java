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
    private Set<RankingEntry> scoreEntries;

    public Ranking() {
    }

    public Ranking(Set<RankingEntry> scoreEntries) {
        this.scoreEntries = scoreEntries;
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

    public Set<RankingEntry> getScoreEntries() {
        return scoreEntries;
    }

    public void setScoreEntries(Set<RankingEntry> scoreEntries) {
        this.scoreEntries = scoreEntries;
    }

    public void addScoreEntry(RankingEntry rankingEntry) {
        if (this.scoreEntries == null) {
            this.scoreEntries = new HashSet<>();
        }
        this.scoreEntries.add(rankingEntry);
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
                ", scoreEntries=" + scoreEntries +
                '}';
    }
}
