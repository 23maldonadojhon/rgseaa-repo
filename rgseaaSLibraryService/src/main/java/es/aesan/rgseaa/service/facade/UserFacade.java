package es.aesan.rgseaa.service.facade;

import es.aesan.rgseaa.model.converter.ProfileConverter;
import es.aesan.rgseaa.model.converter.UserConverter;
import es.aesan.rgseaa.model.criteria.UserCriteria;
import es.aesan.rgseaa.model.dto.ProfileDto;
import es.aesan.rgseaa.model.dto.UserDto;
import es.aesan.rgseaa.model.entity.*;
import es.aesan.rgseaa.service.service.*;
import es.aesan.rgseaa.service.util.Accion;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.*;
import java.util.*;


@Component
@RequiredArgsConstructor
public class UserFacade extends AbstractFacade<
        UserDto,
        UserCriteria
        > {

    @Autowired
    final private UserService userService;


    @Autowired
    private final UserEntitieService userEntitieService;

    @Autowired
    private final ProfileConverter profileConverter;

    @Autowired
    final private UserConverter userConverter;

    @Autowired
    private PlatformTransactionManager transactionManager;



    private static final Logger logger = LoggerFactory.getLogger(UserFacade.class);


    @Override
    @Transactional
    public void add(UserDto dto) {
        logger.info("==== FACADE-> ADD USER ====");
        logger.info("user :"+dto);

        valid(dto,Accion.ADD);

        User user=userConverter.dtoToEntity(dto);
        userService.add(user);
    }


    @Override
    @Transactional
    public void update(final UserDto userDto){

        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {

            logger.info("====  FACADE->  UPDATE USER ====");
            logger.info("user :"+userDto);

            valid(userDto,Accion.UPDATE);

            User user = userConverter.dtoToEntity(userDto);

            userService.update(user);

            transactionManager.commit(status);

        } catch (Exception e) {
            transactionManager.rollback(status);
            logger.error("ERROR USER:", e);
        }

    }



    @Override
    public UserDto get(final Long id){
        logger.info("==== FACADE-> FIND BY USER ====");
        logger.info("id :"+id);

        User user = userService.get(id);

        user.setEntitie(userEntitieService.getByIdUser(id));

        UserDto userDto = userConverter.entityToDto(user);

        return userDto;
    }

    @Override
    public List<UserDto> list(UserCriteria criteria) {

        Collection<User> list=userService.list(criteria);
        List<UserDto> userDtos=userConverter.mapEntityToDtoList(new ArrayList<>(list));
        return userDtos;
    }



    @Override
    public Page<UserDto> page(UserCriteria criteria){
        logger.info("====  FACADE->  USER CRITERIA====");
        logger.info("criteria :"+criteria);

        Page<User> page = userService.page(criteria);

        Page<UserDto> dtoPage = userConverter.mapEntityToDtoPage(page);

        return dtoPage;
    }


    public UserDto userByNif(final String id){
        logger.info("==== FACADE-> FIND BY USER ====");
        logger.info("id :"+id);

        Optional<User> userOptional = userService.getByNif(id);
        UserDto userDto;

        if(userOptional.isPresent())
            userDto  = userConverter.entityToDto(userOptional.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userDto;
    }


    private void valid(final UserDto userDto, final Accion accion){
        logger.info("==== FACADE-> PROCCESS VALID USER ====");
        logger.info("accion :"+accion.name());
        logger.info("UserDto :"+userDto.toString());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<UserDto> violation : violations) {
                logger.error(violation.getMessage());
            }
            throw new ConstraintViolationException(violations);
        }


        if (accion.equals(Accion.ADD)) {

            Optional<User> user = userService.getByNif(userDto.getNif());
            user.ifPresent((value)->{throw new ResponseStatusException(HttpStatus.FOUND);});

        } else if (accion.equals(Accion.UPDATE)) {

            if (ObjectUtils.isEmpty(userDto.getId()))
                throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

    }




    public void deleteUser(Long id) {
        logger.info("==== FACADE-> DELETE BY ID ====");
        logger.info("id :"+id);

    }


}
