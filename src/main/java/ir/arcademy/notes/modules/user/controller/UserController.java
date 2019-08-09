package ir.arcademy.notes.modules.user.controller;

import ir.arcademy.notes.modules.user.domain.User;
import ir.arcademy.notes.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider ;

    @PostMapping("/register")
    @ResponseBody
    public void register(@Valid User user){
        userService.saveUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(User user){
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail() , user.getPassword()) ;
        try {
            Authentication authenticated = daoAuthenticationProvider.authenticate(auth) ;
            SecurityContextHolder.getContext().setAuthentication(authenticated);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
