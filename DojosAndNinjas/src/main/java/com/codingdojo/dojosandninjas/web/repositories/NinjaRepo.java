package com.codingdojo.dojosandninjas.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.web.models.*;


@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}