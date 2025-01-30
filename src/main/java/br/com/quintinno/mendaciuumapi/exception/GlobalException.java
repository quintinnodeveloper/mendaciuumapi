package br.com.quintinno.mendaciuumapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import br.com.quintinno.mendaciuumapi.dto.ErroExceptionDTO;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErroExceptionDTO> maxUploadSizeExceededException(MaxUploadSizeExceededException maxUploadSizeExceededException) {
        ErroExceptionDTO erroExceptionDTO = new ErroExceptionDTO();
            erroExceptionDTO.setErro("Arquivo muito grande (limite 10MB)");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroExceptionDTO);
    }
    
}
