package com.example.application.views.home;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Home")
@Route(value = "home-usuario", layout = MainLayout.class)
@RolesAllowed("USER")
@Uses(Icon.class)
public class HomeView extends Composite<VerticalLayout> {

    public HomeView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        FormLayout formLayout3Col = new FormLayout();
        H3 h3 = new H3();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        MultiSelectListBox textItems = new MultiSelectListBox();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        H4 h4 = new H4();
        H4 h42 = new H4();
        H4 h43 = new H4();
        H3 h32 = new H3();
        Hr hr = new Hr();
        Paragraph textMedium = new Paragraph();
        Hr hr2 = new Hr();
        H3 h33 = new H3();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        Button buttonSecondary = new Button();
        Paragraph textSmall = new Paragraph();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        Button buttonSecondary2 = new Button();
        Paragraph textSmall2 = new Paragraph();
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        h3.setText("Proyectos");
        h3.setWidth("max-content");
        layoutRow3.addClassName(Gap.XSMALL);
        layoutRow3.addClassName(Padding.XSMALL);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setHeight("300px");
        textItems.setWidth("100%");
        textItems.setHeight("400px");
        setMultiSelectListBoxSampleData(textItems);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Gap.XSMALL);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutRow4.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.SMALL);
        layoutRow4.addClassName(Padding.XSMALL);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("80px");
        layoutRow4.setAlignItems(Alignment.START);
        layoutRow4.setJustifyContentMode(JustifyContentMode.START);
        h2.setText("First");
        layoutRow4.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("131px");
        h2.setHeight("50px");
        layoutColumn5.setHeightFull();
        layoutRow4.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setPadding(false);
        layoutColumn5.setWidth("100%");
        layoutColumn5.setHeight("85px");
        layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn5.setAlignItems(Alignment.END);
        h4.setText("Fecha de entrega: 25/01/2024");
        h4.setWidth("max-content");
        h4.setHeight("10px");
        h42.setText("# Tareas: 2");
        h42.setWidth("max-content");
        h42.setHeight("10px");
        h43.setText("Estado: Activo");
        layoutColumn5.setAlignSelf(FlexComponent.Alignment.END, h43);
        h43.setWidth("max-content");
        h43.setHeight("1000px");
        h32.setText("Indicaciones");
        h32.setWidth("max-content");
        textMedium.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textMedium.setWidth("100%");
        textMedium.setHeight("52px");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        h33.setText("Tareas");
        h33.setWidth("max-content");
        layoutRow5.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.XSMALL);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");
        buttonSecondary.setText("Tarea 1");
        buttonSecondary.setWidth("min-content");
        textSmall.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutRow6.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow6);
        layoutRow6.addClassName(Gap.MEDIUM);
        layoutRow6.setWidth("100%");
        layoutRow6.getStyle().set("flex-grow", "1");
        buttonSecondary2.setText("Tarea 2");
        buttonSecondary2.setWidth("min-content");
        textSmall2.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textSmall2.setWidth("100%");
        textSmall2.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(formLayout3Col);
        formLayout3Col.add(h3);
        getContent().add(layoutRow3);
        layoutRow3.add(layoutColumn2);
        layoutColumn2.add(textItems);
        layoutRow3.add(layoutColumn3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn4.add(layoutRow4);
        layoutRow4.add(h2);
        layoutRow4.add(layoutColumn5);
        layoutColumn5.add(h4);
        layoutColumn5.add(h42);
        layoutColumn5.add(h43);
        layoutColumn4.add(h32);
        layoutColumn4.add(hr);
        layoutColumn4.add(textMedium);
        layoutColumn4.add(hr2);
        layoutColumn4.add(h33);
        layoutColumn4.add(layoutRow5);
        layoutRow5.add(buttonSecondary);
        layoutRow5.add(textSmall);
        layoutColumn4.add(layoutRow6);
        layoutRow6.add(buttonSecondary2);
        layoutRow6.add(textSmall2);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectListBoxSampleData(MultiSelectListBox multiSelectListBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectListBox.setItems(sampleItems);
        multiSelectListBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
        multiSelectListBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
