package muhammad.junaidi.test.mockito.contohMock.repository;

import muhammad.junaidi.test.mockito.contohMock.data.Person;

public interface PersonRepository {

    public Person selectById(String id);

    public void insert(Person person);

}
