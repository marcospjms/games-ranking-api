package castal.gamesranking.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "scoreboards")
public class Scoreboard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ScoreEntry> scoreEntries;

    public Scoreboard() {
    }

    public Scoreboard(Set<ScoreEntry> scoreEntries) {
        this.scoreEntries = scoreEntries;
    }

    public Long getId() {
        return id;
    }

    public Set<ScoreEntry> getScoreEntries() {
        return scoreEntries;
    }

    public void addScoreEntry(ScoreEntry scoreEntry) {
        if (this.scoreEntries == null) {
            this.scoreEntries = new HashSet<>();
        }
        this.scoreEntries.add(scoreEntry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scoreboard that = (Scoreboard) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "id=" + id +
                ", scoreEntries=" + scoreEntries +
                '}';
    }
}
