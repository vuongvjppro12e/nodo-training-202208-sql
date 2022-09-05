package dao;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.sql.DataSource;
import java.util.List;

public class AppConfig extends WebMvcAutoConfigurationAdapter {
    @Autowired
    private org.springframework.core.env.Environment env;

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        super.configureHandlerExceptionResolvers(resolvers);
    }

    public AppConfig() {
        this(null, null, null, null, null, null, null);
    }

    public AppConfig(WebProperties webProperties, WebMvcProperties mvcProperties, ListableBeanFactory beanFactory, ObjectProvider<HttpMessageConverters> messageConvertersProvider, ObjectProvider<WebMvcAutoConfiguration.ResourceHandlerRegistrationCustomizer> resourceHandlerRegistrationCustomizerProvider, ObjectProvider<DispatcherServletPath> dispatcherServletPath, ObjectProvider<ServletRegistrationBean<?>> servletRegistrations) {
        super(webProperties, mvcProperties, beanFactory, messageConvertersProvider, resourceHandlerRegistrationCustomizerProvider, dispatcherServletPath, servletRegistrations);
    }

    @Bean
    public DataSource dataSource(){
        String url = env.getProperty("jdbc.url");
        DriverManagerDataSource dataSource = new constructor(url);
        dataSource.setDriverClassName(url);
        dataSource.setUsername(url);
        return dataSource();
    }
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactory = sessionFactoryBean();
        sessionFactory.setDataSource(dataSource());

    return sessionFactoryBean();
    }

    private class constructor extends DriverManagerDataSource {
        public constructor(String url) {
        }
    }
}
