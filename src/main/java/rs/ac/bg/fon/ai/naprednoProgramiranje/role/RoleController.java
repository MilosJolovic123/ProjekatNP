package rs.ac.bg.fon.ai.naprednoProgramiranje.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jolovic
 * Rest controller that enables POST endpoint for saving role in H2 db.
 */
@RestController
public class RoleController {
    /**
     * Autowired field, reference to the RoleService.
     */
    @Autowired
    private RoleService roleService;

    /**
     * Secured method for saving a Role in H2 db.
     * @param role to be saved.
     * @param filmId in which film is the given role.
     * @param actorId which actor acts the role.
     * @return value of the role.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("role/add/{filmId}/{actorId}")
    public ResponseEntity<Role> addRole(@RequestBody Role role, @PathVariable Long filmId,@PathVariable Long actorId){

        return ResponseEntity.ok(roleService.saveRole(role,filmId,actorId));
    }


}
