package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.HomePage;
import runners.RunCucumberTest;

public class DescontosStep extends RunCucumberTest {

    HomePage homePage = new HomePage(driver);


    @Dado("^que estou no site da qazando$")

    public void acessar_site_qazando() {
        homePage.acessarAplicacao();
    }

    @Quando("^eu preencho meu e-mail$")
    public void eu_preencho_meu_e_mail() {
        homePage.preencherEmail("lfpo2005@gmail.com");
    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() {
        homePage.ganharCupom();
    }

    @Então("^eu vejo o codigo de desconto$")
    public void eu_vejo_o_codigo_de_desconto() {
        homePage.verDesconto();
    }

}
