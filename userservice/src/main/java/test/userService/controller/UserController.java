package test.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.userService.dto.User;
import test.userService.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
//    @PostMapping("/register")
//    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        userService.registerUser(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
