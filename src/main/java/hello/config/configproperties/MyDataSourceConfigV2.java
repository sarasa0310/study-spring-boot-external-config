package hello.config.configproperties;

import hello.datasource.MyDataSource;
import hello.datasource.configproperties.MyDataSourcePropertiesV2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class MyDataSourceConfigV2 {

    private final MyDataSourcePropertiesV2 properties;

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource(
                properties.getUrl(),
                properties.getUsername(),
                properties.getPassword(),
                properties.getEtc().getMaxConnection(),
                properties.getEtc().getTimeout(),
                properties.getEtc().getOptions()
        );
    }

}
