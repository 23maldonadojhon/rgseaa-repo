package es.aesan.rgseaa.model.entity;

import es.aesan.rgseaa.model.util.ConstantBD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = ConstantBD.TABLE_AUTH_USER_REQUEST)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserRequest {

    /**
     * UUID de nuestra petición interna.
     */
    @Id
    @NotNull
    @Column(unique = true, nullable = false)
    private String petitionId;

    /**
     * Identificador de la petición a clave.
     */
    @NotNull
    @Column(unique = true, nullable = false)
    private String relayId;

    /**
     * JWT temporal emitido para permitir la recuperación de los datos de
     * autenticación generados por la respuesta de clave.
     */
    @NotNull
    @Column(unique = true, nullable = false)
    // Encriptar campo
    private String token;

    /**
     * URL de retorno al de completar el proceso de login o logout.
     * El resultado del proceso se fija como propiedades de la URL.
     */
    @Column(name = "PROCESS_RETURN_URL", nullable = false)
    private String processReturnUrl;

    /**
     * Fecha de caducidad del token expresada en tiempo UNIX.
     * Permite anular el token cambiando la caducidad a (now - 1)
     */
    @NotNull
    @Min(1)
    private Long exp;
}
