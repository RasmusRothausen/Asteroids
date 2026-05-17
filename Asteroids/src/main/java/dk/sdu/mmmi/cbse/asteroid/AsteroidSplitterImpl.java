package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;
import java.util.Random;

public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        // Only split if asteroid is big enough
        if (e.getRadius() < 5) {
            return;
        }

        Random rnd = new Random();
        for (int i = 0; i < 2; i++) {
            Entity splitAsteroid = new Asteroid();
            float newSize = e.getRadius() / 2;
            splitAsteroid.setPolygonCoordinates(newSize, -newSize, -newSize, -newSize, -newSize, newSize, newSize, newSize);
            splitAsteroid.setX(e.getX() + rnd.nextInt(10) - 5);
            splitAsteroid.setY(e.getY() + rnd.nextInt(10) - 5);
            splitAsteroid.setRadius(newSize);
            splitAsteroid.setRotation(rnd.nextInt(360));
            world.addEntity(splitAsteroid);
        }
    }
}