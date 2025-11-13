package co.edu.sena.DesignProject.semana1;

import java.util.ArrayList;

import co.edu.sena.DesignProject.semana1.Client;
import co.edu.sena.DesignProject.semana1.DesignProject;

public class Client {
    // ====== Atributos ======
    private String clientCode;     // Código único del cliente
    private String name;           // Nombre del cliente
    private String email;          // Correo de contacto
    private int activeProjects;    // Cantidad de proyectos activos
    private double totalSpent;     // Total de dinero invertido en proyectos

    // ====== Constructor ======
    public Client(String code, String name, String email) {
        this.clientCode = code;
        this.name = name;
        this.email = email;
        this.activeProjects = 0;
        this.totalSpent = 0.0;
    }

    // ====== Método 1: Mostrar información ======
    public void showClientInfo() {
        System.out.println("=== CLIENT INFORMATION ===");
        System.out.println("Code: " + clientCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Active Projects: " + activeProjects);
        System.out.println("Total Spent: $" + totalSpent);
    }

    // ====== Método 2: Registrar un nuevo proyecto ======
    public void addProject(double projectCost) {
        activeProjects++;
        totalSpent += projectCost;
    }

    // ====== Método 3: Verificar si es cliente frecuente ======
    public boolean isFrequentClient() {
        return totalSpent >= 2000000; // cliente frecuente si ha invertido más de $2 millones
    }

    // ====== Getters ======
    public String getName() {
        return name;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    // ====== Setter ======
    public void setEmail(String email) {
        this.email = email;
    }
}
