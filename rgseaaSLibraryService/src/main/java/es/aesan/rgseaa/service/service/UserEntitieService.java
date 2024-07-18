package es.aesan.rgseaa.service.service;

import es.aesan.rgseaa.model.criteria.UserEntitieCriteria;
import es.aesan.rgseaa.model.entity.Entitie;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.model.entity.UserEntitie;
import es.aesan.rgseaa.service.repository.UserEntitieRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserEntitieService
        extends AbstractService<UserEntitie,Long,UserEntitieRepository,UserEntitieCriteria> {

    UserEntitieService(UserEntitieRepository repository){
        super(repository);
    }

    public Set<UserEntitie> getByIdUser(final Long idUser){
        return repository.getByUserId(idUser);
    }

    public UserEntitie getUserEntitie(User userSaved, Entitie entitie){

        UserEntitie userEntitie = new UserEntitie();
        userEntitie.setUser(userSaved);
        userEntitie.setEntity(entitie);
        userEntitie.setCode("CODE");

        return userEntitie;
    }
}
