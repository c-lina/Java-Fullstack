package com.revature.P1Demo;

import com.revature.DAOs.PetDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.models.User;
import com.revature.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class P1DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	//TestRestTemplate test for our PetController

	//RestTemplate lets us send HTTP requests from OUR OWN JAVA SERVER
		//TestRestTemplate is a subclass that we can use for testing

	@Test
	public void testInsertPet() {
		//Instantiate a new test object
		TestRestTemplate restTemplate = new TestRestTemplate();

		//Create a new IncomingPetDTO to use in our test
		IncomingPetDTO petDTO = new IncomingPetDTO("Dog", "Fido", 4);

		//send a post request to /pets and save the returned Pet to run our tests on
		Pet p = restTemplate.postForObject("http://localhost:7777/pets", petDTO, Pet.class);

		//basic test, make sure our Pet object came bask as expected
		assertNotNull(p);
		assertNotEquals(p.getPet_id(), 0);
		assertEquals(p.getSpecies(), "Dog");

		ResponseEntity<Pet> response = restTemplate.postForEntity("http://localhost:7777/pets", petDTO, Pet.class);

		//Now we can test what status code comes back
		assertEquals("201 CREATED", response.getStatusCode().toString());
	}

	//HEY but what if I DON'T want to send real requests that manipulate our real DB?
	//We can use Mock MVC instead of TestRestTemplate

	//A Mockito test for addPet() method in PetService--------------------------

	//A lot of setup first

	//Create a mock PetDAO and mock UserDAO - fake DAO objects our Service tests will use
	@Mock
	PetDAO pDAO;

	@Mock
	UserDAO uDAO;

	//Next, we'll add concrete PetService that we'll spy on.
	//This lets us run methods like verify() and make sure a method in the service method got called

	@Spy
	PetService petService = new PetService(pDAO, uDAO);
	//Concrete IncomingPetDTO and Pet objects to use in our test (Pet will match the DTO)

	//Concrete IncomingPetDTO and Pet objects to use in our test

	//Finally, we can write our test that all of our objects that we set up

	IncomingPetDTO petDTO = new IncomingPetDTO("Cat", "Grandpa", 1);

	Pet pet = new Pet(0, "Cat", "Grandpa", null);
	//we'll leave the Pet's user null just for the ease of testing

	//Before each test, we want to initialize our mocks our PetService spy

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this); //open the registered mocks in "this" class
		petService = spy(new PetService(pDAO, uDAO));
	}

	//Finally, we can write our test that all of our objects that we set up

	@Test
	public void testInsertPetWithMockito() {
		//set up some snubbing - placeholder values that our Mocked DAOs will return
		//remember, we're not testing the DAO, we're testing that the Service does what it's meant to do
		when(uDAO.findById(1)).thenReturn(Optional.of(new User(1, "testUser", "testPassword", "user")));
		when(pDAO.save((any(Pet.class)))).thenReturn(pet);

		//We can do one for exceptions Throws too
		when(uDAO.findById(0)).thenThrow(new IllegalArgumentException("User ID cannot be zero!"));

		//Let's finally call the Service's insertPet method with our pet object we defined above this test
		Pet returnedPet = petService.addPet(petDTO);

		//Now we can verify that the methods in question got called
		verify(uDAO, times(1)).findById(1);
		verify(pDAO, times(1)).save(any(Pet.class));

		//And we can insert that the Pet object is as expected
		assertNotNull(returnedPet);
		assertEquals(returnedPet.getSpecies(), "Cat");
	}
}

