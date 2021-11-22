package com.example.codeclan.pirateservice;
import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	//injects an instance of the pirate repo - gives ability to use pirate repo in this test file.
	PirateRepository pirateRepository;
	//imports repo
	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreatePirate(){
		Ship ship1 = new Ship("The Black Pearl");
		shipRepository.save(ship1);
		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship1);
		//save instance of pirate to DB: pirateRepository.SqlMethod(InstanceName)
		pirateRepository.save(jack);
		Raid raid1 = new Raid("The sacking of Oddbins", 1000);
		raidRepository.save(raid1);

		raid1.addPirate(jack);
		raidRepository.save(raid1);

	}

}

/*dependency injection: obj instantiated elsewhere and given to us for use - injected as dependency.*/

//convention: obj camelcase, class uppercase