package org.sid.exam.repositories;

import org.sid.exam.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Credit Repository
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {}