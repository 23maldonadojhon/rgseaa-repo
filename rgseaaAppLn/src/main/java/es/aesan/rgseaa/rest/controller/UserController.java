package es.aesan.rgseaa.rest.controller;


import es.aesan.rgseaa.model.criteria.UserCriteria;
import es.aesan.rgseaa.model.dto.UserDto;
import es.aesan.rgseaa.service.facade.UserFacade;
import es.aesan.rgseaa.util.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Url.API+Url.USERS)
public class UserController extends AbstractController<
        UserDto,
        UserFacade,
        UserCriteria
        > {

    UserController(UserFacade facade) {
        super(facade);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(final @PathVariable Long id) {
        logger.info("==== CONTROLLER -> DELETE USER ====");

        facade.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping(Url.NIF+"/{nif}")
    public ResponseEntity<UserDto> getUserByNif(final @PathVariable String nif) {
        logger.info("==== CONTROLLER -> GET NIF USER ====");
        UserDto userDto;

        userDto = facade.userByNif(nif);

        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

}
