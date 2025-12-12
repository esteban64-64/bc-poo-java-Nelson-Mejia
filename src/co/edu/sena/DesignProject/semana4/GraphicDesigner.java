package co.edu.sena.DesignProject.semana4;

/**
 * Subclase 1: GraphicDesigner (Diseñador Gráfico de Planta)
 * Hereda de Employee
 * Semana 4: Herencia
 */
public class GraphicDesigner extends Employee {
    // ====== Atributos Específicos ======
    private String specialty; // Branding, Web, Packaging
    private int completedProjects;
    private int activeProjects;
    private double clientSatisfactionScore; // Promedio de calificaciones
    private boolean isSeniorDesigner;

    // ====== Constantes ======
    private static final double SENIORITY_BONUS = 500000.0;
    private static final double PROJECT_BONUS_RATE = 50000.0; // Por proyecto completado
    private static final int SENIOR_PROJECT_THRESHOLD = 50;

    // ====== Constructor Completo ======
    public GraphicDesigner(String employeeCode, String name, String email,
                           double baseSalary, int yearsOfExperience, String specialty) {
        super(employeeCode, name, email, baseSalary, "Diseño Gráfico", yearsOfExperience);
        this.specialty = specialty;
        this.completedProjects = 0;
        this.activeProjects = 0;
        this.clientSatisfactionScore = 0.0;
        this.isSeniorDesigner = false;
    }

    // ====== Constructor Básico ======
    public GraphicDesigner(String name, String email, double baseSalary, String specialty) {
        super(name, email, baseSalary);
        this.department = "Diseño Gráfico";
        this.specialty = specialty;
        this.completedProjects = 0;
        this.activeProjects = 0;
        this.clientSatisfactionScore = 0.0;
        this.isSeniorDesigner = false;
    }

    // ====== Método Sobrescrito: Información ======
    @Override
    public void showEmployeeInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    GRAPHIC DESIGNER INFORMATION        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + employeeCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Specialty: " + specialty);
        System.out.println("Level: " + (isSeniorDesigner ? "SENIOR DESIGNER ⭐" : "Designer"));
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Completed Projects: " + completedProjects);
        System.out.println("Active Projects: " + activeProjects);
        System.out.println("Client Satisfaction: " + String.format("%.1f", clientSatisfactionScore) + "/5.0");
        System.out.println("Performance Rating: " + String.format("%.1f", performanceRating) + "/5.0");
        System.out.println("Base Salary: $" + String.format("%.2f", baseSalary));
        System.out.println("Total Salary: $" + String.format("%.2f", calculateSalary()));
    }

    // ====== Método Sobrescrito: Calcular Salario ======
    @Override
    public double calculateSalary() {
        // Salario base + bono por desempeño (de la clase padre)
        double totalSalary = super.calculateSalary();

        // Bono por antigüedad: 3% por año de experiencia
        double seniorityBonus = baseSalary * 0.03 * yearsOfExperience;

        // Bono por proyectos: $50,000 por proyecto completado
        double projectBonus = completedProjects * PROJECT_BONUS_RATE;

        // Bono por ser Senior Designer
        double seniorBonus = isSeniorDesigner ? SENIORITY_BONUS : 0;

        // Bono por satisfacción del cliente: 2% por cada punto
        double satisfactionBonus = baseSalary * 0.02 * clientSatisfactionScore;

        return totalSalary + seniorityBonus + projectBonus + seniorBonus + satisfactionBonus;
    }

    // ====== Métodos Específicos ======

    /**
     * Asigna un proyecto al diseñador
     */
    public void assignProject() {
        activeProjects++;
        System.out.println("✓ Proyecto asignado a " + name);
        System.out.println("  Proyectos activos: " + activeProjects);
    }

    /**
     * Completa un proyecto y actualiza estadísticas
     */
    public void completeProject(double clientRating) {
        if (activeProjects <= 0) {
            System.out.println("✗ No hay proyectos activos para completar");
            return;
        }

        activeProjects--;
        completedProjects++;

        // Actualizar promedio de satisfacción
        if (completedProjects == 1) {
            clientSatisfactionScore = clientRating;
        } else {
            clientSatisfactionScore = ((clientSatisfactionScore * (completedProjects - 1)) + clientRating)
                    / completedProjects;
        }

        System.out.println("✓ Proyecto completado por " + name);
        System.out.println("  Total completados: " + completedProjects);
        System.out.println("  Calificación del cliente: " + String.format("%.1f", clientRating));
        System.out.println("  Satisfacción promedio: " + String.format("%.1f", clientSatisfactionScore));

        // Verificar si califica para Senior
        checkSeniorStatus();
    }

    /**
     * Verifica si califica para ser Senior Designer
     */
    private void checkSeniorStatus() {
        if (!isSeniorDesigner && completedProjects >= SENIOR_PROJECT_THRESHOLD) {
            isSeniorDesigner = true;
            System.out.println("🎉 ¡" + name + " ha sido promovido a SENIOR DESIGNER!");
        }
    }

    /**
     * Cambia la especialidad del diseñador
     */
    public void changeSpecialty(String newSpecialty) {
        String oldSpecialty = this.specialty;
        this.specialty = newSpecialty;
        System.out.println("✓ Especialidad cambiada: " + oldSpecialty + " → " + newSpecialty);
    }

    /**
     * Verifica disponibilidad (máximo 5 proyectos activos)
     */
    public boolean isAvailable() {
        return activeProjects < 5;
    }

    // ====== Getters Específicos ======
    public String getSpecialty() {
        return specialty;
    }

    public int getCompletedProjects() {
        return completedProjects;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public double getClientSatisfactionScore() {
        return clientSatisfactionScore;
    }

    public boolean isSeniorDesigner() {
        return isSeniorDesigner;
    }

    // ====== toString Sobrescrito ======
    @Override
    public String toString() {
        return String.format("GraphicDesigner[%s - %s - %s - %d proyectos - $%.2f]",
                employeeCode, name, specialty, completedProjects, calculateSalary());
    }
}