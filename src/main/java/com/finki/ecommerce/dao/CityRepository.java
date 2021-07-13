package com.finki.ecommerce.dao;

import com.finki.ecommerce.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface CityRepository extends JpaRepository <City, Integer>{

    //localhost:808/api/cities/search/findByCountryCode?code=MK
    //Retrieve cities for a given country code
    List<City> findByCountryCode(@Param("code") String code);

}
