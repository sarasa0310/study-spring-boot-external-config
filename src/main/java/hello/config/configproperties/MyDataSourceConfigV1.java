package hello.config.configproperties;

import hello.datasource.MyDataSource;
import hello.datasource.configproperties.MyDataSourcePropertiesV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
//@EnableConfigurationProperties(MyDataSourcePropertiesV1.class) // 수동 등록
public class MyDataSourceConfigV1 {

    private final MyDataSourcePropertiesV1 properties;

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
