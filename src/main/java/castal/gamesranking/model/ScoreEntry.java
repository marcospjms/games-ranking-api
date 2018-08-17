package castal.gamesranking.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_entries")
public class ScoreEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Player player;

    @Column(columnDefinition = "long default 0")
    private long victories = 0;

    @Column(columnDefinition = "long default 0")
    private long matches = 0;

    public ScoreEntry() {
    }

    public ScoreEntry(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getVictories() {
        return victories;
    }

    public void setVictories(Long victories) {
        this.victories = victories;
    }

    public void incrementVictories() {
        this.victories++;
        this.incrementMatches();
    }

    public void decrementVictories() {
        if (this.victories == 0) {
            throw new RuntimeException("Não é possível ter vitórias negativas");
        }
        this.victories--;
        this.decrementMatches();
    }

    public Long getMatches() {
        return matches;
    }

    public void setMatches(Long matches) {
        this.matches = matches;
    }

    public void incrementMatches() {
        this.matches++;
    }

    public void decrementMatches() {
        if (this.matches == 0) {
            throw new RuntimeException("Não é possível ter quantidade de partidas negativas");
        }
        this.matches--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreEntry that = (ScoreEntry) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ScoreEntry{" +
                "id=" + id +
                ", player=" + player +
                ", victories=" + victories +
                ", matches=" + matches +
                '}';
    }
}
