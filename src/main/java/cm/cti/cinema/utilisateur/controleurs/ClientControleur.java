package cm.cti.cinema.utilisateur.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.cti.cinema.utilisateur.models.Administrateur;
import cm.cti.cinema.utilisateur.models.Client;
import cm.cti.cinema.utilisateur.repositories.ClientRepository;

@RestController
@RequestMapping(value = "api/client")
public class ClientControleur {
	
	@Autowired
	private ClientRepository clientRepository;
	@GetMapping
	public List<Client> findAllClient(){
		return clientRepository.findAll();
	}
	@GetMapping(value = "/all")
	public List<Client> findAllclient2(){
		return clientRepository.findAll();
	}
	@PostMapping
	public Client create(
			@RequestBody Client client
			) {
		client.setId(null);
		if(client.getPersonne().getNom().length() <4) return null;
		
		clientRepository.save(client);
		return client;
	}
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		Client client = clientRepository.findById(id).get();
		clientRepository.delete(client);
		return "Ok";
	}
	@PutMapping
	public Client update(
			@RequestBody Client client) {
		
		if(client.getPersonne().getNom().length() <4) return null;
		Client client2 = clientRepository.findById(client.getId()).get();
		client2.getPersonne().setNom(client.getPersonne().getNom());
		client2.getPersonne().setPrenom(client.getPersonne().getPrenom());
		client2.getPersonne().setEmail(client.getPersonne().getEmail());
		client2.getPersonne().setTel(client.getPersonne().getTel());
		
		clientRepository.save(client2);
		return client2;
	}
 @GetMapping("/valid{isValid}")
	public List<Client> findByIsValid(
	 @PathVariable("isValid") boolean isValid){
	return clientRepository.findByIsValid(isValid);
 }
	
}
