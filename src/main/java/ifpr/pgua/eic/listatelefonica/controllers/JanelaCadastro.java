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
    
    private Label lbNome;
    private TextField tfNome;

    private Label lbTelefone;
    private TextField tfTelefone;

    private Button btCadastrar;
    private Button btVoltar;

    private ListaTelefonica listaTelefonica;

    public JanelaCadastro(ListaTelefonica listaTelefonica){
        this.listaTelefonica = listaTelefonica;
        inicializaComponentes();
    }

    private void inicializaComponentes(){
        lbNome = new Label("Nome:");
        tfNome = new TextField();

        lbTelefone = new Label("Telefone:");
        tfTelefone = new TextField();

        btCadastrar = new Button("Cadastrar");
        btCadastrar.setOnAction(this::cadastrar);

        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);

        HBox botoes = new HBox();
        botoes.getChildren().addAll(btVoltar,btCadastrar);


        root = new VBox();
        root.setSpacing(5.0);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(lbNome,tfNome);
        root.getChildren().addAll(lbTelefone,tfTelefone);
        root.getChildren().add(botoes);

    }
    

    public Parent getRoot(){
        return root;
    }


    private void cadastrar(ActionEvent evento){
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();

        String msg = "Cadstro realizado!";
        if(!listaTelefonica.adicionarContato(nome, telefone, "")){
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
    }

    private void voltar(ActionEvent evento){
        App.popScreen();
    }


}
