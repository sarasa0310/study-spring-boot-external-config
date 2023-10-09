package hello.datasource.configproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;

@Data
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV3 {

    private final String url;
    private final String username;
    private final String password;
    private final Etc etc;

    @Data
    public static class Etc {

        private final Integer maxConnection;
        private final Duration timeout;
        private final List<String> options;

    }

}
