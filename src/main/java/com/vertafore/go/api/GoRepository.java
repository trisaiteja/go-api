package com.vertafore.go.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoRepository extends CrudRepository<Go, Long> {

}