//package rs.ac.bg.fon.ai.naprednoProgramiranje.logging;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//@RestController
//public class LoggedController {
//
//    @Autowired
//    private LoggedUserService loggedUserService;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
//        boolean logged = loggedUserService.login(username, password);
//        if(!logged)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
//
//        return ResponseEntity.ok("You have successfully logged in!");
//
//
//    }
//    @DeleteMapping("/logout")
//    public ResponseEntity<String> logout(){
//
//        boolean logout = loggedUserService.logout();
//
//        if(logout) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
//        }
//        return ResponseEntity.ok("You have successfuly logged out!");
//
//    }
//
//}
