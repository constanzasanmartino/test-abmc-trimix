package trimix.abmc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trimix.abmc.exception.EntityNotFoundException;
import trimix.abmc.model.Persona;

@Repository
public class PersonaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int save(Persona persona) throws Exception {
        sessionFactory.getCurrentSession().save(persona);
        return persona.getPerId();
    }

    public Persona get(int id) throws EntityNotFoundException, Exception {
        Persona p = sessionFactory.getCurrentSession().get(Persona.class, id);
        if (p == null) {
            throw new EntityNotFoundException("id: {" + String.valueOf(id) + "} inexistente");
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    public List<Persona> list() throws Exception {
        return sessionFactory.getCurrentSession().createQuery("from Persona order by 1 desc").list();
    }

    public void update(Persona persona) throws Exception {
        sessionFactory.getCurrentSession().saveOrUpdate(persona);
        sessionFactory.getCurrentSession().flush();
    }

    public void delete(int id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Persona persona = session.byId(Persona.class).load(id);
        session.delete(persona);
    }


}
