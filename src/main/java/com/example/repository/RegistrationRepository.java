package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.SignupEntity;

@Repository
public interface RegistrationRepository extends JpaRepository<SignupEntity, Long> {
	SignupEntity findByMail(String mail);
	SignupEntity findBymobileNumber(long mobileNumber);
	
	
}
