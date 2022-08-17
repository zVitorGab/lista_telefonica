package ifpr.pgua.eic.listatelefonica;

import ifpr.pgua.eic.listatelefonica.controllers.JanelaCadastro;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaLista;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryFXML;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryNoFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private ListaTelefonica listaTelefonica;

    @Override
    public void init() throws Exception {
        super.init();

        listaTelefonica = new ListaTelefonica();
    }

    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        return "Lista Telefônica Teste";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryNoFXML(o->new JanelaPrincipal().getRoot()));
        registraTela("CADASTRO", new ScreenRegistryNoFXML(o->new JanelaCadastro(listaTelefonica).getRoot()));
        registraTela("LISTA", new ScreenRegistryNoFXML(o->new JanelaLista(listaTelefonica).getRoot()));
        
    }
}