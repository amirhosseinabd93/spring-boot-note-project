package ir.arcademy.notes;

import ir.arcademy.notes.modules.file.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableSpringDataWebSupport
@ComponentScan({"ir.arcademy.notes"})
@EnableJpaRepositories({"ir.arcademy.notes"})
@EntityScan({"ir.arcademy.notes"})
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class NotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesApplication.class, args);
    }

}
