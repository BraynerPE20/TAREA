package pe.edu.upeu.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.service.ClienteServiceImp;
import pe.edu.upeu.service.ClienteServiceInter;

import java.lang.module.FindException;
import java.net.BindException;

public class MainClienteController {

    private static ClienteServiceInter cs = ClienteServiceImp.getIntance();

    @FXML
    TableView<Cliente> tableRegCliente;

    ObservableList<Cliente> clientes;
    private TableColumn<Cliente, String> colIdDni, colNombre, colTelefono, colEmail;

    @FXML
    private TextField txtDni, txtNombre, txtTelefono, txtEmail;
    @FXML
    private Button btnGuardar, btnActualizar, btnLimpiar, btnEliminar;
    int index = -1;

    @FXML
    public void initialize() {
        definirColumnas();
        listar();
        botonDesactivar(true);
        agregarEventoSeleccion();

        btnActualizar.setOnAction(Event -> {
            guardar();
            index = -1;
            limpiar();
            listar();
            botonDesactivar(true);
            btnGuardar.setDisable(false);
        });

        btnGuardar.setOnAction(e->{
            guardar();
            index = -1;
            limpiar();
            listar();
        });

        btnLimpiar.setOnAction(e->{
            limpiar();
            index=-1;
            botonDesactivar(false);
            btnGuardar.setDisable(false);
        });

    }

    @FXML
    void eliminar (ActionEvent e){
        if (index!=-1){
            cs.delete(index);
            index = -1;
            limpiar();
            listar();
            botonDesactivar(true);
            btnGuardar.setDisable(false);
        }
    }

    void limpiar() {
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }

    void guardar() {
        Cliente c = new Cliente();
        c.setId(txtDni.getText());
        c.setNombre(txtNombre.getText());
        c.setTelefono(txtTelefono.getText());
        c.setEmail(txtEmail.getText());
        if (index == -1 && !c.getId().isEmpty()) {
            cs.save(c);
        } else {
            if (index == -1){
                System.out.println("NNNNNN");
                Alert a=new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.show();
            }else {

            }
            cs.uptade(c, index);
        }
    }

    void botonDesactivar(boolean estado){
        btnActualizar.setDisable(estado);
        btnEliminar.setDisable(estado);

    }

    public void agregarEventoSeleccion() {
        tableRegCliente.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        index = tableRegCliente.getItems().indexOf(newValue);
                        txtDni.setText(newValue.getId());
                        txtNombre.setText(newValue.getNombre());
                        txtTelefono.setText(newValue.getTelefono());
                        txtEmail.setText(newValue.getEmail());
                        botonDesactivar(false);
                        btnGuardar.setDisable(true);
                    }

                });
    }

    public void definirColumnas() {
        colIdDni = new TableColumn<>("DNI");
        colNombre = new TableColumn<>("Nombre");
        colTelefono = new TableColumn<>("Telefono");
        colEmail = new TableColumn<>("Email");
        tableRegCliente.getColumns().addAll(colIdDni, colNombre, colTelefono, colEmail);

    }

    public void listar() {
        colIdDni.setCellValueFactory(cetcell -> new SimpleStringProperty(cetcell.getValue().getId()));
        colNombre.setCellValueFactory(cetcell -> new SimpleStringProperty(cetcell.getValue().getNombre()));
        colTelefono.setCellValueFactory(cetcell -> new SimpleStringProperty(cetcell.getValue().getTelefono()));
        colEmail.setCellValueFactory(cetcell -> new SimpleStringProperty(cetcell.getValue().getEmail()));
        clientes = FXCollections.observableArrayList(cs.findAll());
        tableRegCliente.setItems(clientes);
    }
}