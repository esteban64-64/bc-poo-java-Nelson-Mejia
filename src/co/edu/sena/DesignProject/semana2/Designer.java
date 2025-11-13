package co.edu.sena.DesignProject.semana2;

public class Designer {
    // ====== Atributos ======
    private String designerCode;      // Código único del diseñador
    private String name;              // Nombre del diseñador
    private String specialty;         // Especialidad (branding, web, packaging, etc.)
    private int completedProjects;    // Proyectos completados
    private double rating;            // Calificación promedio (0-5)

    // ====== Constructor ======
    public Designer(String code, String name, String specialty) {
        this.designerCode = code;
        this.name = name;
        this.specialty = specialty;
        this.completedProjects = 0;
        this.rating = 0.0;
    }

    // ====== Método 1: Mostrar información ======
    public void showDesignerInfo() {
        System.out.println("=== DESIGNER INFORMATION ===");
        System.out.println("Code: " + designerCode);
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
        System.out.println("Completed Projects: " + completedProjects);
        System.out.println("Rating: " + rating + "/5.0");
    }

    // ====== Método de negocio: Asignar proyecto ======
    public void assignProject() {
        completedProjects++;
        System.out.println("Project assigned to " + name);
    }

    // ====== Método de negocio: Actualizar calificación ======
    public void updateRating(double newRating) {
        if (newRating >= 0 && newRating <= 5) {
            // Promedio ponderado con proyectos anteriores
            this.rating = ((this.rating * (completedProjects - 1)) + newRating) / completedProjects;
        }
    }

    // ====== Método de negocio: Verificar disponibilidad ======
    public boolean isAvailable() {
        return completedProjects < 10; // Máximo 10 proyectos activos
    }

    // ====== Getters ======
    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public double getRating() {
        return rating;
    }

    // ====== Setters ======
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}