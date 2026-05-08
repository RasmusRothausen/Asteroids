package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerControlSystemTest {

    private PlayerControlSystem playerControlSystem;
    private GameData gameData;
    private World world;
    private Entity player;

    @BeforeEach
    void setUp() {
        playerControlSystem = new PlayerControlSystem();
        gameData = new GameData();
        world = new World();

        // Create and add a player to the world
        player = new Player();
        player.setX(400);
        player.setY(400);
        player.setRotation(0);
        world.addEntity(player);
    }

    @Test
    void testPlayerMovesForwardWhenUpPressed() {
        // Arrange - press UP key
        gameData.getKeys().setKey(GameKeys.UP, true);

        double startX = player.getX();
        double startY = player.getY();

        // Act
        playerControlSystem.process(gameData, world);

        // Assert - player should have moved
        assertNotEquals(startX, player.getX(), "Player X should have changed");
    }

    @Test
    void testPlayerRotatesLeftWhenLeftPressed() {
        // Arrange
        gameData.getKeys().setKey(GameKeys.LEFT, true);
        double startRotation = player.getRotation();

        // Act
        playerControlSystem.process(gameData, world);

        // Assert
        assertTrue(player.getRotation() < startRotation, "Player should have rotated left");
    }

    @Test
    void testPlayerRotatesRightWhenRightPressed() {
        // Arrange
        gameData.getKeys().setKey(GameKeys.RIGHT, true);
        double startRotation = player.getRotation();

        // Act
        playerControlSystem.process(gameData, world);

        // Assert
        assertTrue(player.getRotation() > startRotation, "Player should have rotated right");
    }

    @Test
    void testPlayerStaysWithinBounds() {
        // Arrange - move player to edge
        player.setX(0);
        player.setY(0);
        gameData.getKeys().setKey(GameKeys.UP, true);

        // Act
        playerControlSystem.process(gameData, world);

        // Assert - player should not go below 0
        assertTrue(player.getX() >= 0, "Player X should stay within bounds");
        assertTrue(player.getY() >= 0, "Player Y should stay within bounds");
    }

    @Test
    void testPlayerDoesNotMoveWithoutInput() {
        // Arrange - no keys pressed
        double startX = player.getX();
        double startY = player.getY();

        // Act
        playerControlSystem.process(gameData, world);

        // Assert
        assertEquals(startX, player.getX(), "Player X should not change");
        assertEquals(startY, player.getY(), "Player Y should not change");
    }
}