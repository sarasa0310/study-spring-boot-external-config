package hello.config.configproperties;

import hello.datasource.MyDataSource;
import hello.datasource.configproperties.MyDataSourcePropertiesV3;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class MyDataSourceConfigV3 {

    private final MyDataSourcePropertiesV3 properties;

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
