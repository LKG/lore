package im.heart.common.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String error(){
        return "/errors/404";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
