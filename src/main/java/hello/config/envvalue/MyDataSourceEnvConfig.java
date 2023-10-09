package hello.config.envvalue;

import hello.datasource.MyDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.Duration;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MyDataSourceEnvConfig {

    private final Environment env;

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource(
                env.getProperty("my.datasource.url"),
                env.getProperty("my.datasource.username"),
                env.getProperty("my.datasource.password"),
                env.getProperty("my.datasource.etc.max-connection", Integer.class),
                env.getProperty("my.datasource.etc.timeout", Duration.class),
                env.getProperty("my.datasource.etc.options", List.class)
        );
    }

}
