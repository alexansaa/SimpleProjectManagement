package com.example.application.views.login;

import com.example.application.data.Project;
import com.example.application.data.User;
import com.example.application.data.appDataManipulator;
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

@PageTitle("Inicio")
@Route(value = "login")
@RouteAlias(value = "")
@AnonymousAllowed
@Uses(Icon.class)



public class LoginView extends Composite<VerticalLayout> {
    private static String userPath = "Users.data";
    private static String projectsPath = "Projects.data";
    
    public static User usuario = new User();
    public static List<Project> projects = new ArrayList<>();
    public static List<User> usuarios = new ArrayList<>();
    
    private EmailField userField;
    private Select<String> select;
    private PasswordField passwordField;
    
    // Instanciamos el manipulador de datos y el main layout
    public static appDataManipulator manipulator = new appDataManipulator(userPath, projectsPath);

    public LoginView() {
        
        H2 h2 = new H2();
        userField = new EmailField();
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
        userField.setLabel("Usuario");
        userField.setWidth("min-content");
        select.setLabel("Selecciona el Rol");
        select.setWidth("min-content");
        setSelectSampleData(select);
        passwordField.setLabel("Contraseña");
        passwordField.setWidth("min-content");

        buttonPrimary.addClickListener(e -> authenticateAndNavigate());

        getContent().add(h2, userField, select, passwordField, buttonPrimary);
    }

    private void setSelectSampleData(Select<String> select) {
        List<String> roles = new ArrayList<>();
        roles.add("Alumno");
        roles.add("Profesor");
        select.setItems(roles);
    }

    private void authenticateAndNavigate() {
        // Verificar las credenciales usando appDataManipulator        

        String user = userField.getValue();
        String rol = select.getValue();
        System.out.println("El rol es: " + rol);
        String contrasena = passwordField.getValue();

        // Aquí deberías implementar la lógica para verificar el email, contraseña y rol
        // y dar permisos de vistas en consecuencia.
        if (isValidInput(rol) && isValidInput(contrasena) && isValidInput(user)) {

            usuario = manipulator.getUserByNameData(user, contrasena, rol);
            System.out.println("My usuario: " + usuario);

            if (usuario.getUsername() == "") {
                Notification.show("Credenciales incorrectas, por favor intente de nuevo.");
                return;
            }
            else {
                usuarios = manipulator.getUsers();
                projects = manipulator.getUserProjects(usuario);
                getUI().ifPresent(ui -> ui.navigate("home"));
            }
        } else {
            // Mostrar mensaje de error
            Notification.show("Por favor, completa todos los campos correctamente");
        }

    }

    private boolean isValidInput(String input) {
        // Verificar que el campo no esté vacío
        return input != null && !input.trim().isEmpty();
    }

    public static User getUser(String userName) {
        for (User usr : usuarios){
            if(usr.getUsername().equals(userName)){
                return usr;
            }
        }
        return new User();
    }

    public static void addProject(Project project) {
        for(Project proj : projects) {
            if(proj.getProjectName().equals(project.getProjectName())){
                return;
            }
        }

        projects.add(project);
        manipulator.addProject(project);
    }
}
