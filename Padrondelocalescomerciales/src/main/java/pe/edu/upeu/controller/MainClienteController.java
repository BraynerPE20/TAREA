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

public class MainClienteController {
    private static ClienteServiceInter cs = ClienteServiceImp.getIntance();

    @FXML TableView<Cliente> tableRegCliente;
    @FXML private TextField txtRuc, txtNombre, txtTitulo, txtPropietario, txtDireccion;
    @FXML private Button btnGuardar, btnActualizar, btnLimpiar, btnEliminar;

    private TableColumn<Cliente, String> colRuc, colNombre, colTitulo, colPropietario, colDireccion;
    ObservableList<Cliente> clientes;
    int index = -1;

    @FXML
    public void initialize() {
        definirColumnas();
        listar();
        botonDesactivar(true);
        agregarEventoSeleccion();

        btnActualizar.setOnAction(e -> { guardar(); index = -1; limpiar(); listar(); botonDesactivar(true); btnGuardar.setDisable(false); });
        btnGuardar.setOnAction(e -> { guardar(); index = -1; limpiar(); listar(); });
        btnLimpiar.setOnAction(e -> { limpiar(); index = -1; botonDesactivar(true); btnGuardar.setDisable(false); });
    }

    @FXML
    void eliminar(ActionEvent e){
        if (index != -1){
            cs.delete(index);
            index = -1;
            limpiar(); listar();
            botonDesactivar(true); btnGuardar.setDisable(false);
        }
    }

    void limpiar() {
        txtRuc.clear(); txtNombre.clear(); txtTitulo.clear(); txtPropietario.clear(); txtDireccion.clear();
    }

    void guardar() {
        Cliente c = new Cliente(txtRuc.getText(), txtNombre.getText(), txtTitulo.getText(), txtPropietario.getText(), txtDireccion.getText());
        if (index == -1 && !c.getRuc().isEmpty()) {
            cs.save(c);
        } else if (index != -1) {
            cs.uptade(c, index);
        }
    }

    void botonDesactivar(boolean estado) {
        btnActualizar.setDisable(estado);
        btnEliminar.setDisable(estado);
    }

    public void agregarEventoSeleccion() {
        tableRegCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                index = tableRegCliente.getItems().indexOf(newV);
                txtRuc.setText(newV.getRuc());
                txtNombre.setText(newV.getNombre());
                txtTitulo.setText(newV.getTitulo());
                txtPropietario.setText(newV.getPropietario());
                txtDireccion.setText(newV.getDireccion());
                botonDesactivar(false);
                btnGuardar.setDisable(true);
            }
        });
    }

    public void definirColumnas() {
        colRuc = new TableColumn<>("RUC");
        colNombre = new TableColumn<>("Comercio");
        colTitulo = new TableColumn<>("Título");
        colPropietario = new TableColumn<>("Propietario");
        colDireccion = new TableColumn<>("Dirección");
        tableRegCliente.getColumns().addAll(colRuc, colNombre, colTitulo, colPropietario, colDireccion);
    }

    public void listar() {
        colRuc.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRuc()));
        colNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        colTitulo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitulo()));
        colPropietario.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPropietario()));
        colDireccion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDireccion()));
        clientes = FXCollections.observableArrayList(cs.findAll());
        tableRegCliente.setItems(clientes);
    }
}