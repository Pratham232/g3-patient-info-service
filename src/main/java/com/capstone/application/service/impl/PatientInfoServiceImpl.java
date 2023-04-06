package com.capstone.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.application.exception.PatientInfoException;
import com.capstone.application.model.Patient;
import com.capstone.application.repository.PatientInfoRepository;
import com.capstone.application.service.PatientInfoService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PatientInfoServiceImpl implements PatientInfoService
{
	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(PatientInfoServiceImpl.class);

	
	private PatientInfoRepository patientInfoRepository;
	
	@Autowired
	public PatientInfoServiceImpl(PatientInfoRepository patientInfoRepository) {
		super();
		this.patientInfoRepository = patientInfoRepository;
	}

	@Override
	public List<Patient> findAll() throws PatientInfoException {
		
		List<Patient>result=patientInfoRepository.findAll();
		if(result.size()==0) {
			throw new PatientInfoException("No Patients in the Database");
		}
		
		return result;
		
	}

	@Override
	public Optional<Patient> findById(Integer patientId) throws PatientInfoException {
		
		Optional<Patient> result=patientInfoRepository.findById(patientId);
		if(result.isEmpty()) {
			throw new PatientInfoException("No Patient available with patientID: "+patientId);
		}
		
		return result;
		
		
	}

	@Override
	public Patient update(Patient patient) {
		
		Patient updateResponse = patientInfoRepository.save(patient);
        return updateResponse;
		
	}
	
	//Sangeeta
		@Override
		public long countPatient() {
			return patientInfoRepository.count();
		}
	

}