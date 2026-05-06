package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.enemy.Enemy;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {

    private final Random random = new Random();
    private int shootCooldown = 0;

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            if (random.nextInt(60) == 0) {
                enemy.setRotation(random.nextDouble() * 360);
            }
            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + changeX * 2);
            enemy.setY(enemy.getY() + changeY * 2);

            if (enemy.getX() < 0) enemy.setX(gameData.getDisplayWidth());
            if (enemy.getX() > gameData.getDisplayWidth()) enemy.setX(0);
            if (enemy.getY() < 0) enemy.setY(gameData.getDisplayHeight());
            if (enemy.getY() > gameData.getDisplayHeight()) enemy.setY(0);

            shootCooldown--;
            if (shootCooldown <= 0 && random.nextInt(100) < 3) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> world.addEntity(spi.createBullet(enemy, gameData))
                );
                shootCooldown = 60;
            }
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
    }
}