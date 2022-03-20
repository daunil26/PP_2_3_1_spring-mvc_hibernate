package web.controller;

import hiber.config.PersistenceJPAConfig;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hiber.model.User;

import java.util.List;

@Controller
public class UsersController {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
    private final UserService userService = context.getBean(UserService.class);

    @GetMapping()
    public String index(Model users) {
        List<User> userList = userService.listUsers();
        users.addAttribute("userList", userList);
        return "users/index";
    }

    @GetMapping("/{id}")
    public String userPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/userPage";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,  Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUserById(user);
        return "users/userPage";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
