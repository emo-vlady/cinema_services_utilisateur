package cm.cti.cinema.utilisateur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.cti.cinema.utilisateur.models.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

}
