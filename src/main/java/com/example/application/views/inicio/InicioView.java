package com.example.application.views.inicio;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.notification.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@PageTitle("Inicio")
@Route(value = "login", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class InicioView extends Composite<VerticalLayout> {

    private EmailField emailField;
    private Select<String> select;
    private PasswordField passwordField;

    public InicioView() {
        H2 h2 = new H2();
        emailField = new EmailField();
        select = new Select<>();
        passwordField = new PasswordField();
        Button buttonPrimary = new Button("Iniciar Sesión");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        getContent().setAlignItems(FlexComponent.Alignment.CENTER);

        h2.setText("Inicio de Sesión");
        h2.setWidth("max-content");
        emailField.setLabel("Email");
        emailField.setWidth("min-content");
        select.setLabel("Selecciona el Rol");
        select.setWidth("min-content");
        setSelectSampleData(select);
        passwordField.setLabel("Contraseña");
        passwordField.setWidth("min-content");

        buttonPrimary.addClickListener(e -> authenticateAndNavigate());

        getContent().add(h2, emailField, select, passwordField, buttonPrimary);
    }

    private void setSelectSampleData(Select<String> select) {
        List<String> roles = new ArrayList<>();
        roles.add("Alumno");
        roles.add("Profesor");
        select.setItems(roles);
    }

    private void authenticateAndNavigate() {
        // This method will be called when the button is clicked
        String email = emailField.getValue();
        String rol = select.getValue();
        String contrasena = passwordField.getValue();

        // Aquí deberías implementar la lógica para verificar el email, contraseña y rol
        // y dar permisos de vistas en consecuencia.
        if (isValidEmail(email) && isValidInput(rol) && isValidInput(contrasena)) {
            if (email.equals("user@gmail.com") && contrasena.equals("user")) {

                // Ejemplo de cómo puedes verificar el rol
                if ("Alumno".equals(rol)) {
                    // Verificar credenciales para alumno
                    // Dar permisos de vistas para alumno
                    // Navigate to "home" route
                    getUI().ifPresent(ui -> ui.navigate("home"));

                } else if ("Profesor".equals(rol)) {
                    // Verificar credenciales para profesor
                    // Dar permisos de vistas para profesor
                    getUI().ifPresent(ui -> ui.navigate("home"));
                }
            }
        } else {
            // Mostrar mensaje de error
            Notification.show("Por favor, completa todos los campos correctamente");
        }

    }

    private boolean isValidEmail(String email) {
        // Utilizar una expresión regular para verificar el formato del email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidInput(String input) {
        // Verificar que el campo no esté vacío
        return input != null && !input.trim().isEmpty();
    }
}
