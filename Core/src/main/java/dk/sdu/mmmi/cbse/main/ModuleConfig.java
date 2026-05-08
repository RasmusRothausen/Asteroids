package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.util.ServiceLocator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ModuleConfig {

    @Bean
    public Game game() {
        return new Game(gamePluginServices(), entityProcessingServices(), postEntityProcessingServices());
    }

    @Bean
    public List<IGamePluginService> gamePluginServices() {
        return new ArrayList<>(ServiceLocator.INSTANCE.locateAll(IGamePluginService.class));
    }

    @Bean
    public List<IEntityProcessingService> entityProcessingServices() {
        return new ArrayList<>(ServiceLocator.INSTANCE.locateAll(IEntityProcessingService.class));
    }

    @Bean
    public List<IPostEntityProcessingService> postEntityProcessingServices() {
        return new ArrayList<>(ServiceLocator.INSTANCE.locateAll(IPostEntityProcessingService.class));
    }
}