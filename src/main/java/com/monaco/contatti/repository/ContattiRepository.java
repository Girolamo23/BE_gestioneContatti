package com.monaco.contatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.monaco.contatti.model.Contatti;

/**
 * @Author Girolamo Monacò
 */

@Repository
public interface ContattiRepository extends JpaRepository<Contatti, Long>{

}
