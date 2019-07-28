package net.nkt.onlineportalpg.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefultExceptionHandler {
	
	
	//To Handle the Exception Globally 
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The Page is not constructed!");
		mv.addObject("errorDescription", "The page you are looking for is not available now!");
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	
	//To Handle the Excption at Page Level
	@ExceptionHandler(PGNotFoundException.class)
	public ModelAndView handlerPGNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","PG is not available!");
		mv.addObject("errorDescription", "The PG  you are looking for is not available right now!");
		mv.addObject("title","PG Unavailable");
		
		return mv;
	}
	
	//To Handle the Generalized Exception
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact Your Administrator!");
		
		// Only for debugging your Application or getting Entire StackTrace
 		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title","Error");
		
		return mv;
	}
	
}
