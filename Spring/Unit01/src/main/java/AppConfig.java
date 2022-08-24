import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "bean2")
    public Bean getHeloBean(){
        HelloClazz bean =new HelloClazz();
        bean.message = "Xin chao vuong vip boi";
        return (Bean) bean;
    }
}
