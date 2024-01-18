package com.example.application.views;

import com.example.application.data.Project;
import com.example.application.data.User;
import com.example.application.views.crearproyecto.CrearProyectoView;
import com.example.application.views.creartarea.CrearTareaView;
import com.example.application.views.home.HomeView;
import com.example.application.views.login.LoginView;
import com.example.application.views.nuevocomentario.NuevoComentarioView;
import com.example.application.views.proyecto.ProyectoView;
import com.example.application.views.tarea.TareaView;
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
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;
    private User usuario = LoginView.usuario;
    private Project project = ProyectoView.project;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addHeaderContent();
        addDrawerContent(usuario, project);
    }


    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent(User usuario, Project project) {
        H1 appName = new H1("project-management");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation(project));

        addToDrawer(header, scroller, createFooter(usuario));
    }

    private SideNav createNavigation(Project project) {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Login", LoginView.class, LineAwesomeIcon.LOCK_SOLID.create()));


        nav.addItem(new SideNavItem(project.getProjectName(), ProyectoView.class, LineAwesomeIcon.LOCK_SOLID.create()));

        return nav;
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
            userName.getSubMenu().addItem("Sign out", e -> {
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
