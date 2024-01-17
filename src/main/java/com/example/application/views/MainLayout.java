package com.example.application.views;

import com.example.application.data.User;
import com.example.application.views.crearproyecto.CrearProyectoView;
import com.example.application.views.creartarea.CrearTareaView;
import com.example.application.views.home.HomeView;
import com.example.application.views.login.LoginView;
import com.example.application.views.nuevocomentario.NuevoComentarioView;
import com.example.application.views.proyecto1.Proyecto1View;
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

import java.io.ByteArrayInputStream;
import java.util.Optional;

import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("project-management");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Login", LoginView.class, LineAwesomeIcon.LOCK_SOLID.create()));
        
        nav.addItem(new SideNavItem("Home", HomeView.class, LineAwesomeIcon.HOME_SOLID.create()));

        nav.addItem(
                new SideNavItem("Proyecto 1", Proyecto1View.class, LineAwesomeIcon.PROJECT_DIAGRAM_SOLID.create()));

        nav.addItem(
                new SideNavItem("Tarea", TareaView.class, LineAwesomeIcon.PROJECT_DIAGRAM_SOLID.create()));

        nav.addItem(new SideNavItem("Crear Proyecto", CrearProyectoView.class,
                LineAwesomeIcon.BOOK_OPEN_SOLID.create()));

        nav.addItem(new SideNavItem("Crear Tarea", CrearTareaView.class, LineAwesomeIcon.BOOK_OPEN_SOLID.create()));

        nav.addItem(new SideNavItem("Nuevo Comentario", NuevoComentarioView.class,
                    LineAwesomeIcon.BOOK_OPEN_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
    
        User user = LoginView.usuario;
        System.out.println("El usuario es: " + user.getUsername());
    
        if (user.getUsername() != null) {
            System.out.println(user.getUsername());
            // Crear el componente de iniciales
            Avatar avatar = new Avatar(user.getUsername());
            avatar.setThemeName("xsmall");
            avatar.getElement().getStyle().set("tabindex", "-1");
    
            // Crear el menú de usuario
            MenuBar userMenu = new MenuBar();
            userMenu.setThemeName("tertiary-inline contrast");
    
            MenuItem userName = userMenu.addItem("");
            Div div = new Div();
            div.add(avatar);
            div.add(user.getUsername());
            div.add(new Icon("lumo", "dropdown"));
            div.getElement().getStyle().set("display", "flex");
            div.getElement().getStyle().set("align-items", "center");
            div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
            userName.add(div);
            userName.getSubMenu().addItem("Sign out", e -> {
                LoginView.usuario = new User();
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
