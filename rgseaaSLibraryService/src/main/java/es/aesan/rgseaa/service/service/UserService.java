package es.aesan.rgseaa.service.service;


import es.aesan.rgseaa.model.criteria.UserCriteria;
import es.aesan.rgseaa.model.entity.User;
import es.aesan.rgseaa.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class UserService
        extends AbstractService<User,Long,UserRepository,UserCriteria> {


    UserService(UserRepository repository){
        super(repository);
    }

    public Optional<User> getByNif(String nif){
        logger.info("==== FIND User BY NIF ====");
        logger.info("nif :"+nif);

        return repository.findByNif(nif);
    }

}
