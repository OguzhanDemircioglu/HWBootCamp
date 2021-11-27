package com.etiya.RentACarSpring.RentACar.entities.forCar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name ="id")
	private int id;
	
	@Column(name="model_year")
	private int modelYear;
	
	@Column(name="daily_price")
	private int dailyPrice;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "findex_score")
	private int findexScore;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;

	
	
}