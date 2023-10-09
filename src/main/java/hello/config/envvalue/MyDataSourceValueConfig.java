package hello.config.envvalue;

import hello.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Configuration
public class MyDataSourceValueConfig {

    @Value("${my.datasource.url}")
    private String url;

    @Value("${my.datasource.username}")
    private String username;

    @Value("${my.datasource.password}")
    private String password;

//    @Value("${my.datasource.etc.max-connection:2}") <- ':' 사용하여 기본값 설정 가능
    @Value("${my.datasource.etc.max-connection}")
    private Integer maxConnection;

    @Value("${my.datasource.etc.timeout}")
    private Duration timeout;

    @Value("${my.datasource.etc.options}")
    private List<String> options;

    // 필드 주입 방식
    @Bean
    public MyDataSource myDataSource1() {
        return new MyDataSource(
                url, username, password, maxConnection, timeout, options
        );
    }

    // 파라미터 주입 방식
    @Bean
    public MyDataSource myDataSource2(
            @Value("${my.datasource.url}") String url,
            @Value("${my.datasource.username}") String username,
            @Value("${my.datasource.password}") String password,
            @Value("${my.datasource.etc.max-connection}") Integer maxConnection,
            @Value("${my.datasource.etc.timeout}") Duration timeout,
            @Value("${my.datasource.etc.options}") List<String> options
    ) {
        return new MyDataSource(
                url, username, password, maxConnection, timeout, options
        );
    }

}
