package org.honorcloud.code.controller.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Component
public class CustomizeExceptionHandler extends AbstractErrorController implements ErrorController{
	
	public CustomizeExceptionHandler(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        //获取statusCode:401,404,500
        model.addAttribute("msg", super.getErrorAttributes(request, true));
        return "base/error";
    }
    @Override
    public String getErrorPath() {
        return "base/error";
    }
}
