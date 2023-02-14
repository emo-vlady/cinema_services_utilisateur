package cm.cti.cinema.utilisateur.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.cti.cinema.utilisateur.models.Client;
import cm.cti.cinema.utilisateur.models.Personne;
import cm.cti.cinema.utilisateur.repositories.PersonneRepository;

@RestController
@RequestMapping(value = "api/personne")
public class PersonneControleur {
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping("nom/{nom}")
	public List<Personne> findByNom(
	 @PathVariable("nom") String nom){
		return personneRepository.findByNom(nom);
	}
	@GetMapping("pernom/{prenom}")
	public List<Personne> findByPrenom(
	 @PathVariable("prenom") String prenom){
		return personneRepository.findByNom(prenom);
	}
	@GetMapping("email/{email}")
	public List<Personne> findByEmail(
	 @PathVariable("email") String email){
		return personneRepository.findByNom(email);
	}
	
}	
