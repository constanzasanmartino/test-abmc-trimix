package trimix.abmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import trimix.abmc.dto.PersonaDto;
import trimix.abmc.dto.Response;
import trimix.abmc.exception.EntityNotFoundException;
import trimix.abmc.service.PersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonaDto personaDTO) throws Exception {
        Response response = personaService.save(personaDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") int id) throws EntityNotFoundException, Exception {
        Response response = personaService.get(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = personaService.list();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody PersonaDto personaDTO) throws Exception {
		Response response = personaService.update(personaDTO);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws Exception {
		Response response = personaService.delete(id);
		return ResponseEntity.ok().body(response);
    }

}
