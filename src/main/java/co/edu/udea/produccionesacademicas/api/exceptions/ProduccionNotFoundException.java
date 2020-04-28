package co.edu.udea.produccionesacademicas.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ProduccionNotFoundException extends HttpStatusCodeException {

    private static final long serialVersionUID = 73263616501570402L;

    public ProduccionNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public ProduccionNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
