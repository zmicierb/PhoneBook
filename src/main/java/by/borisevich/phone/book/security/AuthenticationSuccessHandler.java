package by.borisevich.phone.book.security;

import by.borisevich.phone.book.controller.SessionAttribute;
import by.borisevich.phone.book.domain.admin.Session;
import by.borisevich.phone.book.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 6/5/16.
 */

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    private String DEBUG_LEVEL = "4";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        WebUtils.setSessionAttribute(request, SessionAttribute.PROFILE, loginService.get(authentication.getName()));
        WebUtils.setSessionAttribute(request, SessionAttribute.USER_MENU, loginService.menu());
        WebUtils.setSessionAttribute(request, SessionAttribute.DEBUG_LEVEL, Integer.parseInt(DEBUG_LEVEL));

        super.onAuthenticationSuccess(request, response, authentication);
    }
}

//@Component
//public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
////    @Autowired
////    private SessionManagerService sessionManagerService;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        DBAuthenticationToken authenticationToken = (DBAuthenticationToken) authentication;
//        Session sessionData = authenticationToken.getSessionContext();
//
//        WebUtils.setSessionAttribute(request, SessionAttribute.SESSION_DATA, sessionData);
//        WebUtils.setSessionAttribute(request, SessionAttribute.PROFILE, sessionData.getLogin());
////        WebUtils.setSessionAttribute(request, SessionAttribute.USER_MENU, sessionData.getMenu());
//
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
