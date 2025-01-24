package cars.home;

import cars.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger =  LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {

        if((userService.findAllUser()).isEmpty())
        {
            logger.info("No User accounts find");
        }

        AppUser user = new AppUser("lol","password") ;
        userService.saveUser(user);

    }
}
