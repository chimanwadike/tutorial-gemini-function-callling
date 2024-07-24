package co.spaece.gemini.repository;

import co.spaece.gemini.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query("SELECT c.country, COUNT(c.country) country_count FROM Customer c GROUP BY c.country ORDER BY country_count DESC LIMIT 1")
	String getCountryWithHighestCustomerCount();
	
	Long countByCountry(String country);
}
