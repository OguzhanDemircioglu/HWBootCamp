package com.etiya.RentACarSpring.RentACar.entities.forCar;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})
@Table(name="brands")
public class Brand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="brand_id")
	private int brandId;
	
	@Column(name="brand_name")
	private String brandName;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Car> cars;
}
