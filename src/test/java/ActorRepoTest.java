import com.iti.sakila.Entity.Actor;
import com.iti.sakila.persistance.repository.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ActorRepoTest {
    private static ActorRepository actorRepository;
    @BeforeAll
    public static void init(){
        actorRepository = new ActorRepository();
    }
    @Test
    public void getAll_Actors_From_Database(){
        //Arrange
        int expectedSize = 200;
        //Act
        int result = actorRepository.getAll().size();
        //Assert
        Assertions.assertEquals(expectedSize, result);
    }

    @Test
    public void update_Actor_details_in_Database() {
        //Arrange
        Actor actor = actorRepository.findById(1);
        actor.setFirstName("gomaa");
        //Act
        boolean isUpdated = actorRepository.update(actor);
        //Assert
        Assertions.assertTrue(isUpdated);
    }

    @Test
    public void delete_Actor_From_Database() {
        //Arrange
        int actor_id = 1;
        //Act
        boolean isUpdated = actorRepository.delete(actor_id);
        //Assert
        Assertions.assertTrue(isUpdated);
    }

    @Test
    public void find_Actor_By_Name() {
        //Arrange
        String actorName = "a";
        int expectedSize = 13;
        //Act
        List<Actor> result = actorRepository.findByName(actorName);
        for (Actor actor : result) {
            System.out.println(actor);
        }

        //Assert
        Assertions.assertEquals(expectedSize, result.size());
    }
    @Test
    public void insert_new_Actor_to_Database() {
        //Arrange
        Actor actor = new Actor("mohamed","gomaa", new Timestamp(new Date().getTime()));
        //Act
        boolean result = actorRepository.insert(actor);
        //Assert
        Assertions.assertTrue(result);
    }
}
