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

//    private final BookingService bookingService;
//
//    public FirstTimeInitializer(BookingService bookingService) {
//        this.bookingService = bookingService;
//    }

    @Override
    public void run(String... args) throws Exception {

        if((userService.findAllUser()).isEmpty())
        {
            logger.info("No User accounts find");
        }

//        bookingService.book("Alice", "Bob", "Carol");
//        Assert.isTrue(bookingService.findAllBookings().size() == 3,
//                "First booking should work with no problem");
//        logger.info("Alice, Bob and Carol have been booked");
//        try {
//            bookingService.book("Chris", "Samuel");
//        } catch (RuntimeException e) {
//            logger.info("v--- The following exception is expect because 'Samuel' is too " +
//                    "big for the DB ---v");
//            logger.error(e.getMessage());
//        }
//
//        for (String person : bookingService.findAllBookings()) {
//            logger.info("So far, " + person + " is booked.");
//        }
//        logger.info("You shouldn't see Chris or Samuel. Samuel violated DB constraints, " +
//                "and Chris was rolled back in the same TX");
//        Assert.isTrue(bookingService.findAllBookings().size() == 3,
//                "'Samuel' should have triggered a rollback");
//
//        try {
//            bookingService.book("Buddy", null);
//        } catch (RuntimeException e) {
//            logger.info("v--- The following exception is expect because null is not " +
//                    "valid for the DB ---v");
//            logger.error(e.getMessage());
//        }
//
//        for (String person : bookingService.findAllBookings()) {
//            logger.info("So far, " + person + " is booked.");
//        }
//        logger.info("You shouldn't see Buddy or null. null violated DB constraints, and " +
//                "Buddy was rolled back in the same TX");
//        Assert.isTrue(bookingService.findAllBookings().size() == 3,
//                "'null' should have triggered a rollback");













//        AppUser user = new AppUser("lol","password") ;
//        userService.saveUser(user);
    }
}
