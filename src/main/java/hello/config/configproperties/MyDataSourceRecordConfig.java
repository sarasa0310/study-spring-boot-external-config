package hello.config.configproperties;

import hello.datasource.MyDataSource;
import hello.datasource.configproperties.MyDataSourcePropertiesRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class MyDataSourceRecordConfig {

    private final MyDataSourcePropertiesRecord properties;

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource(
                properties.url(),
                properties.username(),
                properties.password(),
                properties.etc().maxConnection(),
                properties.etc().timeout(),
                properties.etc().options()
        );
    }

}
