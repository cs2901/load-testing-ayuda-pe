package calculator.business;

import calculator.entities.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TranslatorImpl implements Translator {

    private static Map<String,String> cache = new HashMap<String,String>();
    @Override
    public String translate(Language from, Language to, String text) throws IOException {
        if (cache.containsKey(text))
        {
            return cache.get(text);
        }

        String urlStr = "https://script.google.com/macros/s/AKfycbwoewR66GN4nBRmwKUzAz7dlyOZ2MIN9T5pAsUk56puPV7P0xJa/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + to.getId().toLowerCase() +
                "&source=" + from.getId().toLowerCase();
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String translation = response.toString();
        cache.put(text,translation);

        return translation;

    }
}
