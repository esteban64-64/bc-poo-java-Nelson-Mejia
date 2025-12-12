package co.edu.sena.DesignProject.semana5;

/**
 * Clase Padre: Employee (Empleado)
 * Representa un empleado genérico de Pixel Creativo
 * Semana 4: Herencia
 */
public class Employee {
    // ====== Atributos PROTECTED (compartidos con subclases) ======
    protected String employeeCode;
    protected String name;
    protected String email;
    protected double baseSalary;
    protected String department;
    protected int yearsOfExperience;
    protected double performanceRating; // 0.0 - 5.0

    // ====== Constantes ======
    protected static final double MIN_SALARY = 1300000.0; // Salario mínimo Colombia
    protected static final double PERFORMANCE_BONUS_RATE = 0.05; // 5% por punto de rating

    // ====== Constructor Completo ======
    public Employee(String employeeCode, String name, String email,
                    double baseSalary, String department, int yearsOfExperience) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.email = email;
        this.baseSalary = Math.max(baseSalary, MIN_SALARY); // No menor al mínimo
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.performanceRating = 3.0; // Rating por defecto
    }

    // ====== Constructor Básico ======
    public Employee(String name, String email, double baseSalary) {
        this(generateEmployeeCode(name), name, email, baseSalary, "General", 0);
    }

    // ====== Métodos Heredables ======

    /**
     * Muestra información básica del empleado
     * Puede ser sobrescrito por las subclases
     */
    public void showEmployeeInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      EMPLOYEE INFORMATION              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + employeeCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: $" + String.format("%.2f", baseSalary));
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Performance Rating: " + String.format("%.1f", performanceRating) + "/5.0");
        System.out.println("Total Salary: $" + String.format("%.2f", calculateSalary()));
    }

    /**
     * Calcula el salario total del empleado
     * DEBE ser sobrescrito por las subclases para agregar bonos específicos
     */
    public double calculateSalary() {
        // Bono por desempeño: 5% del salario base por cada punto de rating
        double performanceBonus = baseSalary * PERFORMANCE_BONUS_RATE * performanceRating;
        return baseSalary + performanceBonus;
    }

    /**
     * Aplica un aumento de salario
     */
    public void applySalaryIncrease(double percentage) {
        if (percentage <= 0 || percentage > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }

        double increase = baseSalary * (percentage / 100);
        baseSalary += increase;

        System.out.println("✓ Aumento salarial aplicado a " + name);
        System.out.println("  Porcentaje: " + percentage + "%");
        System.out.println("  Incremento: $" + String.format("%.2f", increase));
        System.out.println("  Nuevo salario base: $" + String.format("%.2f", baseSalary));
    }

    /**
     * Actualiza el rating de desempeño
     */
    public void updatePerformanceRating(double rating) {
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating debe estar entre 0.0 y 5.0");
        }
        this.performanceRating = rating;
        System.out.println("✓ Rating actualizado: " + String.format("%.1f", rating) + "/5.0");
    }

    /**
     * Verifica si el empleado califica para bonos
     */
    public boolean qualifiesForBonus() {
        return performanceRating >= 4.0;
    }

    /**
     * Obtiene el nivel de desempeño
     */
    public String getPerformanceLevel() {
        if (performanceRating >= 4.5) return "EXCELENTE";
        if (performanceRating >= 4.0) return "MUY BUENO";
        if (performanceRating >= 3.5) return "BUENO";
        if (performanceRating >= 3.0) return "SATISFACTORIO";
        return "NECESITA MEJORAR";
    }

    // ====== Getters ======
    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public double getPerformanceRating() {
        return performanceRating;
    }

    // ====== Setters ======
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void incrementExperience() {
        this.yearsOfExperience++;
        System.out.println("✓ Experiencia incrementada: " + yearsOfExperience + " años");
    }

    // ====== Método Auxiliar Estático ======
    protected static String generateEmployeeCode(String name) {
        if (name == null || name.length() < 2) {
            return "EMP000";
        }
        String prefix = name.substring(0, Math.min(3, name.length())).toUpperCase();
        int random = (int) (Math.random() * 1000);
        return "E" + prefix + String.format("%03d", random);
    }

    // ====== toString ======
    @Override
    public String toString() {
        return String.format("%s[%s - %s - $%.2f]",
                getClass().getSimpleName(), employeeCode, name, calculateSalary());
    }
}