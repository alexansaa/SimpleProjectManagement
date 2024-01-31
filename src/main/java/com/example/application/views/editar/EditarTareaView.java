package com.example.application.views.editar;

import com.example.application.data.Comment;
import com.example.application.data.Task;
import com.example.application.data.User;
import com.example.application.views.MainLayout;
import com.example.application.views.login.LoginView;
import com.example.application.views.proyecto.ProyectoView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@PageTitle("Editar Tarea")
@Route(value = "editar-tarea", layout = MainLayout.class)
@Uses(Icon.class)
public class EditarTareaView extends Composite<VerticalLayout> {

    private final VerticalLayout layoutColumn2 = new VerticalLayout();
    private final FormLayout formLayout2Col = new FormLayout();
    private final TextField textField = new TextField();
    private final FormLayout formLayout2Col2 = new FormLayout();
    private final MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
    private final ComboBox comboBox = new ComboBox();
    private final TextArea textArea = new TextArea();
    private final HorizontalLayout layoutRow = new HorizontalLayout();
    private final Button buttonPrimary = new Button();
    private final Button buttonSecondary = new Button();

    record SampleItem(String value, String label, Boolean disabled) {
    }

    public EditarTareaView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        getContent().setAlignItems(FlexComponent.Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("500px");
        layoutColumn2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layoutColumn2.setAlignItems(FlexComponent.Alignment.CENTER);
        formLayout2Col.setWidth("100%");
        textField.setLabel("Nombre de la tarea");
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
        layoutRow.setAlignItems(FlexComponent.Alignment.CENTER);
        layoutRow.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        buttonPrimary.setText("Editar");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener((event) -> onButtonPrimaryClick());
        buttonSecondary.setText("Volver");
        buttonSecondary.setWidth("min-content");
        buttonSecondary.addClickListener(e -> {
            buttonSecondary.getUI().ifPresent(ui -> ui.navigate("proyecto"));
        });
        getContent().add(layoutColumn2);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(textField);
        layoutColumn2.add(formLayout2Col2);
        formLayout2Col2.add(multiSelectComboBox);
        formLayout2Col2.add(comboBox);
        layoutColumn2.add(textArea);
        layoutColumn2.add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);

        // Llenar los campos con la información actual de la tarea seleccionada para editar
        Task currentTask = ProyectoView.tarea;
        textField.setValue(currentTask.getTaskName());
        multiSelectComboBox.setValue(getSampleItemsForUsers(currentTask.getAssignedUsers()));
        SampleItem selectedItem = new SampleItem(currentTask.getTaskStatus(), currentTask.getTaskStatus(), false);
        comboBox.setValue(selectedItem);
        textArea.setValue(currentTask.getDescription());
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

    private List<SampleItem> getSampleItemsForUsers(List<User> assignedUsers) {
        List<User> users = LoginView.usuarios;
        List<SampleItem> sampleItems = new ArrayList<>();

        for (User usr : users) {
            sampleItems.add(new SampleItem(usr.getUsername(), usr.getUsername(), assignedUsers.contains(usr)));
        }

        return sampleItems;
    }

    private SampleItem getSampleItemForStatus(String status) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("No iniciado", "No iniciado", "No iniciado".equals(status)));
        sampleItems.add(new SampleItem("En progreso", "En progreso", "En progreso".equals(status)));
        sampleItems.add(new SampleItem("Finalizado", "Finalizado", "Finalizado".equals(status)));

        return sampleItems.stream().filter(item -> item.disabled()).findFirst().orElse(null);
    }

    private void onButtonPrimaryClick() {
        String taskName = textField.getValue();
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
        } else {
            System.out.println("Unexpected value type");
        }

        String taskText = textArea.getValue();

        // Actualizar la tarea seleccionada con los valores editados
        ProyectoView.tarea.setTaskName(taskName);
        ProyectoView.tarea.setAssignedUsers(usuariosAsignados);
        ProyectoView.tarea.setTaskStatus(estado);
        ProyectoView.tarea.setDescription(taskText);

        buttonPrimary.getUI().ifPresent(e -> navigateToProject());
    }

    public void navigateToProject() {
        getUI().ifPresent(ui -> ui.navigate("proyecto"));
    }
}
