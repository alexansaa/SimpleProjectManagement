package com.example.application.views.creartarea;

import com.example.application.views.MainLayout;
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
        buttonSecondary.setText("Volver");
        buttonSecondary.setWidth("min-content");
        buttonSecondary.addClickListener(e -> {
            buttonSecondary.getUI().ifPresent(ui -> ui.navigate("tarea"));
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
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void onButtonPrimaryClick() {
        TextField textField = new TextField();
        DatePicker datePicker = new DatePicker();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        ComboBox comboBox = new ComboBox();
        TextArea textArea = new TextArea();

        String taskName = textField.getValue();
        LocalDate fecha = datePicker.getValue();
        Set<SampleItem> estudiantesSeleccionados = multiSelectComboBox.getValue();
        // String combo = comboBox.getValue();
        String text = textArea.getValue();
        
        System.out.println(textField);
        System.out.println(datePicker);
        System.out.println(multiSelectComboBox);
        System.out.println(comboBox);
        System.out.println(textArea);
    }
}
