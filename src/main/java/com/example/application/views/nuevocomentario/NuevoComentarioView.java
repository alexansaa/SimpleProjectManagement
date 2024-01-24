package com.example.application.views.nuevocomentario;

import java.time.LocalDate;

import com.example.application.data.Comment;
import com.example.application.views.MainLayout;
import com.example.application.views.login.LoginView;
import com.example.application.views.proyecto.ProyectoView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Nuevo Comentario")
@Route(value = "crear-comentario", layout = MainLayout.class)
@Uses(Icon.class)
public class NuevoComentarioView extends Composite<VerticalLayout> {
    TextArea textArea = new TextArea();
    HorizontalLayout layoutRow = new HorizontalLayout();
    Button buttonPrimary = new Button();
    Button buttonSecondary = new Button();

    public NuevoComentarioView() {
        getContent().setWidth("100%");
        getContent().setHeight("655px");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        textArea.setLabel("Comentario");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textArea);
        textArea.setWidth("800px");
        textArea.setHeight("150px");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary.setText("Comentar");
        layoutRow.setAlignSelf(FlexComponent.Alignment.START, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener((event) -> onButtonPrimaryClick());
        buttonSecondary.setText("Volver");
        layoutRow.setAlignSelf(FlexComponent.Alignment.START, buttonSecondary);
        buttonSecondary.setWidth("min-content");
        buttonSecondary.addClickListener(e -> {
            buttonSecondary.getUI().ifPresent(ui -> ui.navigate("tarea"));
        });
        getContent().add(textArea);
        getContent().add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
    }

    private void onButtonPrimaryClick() {
        String textoComentario = textArea.getValue();
        
        Comment newComment = new Comment(LoginView.usuario, textoComentario, LocalDate.now());

        ProyectoView.tarea.addComment(newComment);
    }
}
