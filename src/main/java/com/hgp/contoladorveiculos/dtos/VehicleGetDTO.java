package com.hgp.contoladorveiculos.dtos;

import java.util.Calendar;
import java.util.Date;

import com.hgp.contoladorveiculos.entities.Vehicle;

public class VehicleGetDTO extends VehicleDTO{
	private static final long serialVersionUID = 1L;
	
	private Calendar calendar = Calendar.getInstance();
	
	private String rotationDay;
	private Integer intRotationDay;
	private Boolean activeRotation;
	
	private final String MONDAY = "Segunda-feira";
	private final String TUESDAY = "Terça-feira";
	private final String WEDNESDAY = "Quarta-feira";
	private final String THURSDAY = "Quinta-feira";
	private final String FRIDAY = "Sexta-feira";
	
	public VehicleGetDTO(Vehicle vehicle) {
		super(vehicle);
		setVehicleRotationDay(vehicle.getYear().charAt(3));
		setVehicleActiveRotation();
	}

	private void setVehicleRotationDay(char yearLastNumber) {
		if(yearLastNumber == '0' || yearLastNumber == '1') {
			rotationDay = MONDAY;
			intRotationDay = Calendar.MONDAY;
		}
		else if(yearLastNumber == '2' || yearLastNumber == '3') {
			rotationDay = TUESDAY;
			intRotationDay = Calendar.TUESDAY;
		}
		else if(yearLastNumber == '4' || yearLastNumber == '5') {
			rotationDay = WEDNESDAY;
			intRotationDay = Calendar.WEDNESDAY;
		}
		else if(yearLastNumber == '6' || yearLastNumber == '7') {
			rotationDay = THURSDAY;
			intRotationDay = Calendar.THURSDAY;
		}
		else if(yearLastNumber == '8' || yearLastNumber == '9') {
			rotationDay = FRIDAY;
			intRotationDay = Calendar.FRIDAY;
		}
	}
	
	private void setVehicleActiveRotation() {
		calendar.setTime(new Date());
		int actualDay = calendar.get(Calendar.DAY_OF_WEEK);
		
		activeRotation = actualDay == intRotationDay;
	}

	public String getRotationDay() {
		return rotationDay;
	}

	public void setRotationDay(String rotationDay) {
		this.rotationDay = rotationDay;
	}

	public Boolean getActiveRotation() {
		return activeRotation;
	}

	public void setActiveRotation(Boolean activeRotation) {
		this.activeRotation = activeRotation;
	}
}
