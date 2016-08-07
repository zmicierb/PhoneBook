package by.borisevich.phone.book.controller;

import by.borisevich.phone.book.util.MessagesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;

/**
 * Created by dima on 6/5/16.
 */
@Controller
public class CommonController {

    @Autowired
    private MessagesHelper mh;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            HttpServletRequest request, Map<String, Object> model, Locale locale) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }

        if (error != null)
            model.put("error", mh.getMessage("UserDetailsAuthenticationProvider.badCredentials", Locale.getDefault()));

        return "login";
    }
}
