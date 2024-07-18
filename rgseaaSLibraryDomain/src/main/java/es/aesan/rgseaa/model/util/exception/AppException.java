package es.aesan.rgseaa.model.util.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Excepción personalizada para la aplicación.
 * <br/>
 * Toda excepción debería llevar un código único para su identificación.
 * <br/><br/>
 * Formato estándar del código: TMM_DDDD
 * <br/>
 * T - Tulsa
 * MM - Identificador numérico del módulo (00 a 99)
 * DDDD - Número secuencial del error
 */
@Getter
@Setter
public class AppException extends RuntimeException {

    public static final String CODE = "TRS00_000";
    public static final String ERROR = "Unknown application error";

    private String code;
    private String error;
    private Long timestamp;

    public AppException() {
        this(CODE, ERROR, null, null);
    }

    public AppException(String code, String error, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.error = error;
        this.timestamp = System.currentTimeMillis();
    }

}
