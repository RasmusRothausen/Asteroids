package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.util.ServiceLocator;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        ServiceLocator.INSTANCE.loadPlugins("plugins");

        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ModuleConfig.class);

        Game game = context.getBean(Game.class);
        game.start(window);
        game.render();
    }
}