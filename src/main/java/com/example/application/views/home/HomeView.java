package com.example.application.views.home;

import com.example.application.data.User;
import com.example.application.views.MainLayout;
import com.example.application.views.crearproyecto.CrearProyectoView;
import com.example.application.views.login.LoginView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class HomeView extends Composite<VerticalLayout> {
    public static boolean volverMenu = false;
    private User usuario = LoginView.usuario;

    public HomeView() {
        H1 h1 = new H1();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        h1.setText("Bienvenido al gestor de proyectos! En el menú lateral encontrarás todos los proyectos disponibles");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("100%");
        buttonPrimary.setText("Crear Proyecto");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> {
            volverMenu = true;
            buttonPrimary.getUI().ifPresent(ui -> ui.navigate("crear-proyecto"));
        });
        getContent().add(h1);
        if (usuario.getRole().equals("Profesor")){
            getContent().add(buttonPrimary);
        }
    }
}
