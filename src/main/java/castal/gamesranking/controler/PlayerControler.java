package castal.gamesranking.controler;

import castal.gamesranking.model.Player;
import castal.gamesranking.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerControler {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/{id}")
    public Player findById(@PathVariable("id") Long id) {
        return this.playerService.findById(id);
    }

    @GetMapping()
    public List<Player> findAll() {
        return this.playerService.findAll();
    }

    @PostMapping()
    public Player save(@RequestBody Player player) {
        return this.playerService.saveOrUpdate(player);
    }

    @PutMapping()
    public Player update(@RequestBody Player player) {
        return this.playerService.saveOrUpdate(player);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        Player player = this.playerService.findById(id);
        this.playerService.delete(player);
        return true;
    }
}
