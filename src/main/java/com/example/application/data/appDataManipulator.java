package com.example.application.data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class appDataManipulator {
    // Variables de instancia
    private List<User> appUsers = new ArrayList<>();
    private List<Project> appProjects = new ArrayList<>();
    private String userPath = "Users.data";
    private String projectsPath = "Projects.data";

    // Constructor
    public appDataManipulator(String usersPath, String projectsPath) {
        // Obtengo lista de usuarios
        List<Object> serializedUsers = readSerializedFile(usersPath);
        for (Object obj : serializedUsers) {
            if (obj instanceof User) {
                appUsers.add((User) obj);
            }
        }

        // Obtengo lista de proyectos
        List<Object> serializedProjects = readSerializedFile(projectsPath);
        for (Object obj : serializedProjects) {
            if (obj instanceof Project) {
                appProjects.add((Project) obj);
            }
        }

        // Verificacion de existencia de datos
        if (appUsers.size() == 0) {
            appUsers = defaultUsers();
            writeSerializedFile(User.getObjectsList(appUsers), userPath);
        }

        if (appProjects.size() == 0) {
            appProjects = defaultProjects();
            writeSerializedFile(Project.getObjectsList(appProjects), projectsPath);
        }
    }    

    // Metodos estaticos
    // escritura, creacion de archivos serializados dado un arreglo de objetos y un path
    private void writeSerializedFile(List<Object> objetos,String pathArchivo){
        ObjectOutputStream fileOut;
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(pathArchivo);
            fileOut = new ObjectOutputStream(fos);
            for(Object objeto:objetos){
                fileOut.writeObject(objeto);
            }
            fileOut.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            System.out.println(e.initCause(e));
            e.printStackTrace();
        }
    }
    
    // Leectura archivos serializados dado path
    public List<Object> readSerializedFile(String pathArchivo) {
    List<Object> arryList = new ArrayList<>();

    try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(pathArchivo))) {
        Object someObject = fileIn.readObject();
        if (someObject instanceof List<?>) {
            arryList = (List<Object>) someObject;
        }
    } catch (FileNotFoundException e) {
        System.out.println("El archivo no existe: " + e.getMessage());
        writeSerializedFile(arryList, pathArchivo);
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al leer el archivo serializado: " + e.getMessage());
        e.printStackTrace();
    }
    return arryList;
}


    // Metodos para preservacion de datos
    public void saveData() {
        writeSerializedFile(User.getObjectsList(appUsers), userPath);
        writeSerializedFile(Project.getObjectsList(appProjects), projectsPath);
    }

    // Obtenemos proyectos pertenecientes a un usuario'
    public List<Project> getUserProjects(User user) {
        List<Project> userProjects = new ArrayList<>();
        for (Project proj : appProjects) {
            if (proj.getAssignedUsers().indexOf(user) >= 0) {
                userProjects.add(proj);
            }
        }
        return userProjects;
    }

    // Obtenemos usuario dado nombre de usuario o creamos si no existe
    public User getUserByNameData(String userName, String pass, String rol) {
        for(User usr : appUsers) {
            if(usr.getUsername() == userName && usr.getPassword() == pass && usr.getRole() == rol) {
                return usr;
            } else if(usr.getUsername() == userName) {
                List<Project> emptyList = new ArrayList<>();
                User wrongUser = new User("", "", "", emptyList);
                return wrongUser;
            }
        }

        List<Project> newProjectList = new ArrayList<>();
        User newUser = new User(userName, pass, rol, newProjectList);
        appUsers.add(newUser);
        return newUser;
    }

    // Datos default
    public List<User> defaultUsers() {
        List<Project> emptyProjList = new ArrayList<>();
        User user1 = new User("Usuario1", "Pass1", "Profesor", emptyProjList);
        User user2 = new User("Usuario2", "Pass1", "Estudiante", emptyProjList);
        List<User> myUsers = new ArrayList<>();
        myUsers.add(user1);
        myUsers.add(user2);
        return myUsers;
    }

    private List<Comment> defaultComments() {
        List<User> myUsers = defaultUsers();
        Comment comment1 = new Comment(myUsers.get(0),"Comentario1", LocalDate.now());
        Comment comment2 = new Comment(myUsers.get(1),"Comentario2", LocalDate.now());
        Comment comment3 = new Comment(myUsers.get(0),"Comentario3", LocalDate.now());
        Comment comment4 = new Comment(myUsers.get(1),"Comentario4", LocalDate.now());

        List<Comment> myComments = new ArrayList<>();
        myComments.add(comment1);
        myComments.add(comment2);
        myComments.add(comment3);
        myComments.add(comment4);

        return myComments;
    }

    private List<Task> defaultTasks() {
        List<User> myUsers = defaultUsers();
        List<Comment> myComments = defaultComments();

        List<User> profesores = new ArrayList<>();
        profesores.add(myUsers.get(0));

        List<User> estudiantes = new ArrayList<>();
        estudiantes.add(myUsers.get(1));


        Task task1 = new Task("Tarea 1", "Esta descripcion describe la tarea", LocalDate.now(), estudiantes, "Done", myComments);
        Task task2 = new Task("Tarea 2", "Esta descripcion describe la tarea", LocalDate.now(), estudiantes, "Done", myComments);

        List<Task> myTasks = new ArrayList<>();
        myTasks.add(task1);
        myTasks.add(task2);

        return myTasks;
    }

    private List<Project> defaultProjects() {
        List<User> myUsers = defaultUsers();
        List<Task> myTasks = defaultTasks();

        User profesor = myUsers.get(0);

        Project myProject = new Project("Project 1", LocalDate.now(), LocalDate.now(), "Este es un proyecto genial!", myTasks.size(), myUsers, profesor, myTasks);

        List<Project> myProjects = new ArrayList<>();
        myProjects.add(myProject);

        return myProjects;
    }
    
}

    