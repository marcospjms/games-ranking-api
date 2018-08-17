package castal.gamesranking.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "scoreboards")
public class Scoreboard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<ScoreEntry> scoreEntries;

    public Scoreboard() {
    }

    public Scoreboard(List<ScoreEntry> scoreEntries) {
        this.scoreEntries = scoreEntries;
    }

    public Long getId() {
        return id;
    }

    public List<ScoreEntry> getScoreEntries() {
        return scoreEntries;
    }

    public void setScoreEntries(List<ScoreEntry> scoreEntries) {
        this.scoreEntries = scoreEntries;
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
}
