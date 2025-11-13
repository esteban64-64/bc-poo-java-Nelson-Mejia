
package co.edu.sena.DesignProject.semana2;

import co.edu.sena.DesignProject.semana1.DesignProject;
import co.edu.sena.DesignProject.semana2.Designer;
import co.edu.sena.DesignProject.semana2.Material;

public class ProjectAssignment {
    // ====== Atributos con Relaciones ======
    private DesignProject project;    // Relación con DesignProject
    private Designer designer;        // Relación con Designer
    private Material material;        // Relación con Material
    private String assignmentDate;    // Fecha de asignación
    private String status;            // Estado (en progreso, completado, cancelado)

    // ====== Constructor ======
    public ProjectAssignment(DesignProject project, Designer designer, Material material, String date) {
        this.project = project;
        this.designer = designer;
        this.material = material;
        this.assignmentDate = date;
        this.status = "En Progreso";
    }

    // ====== Método: Mostrar resumen ======
    public void showAssignmentSummary() {
        System.out.println("=== PROJECT ASSIGNMENT ===");
        System.out.println("Project: " + project.getProjectCode());
        System.out.println("Designer: " + designer.getName());
        System.out.println("Material: " + material.getMaterialType());
        System.out.println("Date: " + assignmentDate);
        System.out.println("Status: " + status);
    }

    // ====== Método de negocio: Calcular costo total ======
    public double calculateTotalCost() {
        double projectCost = project.calculateFinalCost();
        double materialCost = material.getUnitCost() * 10; // Asumiendo 10 unidades
        return projectCost + materialCost;
    }

    // ====== Método de negocio: Completar asignación ======
    public void completeAssignment(double clientRating) {
        status = "Completado";
        designer.assignProject();
        designer.updateRating(clientRating);
        material.useMaterial(10); // Usar 10 unidades del material
        System.out.println("Assignment completed successfully!");
    }

    // ====== Getters ======
    public String getStatus() {
        return status;
    }

    public Designer getDesigner() {
        return designer;
    }

    // ====== Setters ======
    public void setStatus(String status) {
        this.status = status;
    }
}