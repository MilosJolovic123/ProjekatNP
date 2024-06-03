package rs.ac.bg.fon.ai.naprednoProgramiranje.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public AppUser createUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser getUserById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);

        return user.orElse(null);
    }
    public AppUser updateUser(AppUser appUser,Long requestedId) {

        AppUser userToUpdate = getUserById(requestedId);
        userToUpdate.setUsername(appUser.getUsername());
        userToUpdate.setPassword(appUser.getPassword());
        userToUpdate.setNameAndLastName(appUser.getNameAndLastName());
        userToUpdate.setReviews(appUser.getReviews());
        userToUpdate.setNewsletterSet(appUser.getNewsletterSet());

        return userRepository.save(userToUpdate);
    }
    public void deleteUser(Long requestedId) {
        //AppUser userToDelete = getUserById(requestedId);
        userRepository.deleteById(requestedId);
    }
}
