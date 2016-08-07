package by.borisevich.phone.book.util.impl;

import by.borisevich.phone.book.util.MessagesHelper;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by dima on 8/7/16.
 */
public class MessagesHelperImpl implements MessagesHelper {

    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, new Object[]{}, locale);
    }

    public String getMessage(String code, String locale) {
        return getMessage(code, new Locale(locale));
    }

    public String getMessage(String code, String defaultMsg, Locale locale) {
        return messageSource.getMessage(code, new Object[]{}, defaultMsg, locale);
    }

    public String getMessage(String code, String defaultMsg, String locale) {
        return getMessage(code, defaultMsg, new Locale(locale));
    }

    public String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

    public String getMessage(String code, Object[] args, String locale) {
        return getMessage(code, args, new Locale(locale));
    }

    public String getMessage(String code, Object[] args, String defaultMsg, Locale locale) {
        return messageSource.getMessage(code, args, defaultMsg, locale);
    }

    public String getMessage(String code, Object[] args, String defaultMsg, String locale) {
        return getMessage(code, args, defaultMsg, new Locale(locale));
    }
}