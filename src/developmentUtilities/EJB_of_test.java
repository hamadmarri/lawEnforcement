package developmentUtilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.entries.Image;
import entities.entries.Person;
import entities.entries.PhysicalCharacteristic;


@Stateless
public class EJB_of_test {

	@PersistenceContext(unitName = "lawEnforcementPersistenceUnit")
	private EntityManager em;



	public void test() {

		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(Calendar.YEAR, 1984);
		date1.set(Calendar.MONTH, 7);
		date1.set(Calendar.DAY_OF_MONTH, 23);

		date2.set(Calendar.YEAR, 1991);
		date2.set(Calendar.MONTH, 7);
		date2.set(Calendar.DAY_OF_MONTH, 19);

		Person p1 = new Person("Hamad Almarri", date1, "Al Hasa", "Male", "Saudi", "", "AA");
		Person p2 = new Person("Mohammad Almarri", date2, "Al Khobar", "Male", "Saudi", "", "CO");
		List<Image> mugShot = new ArrayList<Image>();
		List<Image> fingerprintsImages = new ArrayList<Image>();
		Image photograph = new Image("Brothers", "/upload/images/bro.jpg", null, null);

		mugShot.add(new Image("front shot", "/upload/images/mugshots/hamad.jpg", p1, null));
		mugShot.add(new Image("left side shot", "/upload/images/mugshots/hamad.jpg", p1, null));
		mugShot.add(new Image("right side shot", "/upload/images/mugshots/hamad.jpg", p1, null));

		fingerprintsImages.add(new Image("small fingerprint", "/upload/images/fingerprints/4/small.jpg", null, p1));
		fingerprintsImages.add(new Image("large fingerprint", "/upload/images/fingerprints/4/large.jpg", null, p1));

		photograph.addPersonOfPhotos(p1);
		photograph.addPersonOfPhotos(p2);

		em.persist(p1);
		em.persist(p2);
		for (Image i : mugShot)
			em.persist(i);

		for (Image i : fingerprintsImages)
			em.persist(i);

		em.persist(photograph);

	}

}
