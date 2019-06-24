package calculator.test;

import calculator.business.Translator;
import calculator.business.TranslatorImpl;
import calculator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslatorImplTest {
    Translator translator;
    Language from;
    Language to;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = new Language("EN", "English");
        to = new Language("ES", "Spanish");
    }

    @Test(invocationCount = 100, threadPoolSize = 1)
    public void testTranslate() throws Exception {
        String response = translator.translate(from, to, "Hello");
        Assert.assertEquals(response, "Hola");
    }

}