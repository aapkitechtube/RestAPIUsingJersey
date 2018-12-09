package com.aapkitechtube.rest.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aapkitechtube.rest.model.Registration;

@Component
public class RegistrationDaoImpl implements RegistrationDao {

	private static Map<String, Registration> registrationStore = new HashMap<String, Registration>();

	@Override
	public boolean addRegistration(Registration registration) {
		registrationStore.put(registration.getEmail(), registration);
		return true;
	}

	@Override
	public Registration viewRegistration(String registrationId) {
		System.out.print(registrationStore);
		return registrationStore.get(registrationId);
	}

}
