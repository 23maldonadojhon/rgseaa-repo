package es.aesan.rgseaa.model.dto;

import es.aesan.rgseaa.model.commom.constants.EntityState;
import es.aesan.rgseaa.model.commom.dto.LongIdModel;
import es.aesan.rgseaa.model.commom.validation.constraints.NIF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto implements LongIdModel {

    private Long id;
    private Integer state = EntityState.ON.getValue();


    @NotBlank(message = "no puede estar en blanco")
    @NotNull(message = "Debes especificar el nombre")
    @NIF(message = "errorrrrrrrrrr")
    private String nif;

    @NotBlank(message = "no puede estar en blanco")
    @NotNull(message = "Debes especificar el nombre")
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank(message = "no puede estar en blanco")
    @NotNull(message = "Debes especificar el primer apellido")
    @Size(min = 1, max = 100, message = "El primer apellido debe medir entre 1 y 100")
    private String firstSurname;

    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "no puede estar en blanco")
    @Size(max = 100)
    private String secondSurname;

    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "no puede estar en blanco")
    @Email(message = "formato incorrecto email")
    private String email;

    @NotNull(message = "no puede ser nulo")
    @NotBlank(message = "no puede estar en blanco")
    private String phone;

    @NotNull(message = "no puede ser nulo")
    private ProfileDto profile;

    @NotNull(message = "no puede ser nulo")
    private EntitieDto entity;
    public String getFullName() {
        String fullName = getName() + " " + getFirstSurname() + " " + getSecondSurname();
        return fullName;
    }
}

