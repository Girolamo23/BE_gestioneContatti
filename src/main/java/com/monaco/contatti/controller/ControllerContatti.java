package com.monaco.contatti.controller;

import com.monaco.contatti.exception.ResourceNotFoundException;
import com.monaco.contatti.model.Contatti;
import com.monaco.contatti.repository.ContattiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Girolamo Monacò
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/contatti")
public class ControllerContatti {

    @Autowired
    private ContattiRepository contattiRepository;


    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Contatti> getAll() {
        return contattiRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity <Contatti> getOneByID(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Contatti c = contattiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contatto non trovato per l'id =  " + id));
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping(value = "/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Map <String, Boolean> delete(@PathVariable("id") Long id) throws ResourceNotFoundException{
        Contatti c = contattiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contatto non trovato per l'id =  " + id));
        contattiRepository.delete(c);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Cancellazione", Boolean.TRUE);
        return response;
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Contatti savePost(@RequestBody Contatti contatti) {
        return contattiRepository.save(contatti);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity <Contatti>  savePut(@PathVariable(value = "id") Long id,
                                              @RequestBody Contatti contattiRequest) throws ResourceNotFoundException {
        Contatti e = contattiRepository.findById(id) .orElseThrow(() ->
                new ResourceNotFoundException("Contatto non trovato per l'id = " + id));
        e.setEmail(contattiRequest.getEmail());
        e.setIndirizzo(contattiRequest.getIndirizzo());
        e.setNome(contattiRequest.getNome());
        e.setTelefono(contattiRequest.getTelefono());
        e.setLatitudine(contattiRequest.getLatitudine());
        e.setLongitudine(contattiRequest.getLongitudine());
        e.setNote(contattiRequest.getNote());
        final Contatti contattoMod = contattiRepository.save(e);
        return ResponseEntity.ok(contattoMod);
    }

}
