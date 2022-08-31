package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Tela para mostar a lista de contatos.
 */
public class JanelaLista implements Initializable {

    /*Componente utilizado para mostra o conteúdo de uma lista (ArrayList). Precisa
     * especificar qual tipo de objeto será mostrado. O item da lista utiliza o toString 
     * do objeto mostrado.
     */
    @FXML
    private ListView<Contato> ltvContatos;
    /*Área de texto. Semelhante ao TextField, porém com várias linhas. */
    @FXML
    private TextArea taDetalhes;

    private ListaTelefonica listaTelefonica;

    public JanelaLista(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;
    }

    /*Método utilizado para inicializar os dados no ListView */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        ltvContatos.getItems().clear();
        /*Pega a lista de contatos e coloca dentro do ListView */
        ltvContatos.getItems().addAll(listaTelefonica.getContatos());
    }

    /*Método que será executado ao clicar em um item da lista. */
    @FXML
    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();
        
        /*Pega uma referência para o contato selecionado. */
        Contato contato = ltvContatos.getSelectionModel().getSelectedItem();

        /*Mostra os detalhes do contato no TextArea */
        if(contato != null){
            taDetalhes.appendText("Nome: "+contato.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+contato.getTelefone()+"\n");    
            taDetalhes.appendText("E-mail:"+contato.getEmail());
        }
    }

    @FXML
    private void voltar(ActionEvent evento) {
        App.popScreen();
    }
}
