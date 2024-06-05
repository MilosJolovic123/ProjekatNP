//package rs.ac.bg.fon.ai.naprednoProgramiranje.logging;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import rs.ac.bg.fon.ai.naprednoProgramiranje.user.AppUser;
//import rs.ac.bg.fon.ai.naprednoProgramiranje.user.UserRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LoggedUserService {
//
//
//    @Autowired
//    private LoggedUserRepository loggedUserRepository;
//    @Autowired
//    private UserRepository userRepository;
//    public boolean login(String username, String password){
//        List<LoggedUser> loggedUserList = loggedUserRepository.findAll();
//        if(!loggedUserList.isEmpty()){
//       return false; }
//        List<AppUser> usersList = userRepository.findAll();
//
//        for(AppUser user: usersList){
//            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
//                loggedUserRepository.save(new LoggedUser(username,password));
//                return true;
//            }
//        }
//    return false;
//    }
//    public boolean logout(){
//        List<LoggedUser> loggedUserList=loggedUserRepository.findAll();
//        if(loggedUserList.isEmpty())
//            return false;
//        else{
//        loggedUserRepository.deleteAll();
//        return true;
//        }
//    }
//
//}
