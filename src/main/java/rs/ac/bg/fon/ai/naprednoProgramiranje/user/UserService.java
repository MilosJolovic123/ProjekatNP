package rs.ac.bg.fon.ai.naprednoProgramiranje.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public AppUser createUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public List<AppUserDTO> getAllUsers() {
        List<AppUser> users = userRepository.findAll();

        List<AppUserDTO> userDTOs = new ArrayList<>();

        for(AppUser u:users){
            AppUserDTO userDTO = new AppUserDTO();
            userDTO.setUsername(u.getUsername());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    public AppUserDTO getUserById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);
        AppUserDTO userDTO = new AppUserDTO();
        userDTO.setUsername(user.get().getUsername());
        return userDTO;
    }
    public AppUser updateUser(AppUser appUser,Long requestedId) {

        AppUser userToUpdate = userRepository.getById(requestedId);
        userToUpdate.setUsername(appUser.getUsername());
        userToUpdate.setPassword(appUser.getPassword());
        userToUpdate.setRoles(appUser.getRoles());
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
