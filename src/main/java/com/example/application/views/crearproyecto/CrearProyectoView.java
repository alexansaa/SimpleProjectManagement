package com.example.application.views.crearproyecto;

import com.example.application.views.MainLayout;
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
import java.util.ArrayList;
import java.util.List;

@PageTitle("Crear Proyecto")
@Route(value = "crear-proyecto", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class CrearProyectoView extends Composite<VerticalLayout> {

    public CrearProyectoView() {
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
        buttonSecondary.setText("Volver");
        buttonSecondary.addClickListener(e -> {
            buttonSecondary.getUI().ifPresent(ui -> ui.navigate("proyecto"));
        });
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

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "No iniciado", null));
        sampleItems.add(new SampleItem("second", "En progreso", null));
        sampleItems.add(new SampleItem("third", "Finalizado", Boolean.TRUE));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
