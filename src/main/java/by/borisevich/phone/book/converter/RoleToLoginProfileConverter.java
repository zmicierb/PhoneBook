package by.borisevich.phone.book.converter;

import by.borisevich.phone.book.domain.LoginProfile;
import by.borisevich.phone.book.service.LoginProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual loginProfile objects.
 */
@Component
public class RoleToLoginProfileConverter implements Converter<Object, LoginProfile> {

    static final Logger logger = LoggerFactory.getLogger(RoleToLoginProfileConverter.class);

    @Autowired
    LoginProfileService loginProfileService;

    /**
     * Gets UserProfile by Id
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public LoginProfile convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        LoginProfile profile = loginProfileService.get(id);
        logger.info("Profile : {}", profile);
        return profile;
    }

}
