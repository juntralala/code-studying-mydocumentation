package muhammad.junaidi.test.mockito.contohMock.service;

import muhammad.junaidi.test.mockito.contohMock.data.Person;
import muhammad.junaidi.test.mockito.contohMock.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    public void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.get("Not Found"));
    }

    @Test
    public void testPersonSuccess() {
        Mockito.when(personRepository.selectById("foundId"))
                .thenReturn(new Person("foundId", "Dummy"));
        var person = personService.get("foundId");

        Assertions.assertNotNull(person);
    }

    @Test
    public void testRegisterSuccess() {
        var person = personService.register("dummy");
        Assertions.assertEquals("dummy", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "dummy"));
    }

}
