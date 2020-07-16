package tms.lesson39.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.lesson39.domain.Address;


public interface AddressController extends JpaRepository<Address,Long> {

}
