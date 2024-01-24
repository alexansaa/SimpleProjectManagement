package com.example.application.views.crearproyecto;

import com.example.application.data.Project;
import com.example.application.data.Task;
import com.example.application.data.User;
import com.example.application.views.MainLayout;
import com.example.application.views.home.HomeView;
import com.example.application.views.login.LoginView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.RolesAllowed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@PageTitle("Crear Proyecto")
@Route(value = "crear-proyecto")
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class CrearProyectoView extends Composite<VerticalLayout> {
    private boolean volverMenu = HomeView.volverMenu;

    VerticalLayout layoutColumn2 = new VerticalLayout();
    VerticalLayout layoutColumn3 = new VerticalLayout();
    FormLayout formLayout2Col = new FormLayout();
    TextField textField = new TextField();
    DatePicker datePicker = new DatePicker();
    FormLayout formLayout2Col2 = new FormLayout();
    MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
    ComboBox comboBox = new ComboBox();
    TextArea textArea = new TextArea();
    HorizontalLayout layoutRow = new HorizontalLayout();
    Button buttonPrimary = new Button();
    Button buttonSecondary = new Button();
    
    record SampleItem(String value, String label, Boolean disabled) {
    }
    
    public CrearProyectoView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn2.setAlignItems(Alignment.CENTER);
        layoutColumn3.setWidth("100%");
        layoutColumn3.setMaxWidth("800px");
        layoutColumn3.setHeight("500px");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn3.setAlignItems(Alignment.CENTER);
        formLayout2Col.setWidth("100%");
        textField.setLabel("Nombre del proyecto");
        datePicker.setLabel("Fecha de entrega");
        formLayout2Col2.setWidth("100%");
        multiSelectComboBox.setLabel("Asignar estudiantes");
        multiSelectComboBox.setWidth("770px");
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        comboBox.setLabel("Estado");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        textArea.setLabel("Descripción");
        textArea.setWidth("100%");
        textArea.setHeight("300px");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary.setText("Crear");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener((event -> onButtonPrimaryClick()));
        
        buttonSecondary.setText("Volver");
        if (volverMenu) {
            buttonSecondary.addClickListener(e -> {
                buttonSecondary.getUI().ifPresent(ui -> ui.navigate("home"));
            });
        } else {
            buttonSecondary.addClickListener(e -> {
                buttonSecondary.getUI().ifPresent(ui -> ui.navigate("proyecto"));
            });
        }
        buttonSecondary.setWidth("min-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(formLayout2Col);
        formLayout2Col.add(textField);
        formLayout2Col.add(datePicker);
        layoutColumn3.add(formLayout2Col2);
        formLayout2Col2.add(multiSelectComboBox);
        formLayout2Col2.add(comboBox);
        layoutColumn3.add(textArea);
        layoutColumn3.add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
    }


    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<User> users = LoginView.usuarios;

        List<SampleItem> sampleItems = new ArrayList<>();

        for(User usr : users){
            sampleItems.add(new SampleItem(usr.getUsername(), usr.getUsername(), null));
        }
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("No iniciado", "No iniciado", null));
        sampleItems.add(new SampleItem("En progreso", "En progreso",  null));
        sampleItems.add(new SampleItem("Finalizado", "Finalizado",  Boolean.TRUE));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void onButtonPrimaryClick() {
        // Access the values from the form components
        String nombreProyecto = textField.getValue();
        LocalDate fechaEntrega = datePicker.getValue();
        Set<SampleItem> estudiantesSeleccionados = multiSelectComboBox.getValue();
        List<User> usuariosAsignados = new ArrayList<>();
        for(SampleItem usr : estudiantesSeleccionados){
            User myUser = LoginView.getUser(usr.value);
            if(myUser.getUsername() != ""){
                usuariosAsignados.add(myUser);
            }
        }
        Object estadoSeleccionado = comboBox.getValue();
        String estado = "";
        if (estadoSeleccionado instanceof SampleItem) {
            SampleItem myEstado = (SampleItem) estadoSeleccionado;
        
            // Now you can access the value field
            estado = myEstado.value();
        
            // Use estadoSeleccionadoValue as needed
            System.out.println("Estado Seleccionado Value: " + estado);
        } else {
            // Handle the case where the value is not of type SampleItem
            System.out.println("Unexpected value type");
        }
        String descripcion = textArea.getValue();

        System.out.println("Nombre del proyecto: " + nombreProyecto);
        System.out.println("Fecha de entrega: " + fechaEntrega);
        System.out.println("Estudiantes seleccionados: " + usuariosAsignados);
        System.out.println("Estado seleccionado: " + estado);
        System.out.println("Descripción: " + descripcion);

        List<Task> newTasks = new ArrayList<>();

        Project newProject = new Project(nombreProyecto, LocalDate.now(),
            fechaEntrega, descripcion, usuariosAsignados, LoginView.usuario, newTasks,
            estado);
        LoginView.addProject(newProject);
    
        buttonPrimary.getUI().ifPresent(e -> navigateToProject(newProject));
    }

    public void navigateToProject(Project xProyecto) {
        MainLayout.project = xProyecto;
        getUI().ifPresent(ui -> ui.navigate("home"));
        getUI().ifPresent(ui -> ui.navigate("proyecto"));
    }
}
