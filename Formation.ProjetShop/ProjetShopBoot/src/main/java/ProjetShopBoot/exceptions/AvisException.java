package ProjetShopBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "not found")
public class AvisException extends RuntimeException {
	public AvisException() {}
	
	public AvisException(String message) {
		super(message);
	}

}
