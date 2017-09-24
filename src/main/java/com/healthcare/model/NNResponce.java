package com.healthcare.model;

public class NNResponce {
	private String healthy;
	private String unhealthy;
	
	public NNResponce(String healthy, String unhealthy) {
		this.setHealthy(healthy);
		this.setUnhealthy(unhealthy);
	}

	public String getHealthy() {
		return healthy;
	}

	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}

	public String getUnhealthy() {
		return unhealthy;
	}

	public void setUnhealthy(String unhealthy) {
		this.unhealthy = unhealthy;
	}
	
	
	
}
