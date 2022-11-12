package eni.app.ms_biling.repositories;

import eni.app.ms_biling.entities.Biling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BilingRepository extends JpaRepository<Biling,Long> {}