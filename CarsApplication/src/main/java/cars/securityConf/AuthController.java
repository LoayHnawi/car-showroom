package cars.securityConf;

import cars.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/auth")
public class AuthController {

    Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping(value = {"/",""})
    public jwtResponse signIn(@RequestBody SignInRequest signInRequest) throws Exception {
        log.info("authentication>>");
//        Authentication authentication ;
//        try{
       final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword()));
//        }
//        catch (DisabledException dis)
//        {
//            return  new jwtResponse(null,null,null,"USER_DISABLED");
//        }
//        catch (BadCredentialsException e)
//        {
//            return new jwtResponse(null,null,null,"INVALID_CREDENTIAL");
//        }

//        log.info("authentication>>"+ authentication.isAuthenticated());
//        if(authentication.isAuthenticated()){
//
//            log.info("authentication>>" + authentication.isAuthenticated());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
            String token = tokenUtil.generateToken(userDetails);

            jwtResponse response = new jwtResponse(token);
            return response;
        }

}
