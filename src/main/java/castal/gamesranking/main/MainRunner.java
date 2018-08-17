package castal.gamesranking.main;

import castal.gamesranking.model.Player;
import castal.gamesranking.model.Scoreboard;
import castal.gamesranking.service.PlayerService;
import castal.gamesranking.service.ScoreboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"castal.gamesranking"})
@EntityScan(basePackages = {"castal.gamesranking"})
@EnableJpaRepositories(basePackages = {"castal.gamesranking"})
public class MainRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainRunner.class);

    @Autowired
    private PlayerService playerService;
    @Autowired
    private ScoreboardService scoreboardService;

    public static void main(String[] args) {
        SpringApplication.run(MainRunner.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Número de jogadores = {}", this.playerService.findAll().size());
        Player player = new Player("Marcos Paulo");
        Scoreboard scoreboard = new Scoreboard();

        this.playerService.saveOrUpdate(player);
        this.scoreboardService.saveOrUpdate(scoreboard);
        scoreboard = this.scoreboardService.incrementVictories(scoreboard, player);
        LOGGER.info("Número de jogadores = {}", this.playerService.findAll().size());
        LOGGER.info("Número de scoreboards = {}", this.playerService.findAll().size());

        LOGGER.info("Scoreboard final = {}", scoreboard);

    }
}
