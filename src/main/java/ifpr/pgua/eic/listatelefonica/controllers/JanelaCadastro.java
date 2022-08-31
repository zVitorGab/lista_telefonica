package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JanelaCadastro {
    
    private VBox root;
    
    /*Componente para mostrar um rótulo na tela. Geralmente
     * é utilizado para identificar outro componente.
     */


    /*Componente para mostrar um campo de texto na tela. Permite
     * ao usuário digitar dados no teclado.
     */

    @FXML    
    private TextField tfNome;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfEmail;

    private ListaTelefonica listaTelefonica;

    public JanelaCadastro(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;   
    }
    
    /*Método que será executado quando clicar no botão de cadastrar. */
    @FXML
    private void cadastrar(ActionEvent evento){

        /*Pega o texto digitado pelo usuário e armazena em uma variável. */
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email  = tfEmail.getText();

        String msg = "Cadastro realizado!";
        if(!listaTelefonica.adicionarContato(nome, telefone, email)){
            msg = "Cadastro não realizado!";
        }else{
            limpar();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();


    }

    private void limpar(){
        tfNome.clear();
        tfTelefone.clear();
        tfEmail.clear();
    }

    @FXML
    private void voltar(ActionEvent evento){
        App.popScreen();
    }


}
