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
@Table(name = ConstantBD.TABLE_AUTH_USER_TOKEN)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthUserToken {

    @Id
    @NotNull
    @Column(unique = true, nullable = false)
    private String petitionId;

    @NotNull
    @Column(unique = true, nullable = false)
    private String relayId;

    /**
     * Documento del usuario para quien está emitido el token.
     */
    @NotNull
    @Column(nullable = false)
    // Encriptar campo
    private String docNum;

    /**
     * Token emitido para el usuario.
     */
    @NotNull
    @Column(unique = true, nullable = false, length = 4000)
    // Encriptar campo
    private String token;

    /**
     * Timestamp de la fecha de caducidad del token.
     */
    @NotNull
    @Min(1)
    private Long exp;
}