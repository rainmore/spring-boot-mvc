package net.rainmore.platform;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:test.properties")
@ComponentScan(basePackages = {"net.rainmore.platform"})
public class TestApplicationContext {
    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(environment.getRequiredProperty("test.db.driver"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("test.db.url"));
        dataSource.setUsername(environment.getRequiredProperty("test.db.username"));
        dataSource.setPassword(environment.getRequiredProperty("test.db.password"));

        return dataSource;
    }
}
