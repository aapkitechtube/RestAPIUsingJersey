package com.aapkitechtube.rest.dao;

import com.aapkitechtube.rest.model.Registration;

public interface RegistrationDao {
	
	public boolean addRegistration (Registration registration);
	
	public Registration viewRegistration (String registrationId);
}
