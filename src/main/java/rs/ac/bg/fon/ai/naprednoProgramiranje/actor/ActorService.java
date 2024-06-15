package rs.ac.bg.fon.ai.naprednoProgramiranje.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jolovic
 * Service layer class for our Actors. Here lies the business logic of adding actors to H2 db.
 */
@Service
public class ActorService {

    /**
     * private field that ensures a reference to @ActorRepository class.
     */
    @Autowired
    private ActorRepository actorRepository;

    /**
     * Method that saves passed @Actor in H2 db.
     * @throws IllegalArgumentException if NO. of Oscar awards is less then 0.
     * @param actor to be passed to H2 db for persisting it.
     * @return @Actor that we are passing through JSON and saving in H2 db.
     */
    public Actor saveActor(Actor actor){
        if(actor.getNoOfOscars()<0)
            throw new IllegalArgumentException("NO. of Oscar awards mus be greater of equal to 0.");
        return actorRepository.save(actor);
    }

}
