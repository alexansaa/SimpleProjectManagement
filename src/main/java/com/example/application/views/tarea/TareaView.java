package com.example.application.views.tarea;

import com.example.application.data.Comment;
import com.example.application.data.Task;
import com.example.application.data.User;
import com.example.application.views.MainLayout;
import com.example.application.views.login.LoginView;
import com.example.application.views.proyecto.ProyectoView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
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
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@PageTitle("Tarea")
@Route(value = "tarea", layout = MainLayout.class)
@Uses(Icon.class)
public class TareaView extends Composite<VerticalLayout> {

    private User usuario = LoginView.usuario;
    private Task tarea = ProyectoView.tarea;
    private List<Comment> comments = tarea.getComments();


    public TareaView() {
        System.out.println(comments);
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        MenuBar menuBar = new MenuBar();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        H4 h4 = new H4();
        H4 h42 = new H4();
        H4 h43 = new H4();
        H4 h44 = new H4();
        Hr hr = new Hr();
        H3 h3 = new H3();
        Paragraph textMedium = new Paragraph();
        Hr hr2 = new Hr();
        H3 h32 = new H3();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        MessageList messageList = new MessageList();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.START);
        layoutRow.addClassName(Gap.XSMALL);
        layoutRow.addClassName(Padding.XSMALL);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn4.setAlignItems(Alignment.START);
        layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, menuBar);
        menuBar.setWidth("min-content");
        if (usuario.getRole().equals("Profesor")){
            setMenuBarSampleData(menuBar);
        }
        layoutRow2.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.SMALL);
        layoutRow2.addClassName(Padding.XSMALL);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("80px");
        layoutRow2.setAlignItems(Alignment.START);
        layoutRow2.setJustifyContentMode(JustifyContentMode.START);
        h2.setText(tarea.getTaskName());
        layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("800px");
        h2.setHeight("50px");
        layoutColumn5.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setPadding(false);
        layoutColumn5.setWidth("100%");
        layoutColumn5.setHeight("100px");
        layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn5.setAlignItems(Alignment.END);
        h4.setText("Estado: " + tarea.getTaskStatus());
        layoutColumn5.setAlignSelf(FlexComponent.Alignment.END, h4);
        h4.setWidth("max-content");
        h42.setText("Fecha de creación: " + tarea.getCreationDate().toString());
        h42.setWidth("max-content");
        h44.setText("Asignado a: " + tarea.getAssignedUsers().stream()
                .map(User::getUsername) // Suponiendo que hay un método getUsername() en la clase User
                .collect(Collectors.joining(", ")));
        h44.setWidth("max-content");
        h3.setText("Indicaciones");
        h3.setWidth("max-content");
        textMedium.setText(
                tarea.getDescription());
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        h32.setText("Comentarios");
        h32.setWidth("max-content");
        layoutRow3.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        messageList.setWidth("100%");
        setMessageListSampleData(messageList);
        layoutRow4.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        layoutRow4.setAlignItems(Alignment.CENTER);
        layoutRow4.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary.setText("Agregar Comentario");
        buttonPrimary.addClickListener(e -> {
            buttonPrimary.getUI().ifPresent(ui -> ui.navigate("crear-comentario"));
        });
        layoutRow4.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Volver");
        buttonSecondary.setWidth("min-content");
        buttonSecondary.addClickListener(e -> {
            buttonSecondary.getUI().ifPresent(ui -> ui.navigate("proyecto"));
        });
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn4.add(menuBar);
        layoutColumn4.add(layoutRow2);
        layoutRow2.add(h2);
        layoutRow2.add(layoutColumn5);
        layoutColumn5.add(h4);
        layoutColumn5.add(h42);
        layoutColumn5.add(h43);
        layoutColumn4.add(h44);
        layoutColumn4.add(hr);
        layoutColumn4.add(h3);
        layoutColumn4.add(textMedium);
        layoutColumn4.add(hr2);
        layoutColumn4.add(h32);
        layoutColumn4.add(layoutRow3);
        layoutRow3.add(messageList);
        layoutColumn4.add(layoutRow4);
        layoutRow4.add(buttonPrimary);
        layoutRow4.add(buttonSecondary);
    }

    private void setMenuBarSampleData(MenuBar menuBar) {
        menuBar.addItem("Editar Tarea", e -> {
            menuBar.getUI().ifPresent(ui -> ui.navigate("editar-tarea"));
        });
        menuBar.addItem("Eliminar Tarea", e -> {
            eliminarTarea();
        });
    }

    private void eliminarTarea(){
        MainLayout.project.deleteTask(ProyectoView.tarea);
        getUI().ifPresent(ui -> ui.navigate("proyecto"));
    }

    private void setMessageListSampleData(MessageList messageList) {
        Random random = new Random();
    
        List<MessageListItem> messageItems = new ArrayList<>();
    
        for (Comment comment : comments) {
            MessageListItem message = new MessageListItem(comment.getText(), 
                comment.getCommentDate().atStartOfDay().toInstant(ZoneOffset.UTC),
                comment.getOwner().getUsername());
            message.setUserColorIndex(random.nextInt(14) + 1); // Números aleatorios entre 1 y 14
            messageItems.add(message);
        }
    
        messageList.setItems(messageItems.toArray(new MessageListItem[0]));
    }
    

    
}
