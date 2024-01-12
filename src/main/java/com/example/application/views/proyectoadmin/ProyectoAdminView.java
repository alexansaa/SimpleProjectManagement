package com.example.application.views.proyectoadmin;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
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
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
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
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Proyecto Admin")
@Route(value = "proyecto-admin", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class ProyectoAdminView extends Composite<VerticalLayout> {

    public ProyectoAdminView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        FormLayout formLayout3Col = new FormLayout();
        H3 h3 = new H3();
        MenuBar menuBar = new MenuBar();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        MultiSelectListBox textItems = new MultiSelectListBox();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn7 = new VerticalLayout();
        H4 h4 = new H4();
        H4 h42 = new H4();
        H3 h32 = new H3();
        Hr hr = new Hr();
        Paragraph textMedium = new Paragraph();
        Hr hr2 = new Hr();
        H3 h33 = new H3();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        MessageList messageList = new MessageList();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidthFull();
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
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
        h3.setText("First");
        h3.setWidth("max-content");
        menuBar.setWidth("min-content");
        setMenuBarSampleData(menuBar);
        layoutRow3.addClassName(Gap.XSMALL);
        layoutRow3.addClassName(Padding.XSMALL);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutColumn4.addClassName(Gap.SMALL);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setHeight("300px");
        textItems.setWidth("min-content");
        textItems.setHeight("400px");
        setMultiSelectListBoxSampleData(textItems);
        layoutColumn5.addClassName(Gap.XSMALL);
        layoutColumn5.addClassName(Padding.XSMALL);
        layoutColumn5.setWidth("100%");
        layoutColumn5.getStyle().set("flex-grow", "1");
        layoutColumn6.setWidthFull();
        layoutColumn5.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.addClassName(Padding.XSMALL);
        layoutColumn6.setWidth("100%");
        layoutColumn6.getStyle().set("flex-grow", "1");
        layoutColumn6.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn6.setAlignItems(Alignment.START);
        layoutRow4.setWidthFull();
        layoutColumn6.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.SMALL);
        layoutRow4.addClassName(Padding.XSMALL);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("80px");
        layoutRow4.setAlignItems(Alignment.START);
        layoutRow4.setJustifyContentMode(JustifyContentMode.START);
        h2.setText("Tarea 1");
        layoutRow4.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("131px");
        h2.setHeight("50px");
        layoutColumn7.setHeightFull();
        layoutRow4.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.setPadding(false);
        layoutColumn7.setWidth("100%");
        layoutColumn7.setHeight("100px");
        layoutColumn7.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn7.setAlignItems(Alignment.END);
        h4.setText("Fecha de entrega: 25/01/2024");
        h4.setWidth("max-content");
        h4.setHeight("100px");
        h42.setText("Estado: Activo");
        layoutColumn7.setAlignSelf(FlexComponent.Alignment.END, h42);
        h42.setWidth("max-content");
        h42.setHeight("1000px");
        h32.setText("Indicaciones");
        h32.setWidth("max-content");
        textMedium.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textMedium.setWidth("100%");
        textMedium.setHeight("52px");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        h33.setText("Comentarios");
        h33.setWidth("max-content");
        layoutRow5.setWidthFull();
        layoutColumn6.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");
        messageList.setWidth("100%");
        setMessageListSampleData(messageList);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(formLayout3Col);
        formLayout3Col.add(h3);
        formLayout3Col.add(menuBar);
        layoutColumn3.add(layoutRow3);
        layoutRow3.add(layoutColumn4);
        layoutColumn4.add(textItems);
        layoutRow3.add(layoutColumn5);
        layoutColumn5.add(layoutColumn6);
        layoutColumn6.add(layoutRow4);
        layoutRow4.add(h2);
        layoutRow4.add(layoutColumn7);
        layoutColumn7.add(h4);
        layoutColumn7.add(h42);
        layoutColumn6.add(h32);
        layoutColumn6.add(hr);
        layoutColumn6.add(textMedium);
        layoutColumn6.add(hr2);
        layoutColumn6.add(h33);
        layoutColumn6.add(layoutRow5);
        layoutRow5.add(messageList);
    }

    private void setMenuBarSampleData(MenuBar menuBar) {
        menuBar.addItem("View");
        menuBar.addItem("Edit");
        menuBar.addItem("Share");
        menuBar.addItem("Move");
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

    private void setMessageListSampleData(MessageList messageList) {
        MessageListItem message1 = new MessageListItem("Nature does not hurry, yet everything gets accomplished.",
                LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), "Matt Mambo");
        message1.setUserColorIndex(1);
        MessageListItem message2 = new MessageListItem(
                "Using your talent, hobby or profession in a way that makes you contribute with something good to this world is truly the way to go.",
                LocalDateTime.now().minusMinutes(55).toInstant(ZoneOffset.UTC), "Linsey Listy");
        message2.setUserColorIndex(2);
        messageList.setItems(message1, message2);
    }
}
