package executive;

import entity.Person;

import javax.ejb.Local;

/**
 * Created by Home on 6/3/2015.
 */
@Local
public interface HelloWorldLocal {
    public Person createPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(int id);
}