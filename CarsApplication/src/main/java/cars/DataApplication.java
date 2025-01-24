package cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableCaching
@EnableTransactionManagement(proxyTargetClass=true)
public class DataApplication  {
	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}
}
