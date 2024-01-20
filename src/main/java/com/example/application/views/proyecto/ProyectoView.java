package com.example.application.views.proyecto;

import com.example.application.data.Project;
import com.example.application.data.Task;
import com.example.application.data.User;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Proyecto")
@Route(value = "proyecto", layout = MainLayout.class)
@Uses(Icon.class)
public class ProyectoView extends Composite<VerticalLayout> {
    // Variable Proyecto para mostrar detalles
    public static Project project = MainLayout.project;
    
    public ProyectoView() {
        

        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        MenuBar menuBar = new MenuBar();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        H4 h4 = new H4();
        H4 h42 = new H4();
        H4 h43 = new H4();
        H4 h44 = new H4();
        H4 h45 = new H4();
        H4 h46 = new H4();
        Hr hr = new Hr();
        H3 h3 = new H3();
        Paragraph textMedium = new Paragraph();
        Hr hr2 = new Hr();
        H3 h32 = new H3();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Button buttonSecondary = new Button();
        Paragraph textSmall = new Paragraph();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Button buttonSecondary2 = new Button();
        Paragraph textSmall2 = new Paragraph();
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.XSMALL);
        layoutRow.addClassName(Padding.XSMALL);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, menuBar);
        menuBar.setWidth("min-content");
        setMenuBarSampleData(menuBar);
        layoutRow2.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.SMALL);
        layoutRow2.addClassName(Padding.XSMALL);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("160px");
        layoutRow2.setAlignItems(Alignment.START);
        layoutRow2.setJustifyContentMode(JustifyContentMode.START);
        h2.setText(project.getProjectName());
        layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("800px");
        layoutColumn4.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setPadding(false);
        layoutColumn4.setWidth("100%");
        layoutColumn4.setHeight("85px");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.END);
        h4.setText("Estado: ");
        layoutColumn4.setAlignSelf(FlexComponent.Alignment.END, h4);
        h4.setWidth("max-content");
        h4.setHeight("1000px");
        h42.setText("Fecha de creación: " + project.getCreationDate().toString());
        h42.setWidth("max-content");
        h43.setText("Fecha de entrega: " + project.getDueDate().toString());
        h43.setWidth("max-content");
        h43.setHeight("10px");
        h44.setText("# Tareas: " + project.getNumberOfTasks());
        h44.setWidth("max-content");
        h44.setHeight("10px");
        h45.setText("Creado por: " + project.getCreatorOwner().getUsername());
        h45.setWidth("max-content");
        h46.setText("Asignado a: " + project.getAssignedUsers().stream()
                .map(User::getUsername) // Suponiendo que hay un método getUsername() en la clase User
                .collect(Collectors.joining(", ")));
        h46.setWidth("max-content");
        hr.setHeight("1px");
        h3.setText("Descripción");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, h3);
        h3.setWidth("max-content");
        textMedium.setText(project.getDescription());
        textMedium.setWidth("100%");
        textMedium.setHeight("52px");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        h32.setText("Tareas");
        h32.setWidth("max-content");
        layoutRow3.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.XSMALL);
        layoutRow3.setWidth("100%");
        layoutRow3.setHeight("min-content");
        buttonSecondary.setText("Tarea 1");
        buttonSecondary.setWidth("min-content");
        textSmall.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textSmall.setWidth("max-content");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutRow4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.XSMALL);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("min-content");
        buttonSecondary2.setText("Tarea 2");
        buttonSecondary2.setWidth("min-content");
        textSmall2.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textSmall2.setWidth("max-content");
        textSmall2.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(menuBar);
        layoutColumn3.add(layoutRow2);
        layoutRow2.add(h2);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(h4);
        layoutColumn4.add(h42);
        layoutColumn4.add(h43);
        layoutColumn4.add(h44);
        layoutColumn4.add(h45);
        layoutColumn3.add(h46);
        layoutColumn3.add(hr);
        layoutColumn3.add(h3);
        layoutColumn3.add(textMedium);
        layoutColumn3.add(hr2);
        layoutColumn3.add(h32);
        layoutColumn3.add(layoutRow3);
        layoutRow3.add(buttonSecondary);
        layoutRow3.add(textSmall);
        layoutColumn3.add(layoutRow4);
        layoutRow4.add(buttonSecondary2);
        layoutRow4.add(textSmall2);
    }

    private void setMenuBarSampleData(MenuBar menuBar) {
        menuBar.addItem("Editar");
        menuBar.addItem("Eliminar");
        menuBar.addItem("Crear");
    }
}