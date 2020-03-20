package trimix.abmc.controller;

import trimix.abmc.dto.Response;
import trimix.abmc.exception.EntityNotFoundException;
import trimix.abmc.model.TipoDocumento;
import trimix.abmc.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/documentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> get(@PathVariable("id") int id) throws EntityNotFoundException, Exception {
        TipoDocumento tipoDocumento = tipoDocumentoService.get(id);
        return ResponseEntity.ok().body(tipoDocumento);
    }

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = tipoDocumentoService.list();
        return ResponseEntity.ok().body(response);
    }

}
