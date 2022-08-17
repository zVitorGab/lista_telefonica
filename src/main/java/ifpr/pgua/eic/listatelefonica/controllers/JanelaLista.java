package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class JanelaLista {

    private HBox root;
    private ListView<Contato> ltvContatos;
    private TextArea taDetalhes;
    private Button btVoltar;

    private ListaTelefonica listaTelefonica;

    public JanelaLista(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;
        inicializaComponentes();
        carregaDados();
    }

    private void inicializaComponentes(){
        
        ltvContatos = new ListView<>();
        ltvContatos.setOnMouseClicked(this::mostraDetalhes);
        
        taDetalhes = new TextArea();

        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);

        root = new HBox();
        root.setSpacing(10.0);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(ltvContatos,taDetalhes);
    }

    private void carregaDados(){
        ltvContatos.getItems().clear();
        ltvContatos.getItems().addAll(listaTelefonica.getContatos());
    }

    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();
        
        Contato contato = ltvContatos.getSelectionModel().getSelectedItem();

        if(contato != null){
            taDetalhes.appendText("Nome: "+contato.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+contato.getNome()+"\n");    
        }
    }

    public Parent getRoot(){
        return root;
    }

    private void voltar(ActionEvent evento) {
        App.popScreen();
    }

}
