package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	private PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	private RaidRepository raidRepository;



	@Test
	void contextLoads() {
	}


	@Test
	public void createPirateAndShipAndRaids(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Raid raid = new Raid("Treasure Island", 700);
		Raid raid1 = new Raid("Cornwall", 100);
		raidRepository.save(raid);
		raidRepository.save(raid1);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		Pirate pirate2 = new Pirate("John", "Wild", 33, ship);
		Pirate pirate3 = new Pirate("Nick", "Greek", 41, ship);
		pirateRepository.save(pirate1);
		pirateRepository.save(pirate2);
		pirateRepository.save(pirate3);

		pirate1.addRaid(raid);
		pirateRepository.save(pirate1);

		pirate2.addRaid(raid);
		pirateRepository.save(pirate2);

		raid1.addPirate(pirate1);
		raidRepository.save(raid1);

		raid.addPirate(pirate1);
		raidRepository.save(raid);

		raid1.addPirate(pirate2);
		raidRepository.save(raid1);

		raid1.addPirate(pirate3);
		raidRepository.save(raid1);


	}
}


