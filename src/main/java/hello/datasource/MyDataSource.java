package hello.datasource;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j
@ToString
@AllArgsConstructor
public class MyDataSource {

    private String url;
    private String username;
    private String password;
    private Integer maxConnection;
    private Duration timeout;
    private List<String> options;

    @PostConstruct
    public void init() {
        log.info("{}", this);
    }

}
