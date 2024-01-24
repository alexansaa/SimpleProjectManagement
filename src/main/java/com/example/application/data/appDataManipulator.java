package com.example.application.data;

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
    private String userPath;
    private String projectsPath;

    // Constructor
    public appDataManipulator(String usersPath, String projectsPath) {
        // Seteo paths correspondientes
        this.userPath = usersPath;
        this.projectsPath = projectsPath;

        // Obtengo lista de usuarios
        List<Object> serializedUsers = readSerializedFile(usersPath);
        for (Object obj : serializedUsers) {
            if (obj instanceof User) {
                appUsers.add((User) obj);
            }
        }
        System.out.println(appUsers);
        
        // Obtengo lista de proyectos
        List<Object> serializedProjects = readSerializedFile(projectsPath);
        for (Object obj : serializedProjects) {
            if (obj instanceof Project) {
                appProjects.add((Project) obj);
            }
        }
        System.out.println(appProjects);

        // Verificacion de existencia de datos
        if (appUsers.size() == 0 || appProjects.size() == 0) {
            List<Object> mockData = mockData();
            List<User> myAppUsers = (List<User>)mockData.get(0);
            List<Project> myAppProjects = (List<Project>)mockData.get(1);
            appUsers = myAppUsers;
            appProjects = myAppProjects;
        }

        this.saveData();
    }    

    // Metodos estaticos
    // escritura, creacion de archivos serializados dado un arreglo de objetos y un path
    private void writeSerializedFile(List<Object> objetos, String pathArchivo){
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

        FileInputStream fis;
        ObjectInputStream fileIn = null;

        try {
            fis = new FileInputStream(pathArchivo);
            fileIn = new ObjectInputStream(fis);
            Object somObject = null;

            do {
                somObject = (Object)fileIn.readObject();
                if(somObject != null) {
                    arryList.add(somObject);
                }
            } while(somObject != null);
            fileIn.close();
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

    // Obtenemos lista de usuarios
    public List<User> getUsers() {
        return appUsers;
    }

    // Obtenemos proyectos pertenecientes a un usuario
    public List<Project> getUserProjects(User user) {
        List<Project> userProjects = new ArrayList<>();
        for (Project proj : appProjects) {
            if (proj.getCreatorOwner().getUsername().equals(user.getUsername())) {
                userProjects.add(proj);
            } else {
                List<User> projectAssignedUsers = proj.getAssignedUsers();
                for (User assignedUser : projectAssignedUsers) {
                    if (assignedUser.getUsername().equals(user.getUsername())) {
                        userProjects.add(proj);
                    }
                }
            }
        }
        return userProjects;
    }

    // Obtenemos usuario dado nombre de usuario o creamos si no existe
    public User getUserByNameData(String userName, String pass, String rol) {
        for(User usr : appUsers) {
            System.out.println("comparacion de usuario: " + usr);
            System.out.println("Datos: " + userName + " " + pass + " " + rol);
            System.out.println("Comparaciones: " + usr.getUsername().equals(userName) + " " + usr.getPassword().equals(pass) + " " + usr.getRole().equals(rol));
            System.out.println("Typos de Comparaciones: " + (usr.getUsername().getClass().getSimpleName()) + " " + (usr.getPassword().getClass().getSimpleName()) + " " + (usr.getRole().getClass().getSimpleName()));
            System.out.println("Typos de datos: " + userName.getClass().getSimpleName() + " " + pass.getClass().getSimpleName() + " " + rol.getClass().getSimpleName());
            
            if(usr.getUsername().equals(userName) && usr.getPassword().equals(pass) && usr.getRole().equals(rol)) {
                System.out.println("Usuario encontrado");
                return usr;
            } else if(usr.getUsername().equals(userName)){
                System.out.println("Datos de usuario incorrectos");
                // Usuario existe pero datos incorrectos
                User wrongUser = new User("", "", "");
                return wrongUser;
            }
        }

        System.out.println("Creando nuevo usuario");
        User newUser = new User(userName, pass, rol);
        appUsers.add(newUser);
        return newUser;
    }

    // Agrega un proyecto a la lista de proyectos
    public void addProject(Project project){
        this.appProjects.add(project);
    }

    public void updateProject(Project newProject){
        for(Project proj : this.appProjects){
            if(proj.getProjectName().equals(newProject.getProjectName())){
                proj = newProject;
                return;
            }
        }
    }

    public void deleteProject(Project project){
        for(Project proj : this.appProjects){
            if(proj.getProjectName().equals(project.getProjectName())){
                int index = this.appProjects.indexOf(proj);
                this.appProjects.remove(index);
                return;
            }
        }
    }

    private List<Object> mockData() {
        // Creo usuarios
        User user1 = new User("Usuario1", "Pass1", "Profesor");
        User user2 = new User("Usuario2", "Pass1", "Alumno");
        List<User> myUsers = new ArrayList<>();
        myUsers.add(user1);
        myUsers.add(user2);
        List<User> estudiantes = new ArrayList<>();
        estudiantes.add(user2);
        User profesor = user1;

        // Creo Comentarios
        Comment comment1 = new Comment(myUsers.get(0),"Comentario1", LocalDate.now());
        Comment comment2 = new Comment(myUsers.get(1),"Comentario2", LocalDate.now());
        Comment comment3 = new Comment(myUsers.get(0),"Comentario3", LocalDate.now());
        Comment comment4 = new Comment(myUsers.get(1),"Comentario4", LocalDate.now());
        List<Comment> myComments = new ArrayList<>();
        myComments.add(comment1);
        myComments.add(comment2);
        myComments.add(comment3);
        myComments.add(comment4);

        // Creo tareas
        Task task1 = new Task("Tarea 1", "Esta descripcion describe la tarea", LocalDate.now(), estudiantes, "Done", myComments);
        Task task2 = new Task("Tarea 2", "Esta descripcion describe la tarea", LocalDate.now(), estudiantes, "Done", myComments);
        List<Task> myTasks = new ArrayList<>();
        myTasks.add(task1);
        myTasks.add(task2);

        // Creo Proyecto
        Project myProject = new Project("Project 1", LocalDate.now(), LocalDate.now(), "Este es un proyecto genial!", estudiantes, profesor, myTasks, "No Iniciado");

        List<Project> myProjects = new ArrayList<>();
        myProjects.add(myProject);

        List<Object> mockDataArrays = new ArrayList<>();
        mockDataArrays.add(myUsers);
        mockDataArrays.add(myProjects);

        return mockDataArrays;
    }
    
}

    