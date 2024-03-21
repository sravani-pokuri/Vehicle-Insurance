package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.entity.SignupEntity;
import com.example.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository registrationrepository;
	public ResponseEntity<String> signUp(SignupEntity entity) {
		if (entity.getPassword().isEmpty() || entity.getMail().isEmpty()
				|| String.valueOf(entity.getMobileNumber()).isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("All fields are mandatory");

		}
		SignupEntity existingUserByEmail = registrationrepository.findByMail(entity.getMail());
        SignupEntity existingUserByMobile = registrationrepository.findBymobileNumber(entity.getMobileNumber());

        if (existingUserByEmail != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists");
        }

        if (existingUserByMobile != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Mobile number already exists");
        }
        registrationrepository.save(entity);
        return ResponseEntity.status(HttpStatus.OK).body("Signup successful");
    }
	
	public ResponseEntity<String> login(String email, String password) {
	    if (email.isEmpty() || password.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("All fields are mandatory");
	    }
	    SignupEntity existingUser = registrationrepository.findByMail(email);
	    if (existingUser == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("email does not exist");
	    }
	    if (!existingUser.getPassword().equals(password)) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Incorrect password");
	    }
	    return ResponseEntity.status(HttpStatus.OK).body("Login successful");
	}
}