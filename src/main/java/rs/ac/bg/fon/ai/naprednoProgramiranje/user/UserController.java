package rs.ac.bg.fon.ai.naprednoProgramiranje.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{requiredId}")
    public ResponseEntity<AppUser> getUser(@PathVariable Long requiredId) {

        Optional<AppUser> user = Optional.ofNullable(userService.getUserById(requiredId));

        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/users")
    public List<AppUser> getUsers() {
      return userService.getAllUsers();
    }

    @PostMapping("/users/add")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(userService.createUser(appUser));
    }
    @PutMapping("/users/update/{requestedId}")
    public ResponseEntity<AppUser> updateUser(@PathVariable Long requestedId, @RequestBody AppUser appUser) {
        return ResponseEntity.ok(userService.updateUser(appUser, requestedId));
    }
    @DeleteMapping("/users/delete/{requestedId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Long requestedId) {
        userService.deleteUser(requestedId);
        return ResponseEntity.ok(200);
    }

}
