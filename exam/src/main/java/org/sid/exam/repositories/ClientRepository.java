package org.sid.exam.repositories;

import org.sid.exam.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Client Repository
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}