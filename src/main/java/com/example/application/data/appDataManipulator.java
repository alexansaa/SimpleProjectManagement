package com.example.application.data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private boolean writeSerializedFile(List<Object> objetos,String pathArchivo){
        boolean b = false;
        ObjectOutputStream fileOut;
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(pathArchivo);
            fileOut = new ObjectOutputStream(fos);
            for(Object objeto:objetos){
                fileOut.writeObject(objeto);
            }
            fileOut.close();
            b = true;
        }catch(IOException e){
//            System.out.println("Error: " + e.getMessage());
//            System.out.println(e.initCause(e));
            e.printStackTrace();
        }
        return b;
    }
    
    // Leectura archivos serializados dado path
    private List<Object> readSerializedFile(String pathArchivo){
        List<Object> arryList = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream fileIn = null;
        try{
            fis = new FileInputStream(pathArchivo);
            fileIn = new ObjectInputStream(fis);
            Object someObject = null;
            
            do{
                someObject = (Object)fileIn.readObject();
                if(someObject != null){
                    arryList.add(someObject);
                }
            }while(someObject != null);
            System.out.println();
            fileIn.close();
        }catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + e.getMessage());
        }catch(EOFException e){
            
        }catch(IOException e){
            System.out.println("readSerializedFile IOException: " + e.getMessage() + e.toString());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotfound " + e.getMessage());
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
            if (proj.getAssignedUsers().indexOf(user) != 0) {
                userProjects.add(proj);
            }
        }
        return userProjects;
    }

    // Datos default
    private List<User> defaultUsers() {
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
        Comment comment1 = new Comment(myUsers.get(0),"Comentario1", new Date());
        Comment comment2 = new Comment(myUsers.get(1),"Comentario2", new Date());
        Comment comment3 = new Comment(myUsers.get(0),"Comentario3", new Date());
        Comment comment4 = new Comment(myUsers.get(1),"Comentario4", new Date());

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


        Task task1 = new Task("Tarea 1", "Esta descripcion describe la tarea", new Date(), estudiantes, "Done", myComments);
        Task task2 = new Task("Tarea 2", "Esta descripcion describe la tarea", new Date(), estudiantes, "Done", myComments);

        List<Task> myTasks = new ArrayList<>();
        myTasks.add(task1);
        myTasks.add(task2);

        return myTasks;
    }

    private List<Project> defaultProjects() {
        List<User> myUsers = defaultUsers();
        List<Task> myTasks = defaultTasks();

        User profesor = myUsers.get(0);

        // fecha futura
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 4);
        Date futureDate = calendar.getTime();

        Project myProject = new Project("Project 1", new Date(), futureDate, "Este es un proyecto genial!", myTasks.size(), myUsers, profesor, myTasks);

        List<Project> myProjects = new ArrayList<>();
        myProjects.add(myProject);

        return myProjects;
    }
    
}

    