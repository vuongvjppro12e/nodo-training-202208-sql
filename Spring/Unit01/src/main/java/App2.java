import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class App2 {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    public void setCtx(AnnotationConfigApplicationContext ctx) {
        this.ctx = ctx;
        ctx.register(AppConfig.class);
        ctx.refresh();
      Bean mybean = (Bean) ctx.getBean("bean2");
        System.out.println(mybean);
    }
}
