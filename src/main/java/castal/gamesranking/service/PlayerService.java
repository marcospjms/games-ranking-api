package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public Player saveOrUpdate(Player player) {
        return this.repository.save(player);
    }

    public void delete(Player player) {
        this.repository.delete(player);
    }

    public List<Player> findAll() {
        return (List<Player>) this.repository.findAll();
    }

    public long count() {
        return this.repository.count();
    }
}
