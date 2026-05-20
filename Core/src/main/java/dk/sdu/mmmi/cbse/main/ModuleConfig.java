package dk.sdu.mmmi.cbse.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ModuleConfig {

    @Bean
    public Game game() {
        return new Game(scoreClient());
    }

    @Bean
    public ScoreClient scoreClient() {
        return new ScoreClient();
    }
}