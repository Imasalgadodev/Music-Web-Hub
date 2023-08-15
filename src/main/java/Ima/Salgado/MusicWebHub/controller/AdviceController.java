package Ima.Salgado.MusicWebHub.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceController {

  @ExceptionHandler(ResponseStatusException.class)
    public ModelAndView handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(status);
        modelAndView.setViewName("/error");
        return modelAndView;
    }
}
