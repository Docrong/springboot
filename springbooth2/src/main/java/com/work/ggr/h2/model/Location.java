package com.work.ggr.h2.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author : gr
 * @date : 2020/3/10 23:48
 */
@Entity
@Table(name = "Location")
@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
public class Location {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", unique = true)
	private String id;

	@Column(name = "type")
	private String type;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longtitude")
	private double longtitude;

	public Location(String type, double latitude, double longtitude) {
		this.type = type;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public Location() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
}
