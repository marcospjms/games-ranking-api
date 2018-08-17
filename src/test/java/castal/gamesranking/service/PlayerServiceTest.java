package castal.gamesranking.service;

import castal.gamesranking.model.Player;
import castal.gamesranking.repository.PlayerRepository;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void testFindAllPlayers() {
        when(this.playerService.count()).thenReturn(3L);

        assertEquals(3, this.playerService.count());


    }
}
