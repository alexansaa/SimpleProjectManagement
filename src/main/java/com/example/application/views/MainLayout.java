package com.example.application.views;

import com.example.application.data.Project;
import com.example.application.data.User;
import com.example.application.views.login.LoginView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.List;
import com.vaadin.flow.component.button.Button;


/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {
    private H2 viewTitle;
    // private User usuario = LoginView.usuario;
    // public Project project1 = new Project("Proj name muy pero muy largo que pasa", LocalDate.now(), LocalDate.now(), "My desc", new ArrayList(),
    //         usuario, new ArrayList(), "En Curso");
    // public Project project2 = new Project("Proj 2", LocalDate.now(), LocalDate.now(), "My desc 2", new ArrayList(),
    //         usuario, new ArrayList(), "Terminado");

    public static Project project = new Project();

    public MainLayout() {
        // usuario.addProject(project1);
        // usuario.addProject(project2);
        // System.out.println(usuario.getProjects());
        // System.out.println("My usuario actual: " + usuario);
        setPrimarySection(Section.DRAWER);
        addHeaderContent();
        addDrawerContent(LoginView.usuario, LoginView.projects);
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent(User usuario, List<Project> projects) {
        H1 appName = new H1("project-management");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation(projects));

        addToDrawer(header, scroller, createFooter(usuario));
    }

    private VerticalLayout createNavigation(List<Project> projects) {
        VerticalLayout buttonLayout = new VerticalLayout();
    
        for (Project proj : projects) {
            Button projectButton = new Button(proj.getProjectName());
            projectButton.addClickListener(e -> navigateToProject(proj));
            projectButton.setWidth("100%");
            buttonLayout.add(projectButton);
        }
    
        return buttonLayout;
    }
 

    public void navigateToProject(Project xProyecto) {
        project = xProyecto;
        System.out.println("Aplasto el boton del: " + project);
        getUI().ifPresent(ui -> ui.navigate("home"));
        getUI().ifPresent(ui -> ui.navigate("proyecto"));
    }

    public interface ProjectAddedObserver {
        void onProjectAdded();
    }
    

    private Footer createFooter(User usuario) {
        Footer layout = new Footer();

        if (usuario.getUsername() != null) {
            System.out.println(usuario.getUsername());
            // Crear el componente de iniciales
            Avatar avatar = new Avatar(usuario.getUsername());
            avatar.setThemeName("xsmall");
            avatar.getElement().getStyle().set("tabindex", "-1");

            // Crear el menú de usuario
            MenuBar userMenu = new MenuBar();
            userMenu.setThemeName("tertiary-inline contrast");

            MenuItem userName = userMenu.addItem("");
            Div div = new Div();
            div.add(avatar);
            div.add(usuario.getUsername());
            div.add(new Icon("lumo", "dropdown"));
            div.getElement().getStyle().set("display", "flex");
            div.getElement().getStyle().set("align-items", "center");
            div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
            userName.add(div);
            userName.getSubMenu().addItem("Cerrar sesión", e -> {
                LoginView.manipulator.saveData();
                getUI().ifPresent(ui -> ui.navigate("login"));
            });
                userName.getSubMenu().addItem("Reset", e -> {
                    LoginView.manipulator.saveData();
                    getUI().ifPresent(ui -> ui.navigate("login"));
                });

            layout.add(userMenu);
        } else {
            Anchor loginLink = new Anchor("login", "Sign in");
            layout.add(loginLink);
        }

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }
    

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
