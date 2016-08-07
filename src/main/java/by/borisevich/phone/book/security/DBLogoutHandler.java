package by.borisevich.phone.book.security;

import by.borisevich.phone.book.controller.SessionAttribute;
import by.borisevich.phone.book.domain.admin.Session;
import by.borisevich.phone.book.service.SessionManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dima on 6/5/16.
 */
@Component
public class DBLogoutHandler implements LogoutHandler {

    @Autowired
    @Qualifier("sessionInDbService")
    private SessionManagerService sessionManagerService;

    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        WebUtils.setSessionAttribute(request, SessionAttribute.DEBUG_LEVEL, request.getIntHeader("debug"));
        sessionManagerService.kill(new Session(authentication));

        WebUtils.setSessionAttribute(request, SessionAttribute.PROFILE, null);
        WebUtils.setSessionAttribute(request, SessionAttribute.DEBUG_LEVEL, null);
    }

//    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
////        Session session = (Session) WebUtils.getSessionAttribute(request, SessionAttribute.SESSION_DATA);
////        WebUtils.setSessionAttribute(request, SessionAttribute.DEBUG_LEVEL, request.getIntHeader("debug"));
//
////        sessionManagerService.logout();
//
//        Session session = (Session) WebUtils.getSessionAttribute(request, SessionAttribute.SESSION_DATA);
//
//        sessionManagerService.kill(session);
//
//        WebUtils.setSessionAttribute(request, SessionAttribute.SESSION_DATA, null);
//        WebUtils.setSessionAttribute(request, SessionAttribute.PROFILE, null);
////        WebUtils.setSessionAttribute(request, SessionAttribute.DEBUG_LEVEL, null);
//    }
}
