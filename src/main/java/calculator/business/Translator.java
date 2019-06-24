package calculator.business;

import calculator.entities.Language;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public interface Translator {

    public String translate(Language from, Language to, String text) throws IOException;
}
