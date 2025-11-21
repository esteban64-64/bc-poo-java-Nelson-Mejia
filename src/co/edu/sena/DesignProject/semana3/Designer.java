package co.edu.sena.DesignProject.semana3;

/**
 * Clase Designer refactorizada con encapsulación completa
 * Semana 3: Encapsulación y Constructores
 */
public class Designer {
    // ====== Atributos PRIVATE ======
    private String designerCode;
    private String name;
    private String specialty;
    private int completedProjects;
    private int activeProjects;
    private double rating;
    private double salary;
    private String email;

    // ====== Constantes ======
    private static final int MAX_ACTIVE_PROJECTS = 10;
    private static final double MIN_RATING = 0.0;
    private static final double MAX_RATING = 5.0;
    private static final double MIN_SALARY = 1300000.0; // Salario mínimo en Colombia

    // ====== Constructor Completo ======
    public Designer(String designerCode, String name, String specialty, double salary, String email) {
        setDesignerCode(designerCode);
        setName(name);
        setSpecialty(specialty);
        setSalary(salary);
        setEmail(email);
        this.completedProjects = 0;
        this.activeProjects = 0;
        this.rating = 0.0;
    }

    // ====== Constructor Básico (sin salario y email) ======
    public Designer(String designerCode, String name, String specialty) {
        this(designerCode, name, specialty, MIN_SALARY, name.toLowerCase().replaceAll(" ", ".") + "@pixelcreativo.com");
    }

    // ====== Constructor Mínimo (genera código automático) ======
    public Designer(String name, String specialty) {
        this(generateDesignerCode(name), name, specialty);
    }

    // ====== Getters ======
    public String getDesignerCode() {
        return designerCode;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getCompletedProjects() {
        return completedProjects;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public double getRating() {
        return rating;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    // ====== Setters CON VALIDACIONES ======
    public void setDesignerCode(String designerCode) {
        if (!isValidCode(designerCode)) {
            throw new IllegalArgumentException("Código de diseñador inválido. Debe tener al menos 3 caracteres.");
        }
        this.designerCode = designerCode;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        this.name = name.trim();
    }

    public void setSpecialty(String specialty) {
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía");
        }
        if (!isValidSpecialty(specialty)) {
            throw new IllegalArgumentException("Especialidad no válida. Opciones: Branding, Web Design, Packaging, Ilustración, Publicidad");
        }
        this.specialty = specialty.trim();
    }

    public void setSalary(double salary) {
        if (salary < MIN_SALARY) {
            throw new IllegalArgumentException("El salario no puede ser menor al mínimo legal ($" + MIN_SALARY + ")");
        }
        this.salary = salary;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email.toLowerCase().trim();
    }

    // ====== Métodos de Negocio ======
    public void showDesignerInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      DESIGNER INFORMATION              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + designerCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Specialty: " + specialty);
        System.out.println("Active Projects: " + activeProjects);
        System.out.println("Completed Projects: " + completedProjects);
        System.out.println("Rating: " + String.format("%.2f", rating) + "/5.0 " + getRatingStars());
        System.out.println("Salary: $" + String.format("%.2f", salary));
        System.out.println("Status: " + (isAvailable() ? "AVAILABLE ✓" : "BUSY ✗"));
    }

    public void assignProject() {
        if (!isAvailable()) {
            throw new IllegalStateException("El diseñador ha alcanzado el máximo de proyectos activos (" + MAX_ACTIVE_PROJECTS + ")");
        }
        activeProjects++;
        System.out.println("✓ Proyecto asignado a " + name + " (Activos: " + activeProjects + ")");
    }

    public void completeProject(double clientRating) {
        if (activeProjects <= 0) {
            throw new IllegalStateException("No hay proyectos activos para completar");
        }

        validateRating(clientRating);

        activeProjects--;
        completedProjects++;
        updateRating(clientRating);

        System.out.println("✓ Proyecto completado por " + name);
        System.out.println("  Nueva calificación: " + String.format("%.2f", rating) + "/5.0");
    }

    public void updateRating(double newRating) {
        validateRating(newRating);

        if (completedProjects == 0) {
            this.rating = newRating;
        } else {
            // Promedio ponderado
            this.rating = ((this.rating * (completedProjects - 1)) + newRating) / completedProjects;
        }
    }

    public boolean isAvailable() {
        return activeProjects < MAX_ACTIVE_PROJECTS;
    }

    public void increaseSalary(double percentage) {
        if (percentage <= 0 || percentage > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }

        double increase = salary * (percentage / 100);
        salary += increase;

        System.out.println("✓ Aumento salarial del " + percentage + "% aplicado");
        System.out.println("  Nuevo salario: $" + String.format("%.2f", salary));
    }

    public String getPerformanceLevel() {
        if (rating >= 4.5) return "EXCELENTE";
        if (rating >= 4.0) return "MUY BUENO";
        if (rating >= 3.5) return "BUENO";
        if (rating >= 3.0) return "REGULAR";
        return "NECESITA MEJORAR";
    }

    // ====== Métodos Auxiliares PRIVADOS ======
    private boolean isValidCode(String code) {
        return code != null && code.trim().length() >= 3;
    }

    private boolean isValidSpecialty(String specialty) {
        String normalized = specialty.toLowerCase().trim();
        return normalized.contains("branding") ||
                normalized.contains("web") ||
                normalized.contains("packaging") ||
                normalized.contains("ilustra") ||
                normalized.contains("publicidad");
    }

    private void validateRating(double rating) {
        if (rating < MIN_RATING || rating > MAX_RATING) {
            throw new IllegalArgumentException("La calificación debe estar entre " + MIN_RATING + " y " + MAX_RATING);
        }
    }

    private String getRatingStars() {
        int stars = (int) Math.round(rating);
        return "★".repeat(stars) + "☆".repeat(5 - stars);
    }

    private static String generateDesignerCode(String name) {
        if (name == null || name.length() < 2) {
            return "D000";
        }
        String prefix = name.substring(0, Math.min(2, name.length())).toUpperCase();
        int random = (int) (Math.random() * 1000);
        return "D" + prefix + String.format("%03d", random);
    }

    // ====== toString ======
    @Override
    public String toString() {
        return String.format("Designer[%s - %s - %s - Rating: %.2f]",
                designerCode, name, specialty, rating);
    }
}