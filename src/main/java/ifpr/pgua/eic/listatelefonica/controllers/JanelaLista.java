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

/**
 * Tela para mostar a lista de contatos.
 */
public class JanelaLista {

    private HBox root;

    /*Componente utilizado para mostra o conteúdo de uma lista (ArrayList). Precisa
     * especificar qual tipo de objeto será mostrado. O item da lista utiliza o toString 
     * do objeto mostrado.
     */
    private ListView<Contato> ltvContatos;
    /*Área de texto. Semelhante ao TextField, porém com várias linhas. */
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
        /*Cria um ação ao clicar com o mouse em um item da lista. Toda vez que for
         * clicado executa o método mostraDetalhes. Semelhante ao onAction de um botão.
         */
        ltvContatos.setOnMouseClicked(this::mostraDetalhes);
        
        taDetalhes = new TextArea();
        taDetalhes.setPrefWidth(200.0);

        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);

        /*Utilizado para organizar parte dos componentes da tela de forma vertical. */
        VBox box = new VBox();
        box.setSpacing(10.0);

        box.getChildren().addAll(ltvContatos,btVoltar);

        root = new HBox();
        root.setSpacing(10.0);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(box,taDetalhes);
    }

    /*Método utilizado para inicializar os dados no ListView */
    private void carregaDados(){
        ltvContatos.getItems().clear();
        /*Pega a lista de contatos e coloca dentro do ListView */
        ltvContatos.getItems().addAll(listaTelefonica.getContatos());
    }

    /*Método que será executado ao clicar em um item da lista. */
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

    public Parent getRoot(){
        return root;
    }

    private void voltar(ActionEvent evento) {
        App.popScreen();
    }

}
