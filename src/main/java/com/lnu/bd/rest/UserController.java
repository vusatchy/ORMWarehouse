package com.lnu.bd.rest;

import com.lnu.bd.authentication.AuthenticationResult;
import com.lnu.bd.dao.UserRepository;
import com.lnu.bd.model.User;
import com.lnu.bd.impl.UserServiceImp;
import com.lnu.bd.service.UserService;
import com.lnu.bd.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/registration")
    private String registration(Model model) {
        return "registration";
    }

    @PostMapping(value = "/registration")
    private String registration(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            Model model) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationTime(Date.valueOf(LocalDate.now()));
        AuthenticationResult authenticationResult = userService.saveUser(user);
        if (authenticationResult == AuthenticationResult.SUCCESS) {
            model.addAttribute("id", String.valueOf(user.getId()));
            model.addAttribute("message", AuthenticationResult.SUCCESS.getValue());
        } else {
            model.addAttribute("error", authenticationResult.getValue());
        }
        return "registration";
    }

    @GetMapping(value = "/login")
    private String login(Model model) {
        return "login";
    }

    @PostMapping(value = "/login")
    private String login(Model model,
                         @RequestParam(value = "login") String login,
                         @RequestParam(value = "password") String password) {
        User user = userService.findUser(login, password);
        if (user == null) {
            model.addAttribute("error", "Your username and password is invalid.");
        } else {
            model.addAttribute("message", AuthenticationResult.SUCCESS.getValue());
            model.addAttribute("id", String.valueOf(user.getId()));
            return "login";
        }
        return "login";
    }


    /*@RequestMapping(value = "/user/starts", method = RequestMethod.GET)
    public List<User> starts(@RequestParam(value = "pref") String prefix) {
        return userRepositiry.findByLoginStartsWith(prefix);
    }

    @RequestMapping(value = "/user/sum", method = RequestMethod.GET)
    public String sum(@RequestParam(value = "id") int id) {
        double sum = userRepositiry.sumFunction(id);
        String html = "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                " <head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title></title>\n" +
                " </head>\n" +
                " <body>\n" +
                "\n" +
                "  <h1>Uuser with id %d  : %d dollars</h1>\n" +
                "\n" +
                " </body>\n" +
                "</html>";
        return String.format(html, id, new Double(sum).intValue());
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User byId(@RequestParam(value = "id") int id) {
        return userRepositiry.findById(id).get();
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void add(@RequestParam(value = "login") String login,
                    @RequestParam(value = "password") String password,
                    @RequestParam(value = "email") String email) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRegistrationTime(Date.valueOf(LocalDate.now()));
        userRepositiry.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id") int id) {
        User user = new User();
        user.setId(id);
        userRepositiry.delete(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void update(@RequestParam(value = "id") int id,
                       @RequestParam(value = "password") String password) {
        User user = userRepositiry.findById(id).get();
        user.setPassword(password);
        userRepositiry.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> all() {
        List<User> target = new ArrayList<>();
        userRepositiry.findAll().forEach(target::add);
        return target;
    }*/

}