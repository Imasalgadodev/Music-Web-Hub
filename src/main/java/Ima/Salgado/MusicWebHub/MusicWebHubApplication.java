package Ima.Salgado.MusicWebHub;

import Ima.Salgado.MusicWebHub.model.Band;
import Ima.Salgado.MusicWebHub.model.Musician;
import Ima.Salgado.MusicWebHub.model.Product;
import Ima.Salgado.MusicWebHub.model.Venue;
import Ima.Salgado.MusicWebHub.repository.BandRepository;
import Ima.Salgado.MusicWebHub.repository.MusicianRepository;
import Ima.Salgado.MusicWebHub.repository.ProductRepository;
import Ima.Salgado.MusicWebHub.repository.VenueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class MusicWebHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicWebHubApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(MusicianRepository musicianRepository, BandRepository bandRepository, ProductRepository productRepository, VenueRepository venueRepository) {
		return args -> {
			//Datos precargados de prueba
			Musician musician1 = new Musician();
			musician1.setFirstName("John");
			musician1.setLastName("Doe");
			musician1.setAge(28);
			musician1.setGender("Male");
			musician1.setCountry("United States");
			musician1.setCity("New York");
			musician1.setPhoneNumber("123-456-7890");
			musician1.setEmail("john@example.com");
			musician1.setMainInstrument("Guitar");
			musician1.setBandName("The Rockers");
			musician1.setStatus("Looking for band");
			musician1.setMusicalInfluences("Classic Rock");
			musician1.setAvailability("Evenings and weekends");
			musician1.setEquipment("Guitar, Amp");
			musicianRepository.save(musician1);

			Musician musician2 = new Musician();
			musician2.setFirstName("Jane");
			musician2.setLastName("Smith");
			musician2.setAge(24);
			musician2.setGender("Female");
			musician2.setCountry("Canada");
			musician2.setCity("Toronto");
			musician2.setPhoneNumber("987-654-3210");
			musician2.setEmail("jane@example.com");
			musician2.setMainInstrument("Piano");
			musician2.setBandName("The Melodies");
			musician2.setStatus("Looking for shows");
			musician2.setMusicalInfluences("Classical, Jazz");
			musician2.setAvailability("Weekends");
			musician2.setEquipment("Piano, Microphone");
			musicianRepository.save(musician2);

			Musician musician3 = new Musician();
			musician3.setFirstName("Michael");
			musician3.setLastName("Jackson");
			musician3.setAge(50);
			musician3.setGender("Male");
			musician3.setCountry("United States");
			musician3.setCity("Los Angeles");
			musician3.setPhoneNumber("555-555-5555");
			musician3.setEmail("michael@example.com");
			musician3.setMainInstrument("Vocals");
			musician3.setBandName("The Legends");
			musician3.setStatus("Not available");
			musician3.setMusicalInfluences("Pop, R&B");
			musician3.setAvailability("N/A");
			musician3.setEquipment("Microphone");
			musicianRepository.save(musician3);

			// Repite el proceso para los siguientes músicos...

			Musician musician4 = new Musician();
			musician4.setFirstName("Ella");
			musician4.setLastName("Fitzgerald");
			// Configura las propiedades restantes para musician4
			musicianRepository.save(musician4);

			// Agregar más músicos aquí si lo deseas
			// Creación de bandas
			Band band1 = new Band();
			band1.setName("The Rockers");
			band1.setStartDate("2020-01-15");
			band1.setCountry("United States");
			band1.setCity("New York");
			band1.setBandMembers("John Doe (Guitar), Jane Smith (Bass)");
			band1.setRoles("Lead Guitarist, Bassist");
			band1.setPhoneNumber("555-123-4567");
			band1.setEmail("therockers@example.com");
			band1.setMusicalStyle("Rock");
			band1.setInfluencedBy("Classic Rock");
			band1.setStatus("Active");
			band1.setShowCalendar("2023-08-01:19:00,2023-08-15:20:30");
			band1.setRehearsalSchedule("Monday 5pm, Thursday 7pm");
			bandRepository.save(band1);

			Band band2 = new Band();
			band2.setName("The Melodies");
			band2.setStartDate("2018-05-10");
			band2.setCountry("Canada");
			band2.setCity("Toronto");
			band2.setBandMembers("Ella Fitzgerald (Vocals), Louis Armstrong (Trumpet)");
			band2.setRoles("Lead Singer, Trumpet Player");
			band2.setPhoneNumber("555-987-6543");
			band2.setEmail("themelodies@example.com");
			band2.setMusicalStyle("Jazz");
			band2.setInfluencedBy("Swing, Bebop");
			band2.setStatus("Active");
			band2.setShowCalendar("2023-08-08:21:00,2023-08-22:19:30");
			band2.setRehearsalSchedule("Tuesday 6pm, Friday 8pm");
			bandRepository.save(band2);

			// Creación de productos
			Product product1 = new Product();
			product1.setName("Guitar");
			product1.setPhotoUrl("https://images.unsplash.com/photo-1607560105214-0aaa5f8fcba4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZWxlY3RyaWMlMjBndWl0YXJ8ZW58MHx8MHx8fDA%3D&w=1000&q=80");
			product1.setDescription("A classic electric guitar");
			product1.setPrice(599.99);
			productRepository.save(product1);

			Product product2 = new Product();
			product2.setName("Piano");
			product2.setPhotoUrl("https://upload.wikimedia.org/wikipedia/commons/0/01/Steinway_Vienna_002.JPG");
			product2.setDescription("Grand piano with exceptional sound quality");
			product2.setPrice(1999.99);
			productRepository.save(product2);

			// Agregar más productos aquí si lo deseas

			// Creación de venues
			Venue venue1 = new Venue();
			venue1.setName("Rock Arena");
			venue1.setLocation("New York");
			venue1.setDescription("Large indoor arena for rock concerts");
			venueRepository.save(venue1);

			Venue venue2 = new Venue();
			venue2.setName("Jazz Lounge");
			venue2.setLocation("Toronto");
			venue2.setDescription("Intimate jazz lounge with great acoustics");
			venueRepository.save(venue2);

		};
	}

	@Controller
	public class MusicWebHubController {

		@Autowired
		private MusicianRepository musicianRepository;

		@Autowired
		private BandRepository bandRepository;

		@GetMapping("/")
		public String home(Model model) {
			return "index";
		}
	}
}



