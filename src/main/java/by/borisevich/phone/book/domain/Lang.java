package by.borisevich.phone.book.domain;

/**
 * Created by dima on 6/5/16.
 */
public enum Lang {
    RU(1),
    BY(2);
//    TRANSLITERATION(3);

    public static Lang defaultLang = RU;

    private final int code;

    private Lang(int code) {
        this.code = code;
    }

    public static Lang forCode(Integer code) {
        if (null == code)
            return null;
        for (Lang lang : Lang.values())
            if (lang.getCode() == code)
                return lang;
        return null;

    }

    public int getCode() {
        return this.code;
    }
}

