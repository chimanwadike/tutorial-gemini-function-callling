package co.spaece.gemini.repository;

import co.spaece.gemini.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	Long countByCountry(String country);
	
	@Query("SELECT c.country, COUNT(c.country) country_count FROM Customer c GROUP BY c.country ORDER BY country_count DESC LIMIT 1")
	String getCountryWithHighestCustomerCount();
	
	@Query("SELECT c.name, sum (c.outstanding_amount) customer_debt FROM Customer c GROUP BY c.id ORDER BY customer_debt DESC LIMIT 1")
	String getTop1HighestDebtCustomer();
}
