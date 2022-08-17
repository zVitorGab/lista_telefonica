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
import javafx.scene.layout.VBox;

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
        taDetalhes.setPrefWidth(200.0);

        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);

        VBox box = new VBox();
        box.setSpacing(10.0);

        box.getChildren().addAll(ltvContatos,btVoltar);

        root = new HBox();
        root.setSpacing(10.0);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(box,taDetalhes);
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
            taDetalhes.appendText("Telefone: "+contato.getTelefone()+"\n");    
            taDetalhes.appendText("E-mail:"+contato.getEmail());
        }
    }

    public Parent getRoot(){
        return root;
    }

    private void voltar(ActionEvent evento) {
        App.popScreen();
    }

}
