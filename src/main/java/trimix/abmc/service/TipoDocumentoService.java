package trimix.abmc.service;

import trimix.abmc.dao.TipoDocumentoDao;
import trimix.abmc.dto.Response;
import trimix.abmc.exception.EntityNotFoundException;
import trimix.abmc.model.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoDao tipoDocumentoDao;

    public TipoDocumento get(int id) throws EntityNotFoundException, Exception {
        return tipoDocumentoDao.get(id);
    }

    public Response list() throws Exception {
        Response response = new Response();
        List<TipoDocumento> tipoDocumentos = tipoDocumentoDao.list();
        response.setData(tipoDocumentos);
        return response;
    }


}














