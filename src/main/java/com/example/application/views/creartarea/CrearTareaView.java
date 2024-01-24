package com.example.application.views.creartarea;

import com.example.application.data.Comment;
import com.example.application.data.Project;
import com.example.application.data.Task;
import com.example.application.data.User;
import com.example.application.views.MainLayout;
import com.example.application.views.login.LoginView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.combobox.ComboBox;
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

import javassist.tools.reflect.Sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@PageTitle("Crear Tarea")
@Route(value = "crear-tarea", layout = MainLayout.class)
@Uses(Icon.class)
public class CrearTareaView extends Composite<VerticalLayout> {

    VerticalLayout layoutColumn2 = new VerticalLayout();
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

    public CrearTareaView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("500px");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn2.setAlignItems(Alignment.CENTER);
        formLayout2Col.setWidth("100%");
        textField.setLabel("Nombre de la tarea");
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
        buttonPrimary.addClickListener((event)->onButtonPrimaryClick());
        buttonSecondary.setText("Volver");
        buttonSecondary.setWidth("min-content");
        buttonSecondary.addClickListener(e -> {
            buttonSecondary.getUI().ifPresent(ui -> ui.navigate("proyecto"));
        });
        getContent().add(layoutColumn2);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(textField);
        formLayout2Col.add(datePicker);
        layoutColumn2.add(formLayout2Col2);
        formLayout2Col2.add(multiSelectComboBox);
        formLayout2Col2.add(comboBox);
        layoutColumn2.add(textArea);
        layoutColumn2.add(layoutRow);
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
        String taskName = textField.getValue();
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
        if(estadoSeleccionado instanceof SampleItem) {
            SampleItem myEstado = (SampleItem) estadoSeleccionado;

            estado = myEstado.value();

            System.out.println("Estado Seleccionado Value: " + estado);
        } else {
            System.out.println("Unexpected value type");
        }

        String taskText = textArea.getValue();
        
        System.out.println("Nombre tarea: " + taskName);
        System.out.println("Fecha entrega: " + fechaEntrega);
        System.out.println("Estudiantes asignados: " + estudiantesSeleccionados);
        System.out.println("Estado: " + estado);
        System.out.println("Descripcion: " + taskText);

        List<Comment> newComments = new ArrayList<>();

        Task newTask = new Task(taskName, taskText, LocalDate.now(), usuariosAsignados, estado, newComments);

        if(MainLayout.project.addTask(newTask)) {
            // retorna true cuando si agrega la nueva tarea
        } else {

        }

        // modificar funcionalidad de navegacion del boton
        // buttonPrimary.getUI().ifPresent(ui -> ui.navigate("home"));
    }
}
