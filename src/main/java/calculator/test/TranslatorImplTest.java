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

    Language from2;
    Language to2;
    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = new Language("EN", "English");
        to = new Language("ES", "Spanish");
        from2 = new Language("ES", "Spanish");
        to2 = new Language("DE", "German");
    }

    @Test(invocationCount = 100, threadPoolSize = 3)
    public void testTranslate() throws Exception {
        String response = translator.translate(from, to, "Hello");
        Assert.assertEquals(response, "Hola");
    }

    @Test(invocationCount = 100, threadPoolSize = 3)
    public void testTranslate2() throws Exception {
        String response = translator.translate(from2, to2, "Buenos días");
        Assert.assertEquals(response, "Guten Morgen");
    }
}