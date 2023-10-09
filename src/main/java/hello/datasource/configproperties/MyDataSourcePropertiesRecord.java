package hello.datasource.configproperties;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

@Validated
@ConfigurationProperties("my.datasource")
public record MyDataSourcePropertiesRecord(
        @NotEmpty String url,
        @NotEmpty String username,
        @NotEmpty String password,
        Etc etc
) {

    public record Etc(
            @Min(1) @Max(999) Integer maxConnection,
            @DurationMin(seconds = 1) @DurationMax(seconds = 60) Duration timeout,
            List<String> options
    ) {
    }

}
