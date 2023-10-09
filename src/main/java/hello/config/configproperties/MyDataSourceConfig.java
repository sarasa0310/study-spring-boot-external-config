package hello.config.configproperties;

import hello.datasource.MyDataSource;
import hello.datasource.configproperties.MyDataSourcePropertiesV3;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
//@EnableConfigurationProperties(MyDataSourcePropertiesV3.class) // 수동 등록 방식
public class MyDataSourceConfig {

//    private final MyDataSourcePropertiesV1 properties;
//    private final MyDataSourcePropertiesV2 properties;
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
