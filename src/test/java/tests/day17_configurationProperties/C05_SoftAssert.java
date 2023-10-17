package tests.day17_configurationProperties;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {
     /*
        TestNG assertion konusunda da bize bir alternatif sunar
        TestNG iki farkli Assertion class'ina sahiptir

        1- Assert
            Bu JUnit'teki assertion ile bire bir aynidir.
            sadece isimlendirirken diger alternatif softAssert oldugundan
            Assert class'ina da HARD ASSERT denir

            hard assert karsilastigi ilk failed'da
            calismayi durdurur, dolayisiyla geriye kalan assertion'larin
            passed veya failed sonuclarindan hangisini alacagini BILEMEYIZ
        2- Soft Assert
           Soft Assert biz raporla diyene kadar
           yaptigi tum testlerin sonuclarini kendisi tutar
           test passed de olsa failed de olsa calismaya devam eder

           ne zaman raporla dersek
           tum failed olanlari bize rapor eder ve calismayi durdurur

           eger hic failed olan yoksa
           class calismaya devam eder

           A- softAssert objesi olustur
           B- softAssert objesi ile testleri yap, aciklama eklemekte fayda var
           C- softAssert.assertAll() diyerek tum assertipon'lari raporla
              bu satiri yazmazsak, assertion'lar FAILED olsa bile test PASSED olur
     */
    @Test
    public void softAssertionTesti(){
    //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // url in amazon icerdigini test edelim
        String expIcerik="amazon";
        String actUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(actUrl.contains(expIcerik));

        //aranacak kelimeyi aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        //sonuclarin aranacak kelimeyi icerdigini test edelim
        String expSonuc=ConfigReader.getProperty("amazonAranacakKelime");
        String actSonuc=amazonPage.sonucYaziElementi.getText();
        softAssert.assertTrue(actSonuc.contains(expSonuc));
        //ilk urune tiklayalim
        amazonPage.ilkUrunElementi.click();
        //ilk urun isiminde aranacak kelime bulundugunu test edeliim

        String expurunIcerik =ConfigReader.getProperty("amazonAranacakKelime");
        String actIsim=amazonPage.ilkUrunIsimElementi.getText();
        softAssert.assertTrue(actIsim.contains(expurunIcerik));
        softAssert.assertAll();
        System.out.println("Failed olan varsa bu satir calismaz");
        //sayfayi kapatin
        Driver.closeDriver();



    }

}
