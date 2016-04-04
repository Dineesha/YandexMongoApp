package tester;

import loginmongo.DomXmlParser;
import loginmongo.LanguageTranslation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

/**
 * Created by hsenid on 4/4/16.
 */
public class LanguageTranslationTest {
    LanguageTranslation tr = new LanguageTranslation();
    boolean reply =false;
   // DomXmlParser translation = new DomXmlParser();

    @DataProvider(name = "text")
    public Object[][] text() {

        return new Object[][]{
                {"en", "fr", "tree","arbre"},
        };
    }

    @Test(dataProvider = "text")
    public void testTranslation(String fromLang, String toLang, String toTranslateText, String exp) {

        DomXmlParser translation = new DomXmlParser();
        try {
            String trText = translation.readResponse(fromLang, toLang, toTranslateText);
            Assert.assertEquals(trText, exp, "Correct translation");
            System.out.println(toTranslateText);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void  conflictFromLanguage(){
        DomXmlParser translation = new DomXmlParser();

        try{
            reply = Boolean.parseBoolean(translation.readResponse("fr", "en", "tree"));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(reply,false,"Language translated conflict");
    }

    @Test
    public void  conflictToLanguage(){
        DomXmlParser translation = new DomXmlParser();

        try{
            reply = Boolean.parseBoolean(translation.readResponse("en", "fr", "tree"));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(reply,false,"conflict ToLanguage");
    }

    @Test
    public void  nullTranslateText(){
        DomXmlParser translation = new DomXmlParser();

        try{
            reply = Boolean.parseBoolean(translation.readResponse("en", "fr", ""));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(reply,false,"null input text");
    }


}
