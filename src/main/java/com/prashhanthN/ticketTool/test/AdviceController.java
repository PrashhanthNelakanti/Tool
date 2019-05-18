package com.prashhanthN.ticketTool.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class AdviceController {

/*@ExceptionHandler(NoHandlerFoundException.class)
public String handle(Exception ex) {
    return "redirect:/404";
}

@RequestMapping(value = {"/404"}, method = RequestMethod.GET)
public String NotFoudPage() {
    return "404";

}*/

@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String handleError(HttpServletRequest request, Exception e)   {
    return new String("error");
}

@ExceptionHandler(NoHandlerFoundException.class)
public String handleError404(HttpServletRequest request, Exception e)   {
    return new String("404");
}

}