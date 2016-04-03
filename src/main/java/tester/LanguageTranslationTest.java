package tester;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class LanguageTranslationTest {

    LanguageTranslation tr = new LanguageTranslation();
    boolean rep =false;

    
    @DataProvider(name = "text")
    public Object[][] text() {

        return new Object[][]{
                {"en", "fr", "tree","arbre"}, 
        };
    }

    @Test(dataProvider = "text")
    public void testTranslation(String fromLang, String toLang, String fromText, String exp) {

        Translation translation = new Translation();
        try {
            String rep = translation.textTranslate(fromLang, toLang, fromText);
            Assert.assertEquals(rep, exp, "Correct translation");
            System.out.println(fromText);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void  conflictFromLanguage(){

        try{
             rep= Boolean.parseBoolean(translation.textTranslate("fr", "en", "tree"));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(rep,false,"Language translated conflict");
    }

    @Test
    public void  conflictToLanguage(){

        try{
            rep= Boolean.parseBoolean(translation.textTranslate("en", "fr", "tree"));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(rep,false,"conflict ToLanguage");
    }

    @Test
    public void  nullTranslateText(){

        try{
            rep= Boolean.parseBoolean(translation.textTranslate("en", "fr", ""));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(rep,false,"null input text");
    }
   /* @Test
    public void  invalidCharacters(){

        try{
            rep= Boolean.parseBoolean(translation.textTranslate("en", "fr", "u*6frrr"));
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(rep,false,"Invalid Input Characters");
    }*/

  
}
