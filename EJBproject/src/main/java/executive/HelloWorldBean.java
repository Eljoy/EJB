package executive;

import entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Home on 6/3/2015.
 */

@Stateless
public class HelloWorldBean implements HelloWorldLocal {
    @PersistenceContext(unitName="persons_dates")
    private EntityManager manager;

    public Person createPerson(Person person) {
        manager.persist(person);
        return person;
    }

    public void updatePerson(Person person) {
        manager.merge(person);
    }

    public void deletePerson(int id) {
        Person person = manager.find(Person.class, id);
        manager.remove(person);
    }
}
