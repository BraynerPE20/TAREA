package pe.edu.upeu.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent; // Importante
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.service.ClienteServiceImp;
import pe.edu.upeu.service.ClienteServiceInter;

public class MainClienteController {
    private ClienteServiceInter cs = ClienteServiceImp.getIntance();

    @FXML private TableView<Cliente> tableRegCliente;
    @FXML private TextField txtDni, txtNombre, txtTelefono, txtEmail, txtBuscar;
    @FXML private Button btnGuardar, btnActualizar, btnLimpiar, btnEliminar;

    private ObservableList<Cliente> masterData;
    private int index = -1;

    @FXML
    public void initialize() {
        definirColumnas();
        listar();

        // Eventos por código (más seguros que por FXML)
        btnGuardar.setOnAction(e -> { guardar(); limpiar(); listar(); });
        btnActualizar.setOnAction(e -> { guardar(); limpiar(); listar(); });
        btnLimpiar.setOnAction(e -> limpiar());

        configurarFiltro();
        vincularSeleccion();
    }

    private void definirColumnas() {
        TableColumn<Cliente, String> col1 = new TableColumn<>("RUC");
        col1.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getId()));
        TableColumn<Cliente, String> col2 = new TableColumn<>("Razón Social");
        col2.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNombre()));
        TableColumn<Cliente, String> col3 = new TableColumn<>("Título");
        col3.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTelefono()));
        TableColumn<Cliente, String> col4 = new TableColumn<>("Representante");
        col4.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        tableRegCliente.getColumns().setAll(col1, col2, col3, col4);
    }

    public void listar() {
        masterData = FXCollections.observableArrayList(cs.findAll());
        tableRegCliente.setItems(masterData);
    }

    private void guardar() {
        Cliente c = new Cliente(txtDni.getText(), txtNombre.getText(), txtTelefono.getText(), txtEmail.getText());
        if (index == -1) cs.save(c); else cs.update(c, index);
    }

    private void limpiar() {
        txtDni.clear(); txtNombre.clear(); txtTelefono.clear(); txtEmail.clear();
        index = -1;
        tableRegCliente.getSelectionModel().clearSelection();
    }

    // ESTE ES EL MÉTODO QUE DABA EL ERROR
    // Se añade ActionEvent para que el FXML lo reconozca correctamente
    @FXML
    private void eliminar(ActionEvent event) {
        if (!txtDni.getText().isEmpty()) {
            cs.delete(txtDni.getText());
            listar();
            limpiar();
        } else {
            System.out.println("No hay un RUC seleccionado para eliminar.");
        }
    }

    private void vincularSeleccion() {
        tableRegCliente.getSelectionModel().selectedItemProperty().addListener((ob, ol, nv) -> {
            if (nv != null) {
                index = tableRegCliente.getSelectionModel().getSelectedIndex();
                txtDni.setText(nv.getId());
                txtNombre.setText(nv.getNombre());
                txtTelefono.setText(nv.getTelefono());
                txtEmail.setText(nv.getEmail());
            }
        });
    }

    private void configurarFiltro() {
        FilteredList<Cliente> filteredData = new FilteredList<>(masterData, p -> true);
        txtBuscar.textProperty().addListener((o, old, nv) -> {
            filteredData.setPredicate(c -> nv == null || nv.isEmpty() ||
                    c.getNombre().toLowerCase().contains(nv.toLowerCase()) ||
                    c.getId().contains(nv));
        });
        SortedList<Cliente> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableRegCliente.comparatorProperty());
        tableRegCliente.setItems(sortedData);
    }
}