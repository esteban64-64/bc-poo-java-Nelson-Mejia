package co.edu.sena.DesignProject.semana5;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Sistema de Recursos Humanos para Pixel Creativo
 * Demuestra: Sobrecarga de métodos y Polimorfismo
 * Semana 5: Polimorfismo
 */
public class HRSystem {
    private ArrayList<Employee> employees;
    private String companyName;
    private double totalPayroll;

    // ====== Constructor ======
    public HRSystem(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
        this.totalPayroll = 0.0;
    }

    // ====== SOBRECARGA 1: Buscar Empleado (3 versiones) ======

    /**
     * Sobrecarga 1: Buscar por código de empleado
     */
    public Employee searchEmployee(String employeeCode) {
        for (Employee emp : employees) {
            if (emp.getEmployeeCode().equals(employeeCode)) {
                return emp;
            }
        }
        System.out.println("✗ Empleado no encontrado con código: " + employeeCode);
        return null;
    }

    /**
     * Sobrecarga 2: Buscar por nombre
     */
    public ArrayList<Employee> searchEmployee(String firstName, String lastName) {
        ArrayList<Employee> results = new ArrayList<>();
        String fullName = (firstName + " " + lastName).toLowerCase();

        for (Employee emp : employees) {
            if (emp.getName().toLowerCase().contains(fullName)) {
                results.add(emp);
            }
        }

        System.out.println("✓ Encontrados " + results.size() + " empleados con nombre: " + fullName);
        return results;
    }

    /**
     * Sobrecarga 3: Buscar por rango salarial
     */
    public ArrayList<Employee> searchEmployee(double minSalary, double maxSalary) {
        ArrayList<Employee> results = new ArrayList<>();

        for (Employee emp : employees) {
            double salary = emp.calculateSalary();
            if (salary >= minSalary && salary <= maxSalary) {
                results.add(emp);
            }
        }

        System.out.println("✓ Encontrados " + results.size() + " empleados en rango: $"
                + String.format("%.2f", minSalary) + " - $" + String.format("%.2f", maxSalary));
        return results;
    }

    // ====== SOBRECARGA 2: Agregar Empleado (2 versiones) ======

    /**
     * Sobrecarga 1: Agregar un empleado
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("✓ Empleado agregado: " + employee.getName()
                + " (" + employee.getClass().getSimpleName() + ")");
    }

    /**
     * Sobrecarga 2: Agregar múltiples empleados
     */
    public void addEmployee(Employee... employeeList) {
        for (Employee emp : employeeList) {
            employees.add(emp);
        }
        System.out.println("✓ " + employeeList.length + " empleados agregados al sistema");
    }

    // ====== SOBRECARGA 3: Calcular Bono (3 versiones) ======

    /**
     * Sobrecarga 1: Bono porcentual general
     */
    public double calculateBonus(Employee employee, double percentage) {
        double bonus = employee.getBaseSalary() * (percentage / 100);
        System.out.println("Bono para " + employee.getName() + ": "
                + percentage + "% = $" + String.format("%.2f", bonus));
        return bonus;
    }

    /**
     * Sobrecarga 2: Bono fijo
     */
    public double calculateBonus(Employee employee) {
        // Bono fijo por defecto: $500,000
        double bonus = 500000.0;
        System.out.println("Bono fijo para " + employee.getName() + ": $"
                + String.format("%.2f", bonus));
        return bonus;
    }

    /**
     * Sobrecarga 3: Bono por desempeño y proyecto
     */
    public double calculateBonus(Employee employee, double performanceRating, int projectsCompleted) {
        double performanceBonus = employee.getBaseSalary() * (performanceRating / 10);
        double projectBonus = projectsCompleted * 100000.0;
        double totalBonus = performanceBonus + projectBonus;

        System.out.println("Bono para " + employee.getName() + ":");
        System.out.println("  - Por desempeño: $" + String.format("%.2f", performanceBonus));
        System.out.println("  - Por proyectos: $" + String.format("%.2f", projectBonus));
        System.out.println("  - TOTAL: $" + String.format("%.2f", totalBonus));

        return totalBonus;
    }

    // ====== MÉTODOS POLIMÓRFICOS ======

    /**
     * Método polimórfico: Procesa nómina individual
     * Acepta cualquier tipo de Employee (padre)
     */
    public void processPayroll(Employee employee) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║         PROCESANDO NÓMINA              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Empleado: " + employee.getName());
        System.out.println("Tipo: " + employee.getClass().getSimpleName());
        System.out.println("Departamento: " + employee.getDepartment());

        // ¡POLIMORFISMO! Cada subclase ejecuta su propia versión
        double salary = employee.calculateSalary();

        System.out.println("Salario calculado: $" + String.format("%.2f", salary));
        System.out.println("Estado: PROCESADO ✓");
    }

    /**
     * Método polimórfico: Procesa nómina completa
     */
    public void processCompletePayroll() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║         NÓMINA MENSUAL - " + companyName.toUpperCase() + "       ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        totalPayroll = 0.0;
        int count = 1;

        for (Employee emp : employees) {
            System.out.println("\n" + count + ". " + emp.getName()
                    + " (" + emp.getClass().getSimpleName() + ")");

            // ¡POLIMORFISMO! Dynamic binding
            double salary = emp.calculateSalary();

            System.out.println("   Salario: $" + String.format("%,.2f", salary));
            totalPayroll += salary;
            count++;
        }

        System.out.println("\n" + "─".repeat(50));
        System.out.println("TOTAL NÓMINA: $" + String.format("%,.2f", totalPayroll));
        System.out.println("EMPLEADOS: " + employees.size());
        System.out.println("PROMEDIO: $" + String.format("%,.2f", totalPayroll / employees.size()));
    }

    /**
     * Método polimórfico: Genera reporte detallado
     */
    public void generateReport() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║         REPORTE DE EMPLEADOS                   ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        for (Employee emp : employees) {
            System.out.println();
            // ¡POLIMORFISMO! Cada clase muestra su propia información
            emp.showEmployeeInfo();
        }
    }

    /**
     * Método polimórfico: Aplica aumento a un empleado
     */
    public void applyRaise(Employee employee, double percentage) {
        System.out.println("\n💰 Aplicando aumento a: " + employee.getName());
        System.out.println("Salario anterior: $" + String.format("%.2f", employee.calculateSalary()));

        employee.applySalaryIncrease(percentage);

        System.out.println("Salario nuevo: $" + String.format("%.2f", employee.calculateSalary()));
    }

    /**
     * Método polimórfico: Evalúa desempeño
     */
    public void evaluatePerformance(Employee employee, double rating) {
        System.out.println("\n📊 Evaluando a: " + employee.getName());
        employee.updatePerformanceRating(rating);
        System.out.println("Nivel: " + employee.getPerformanceLevel());
    }

    // ====== MÉTODOS DE ANÁLISIS (Usan polimorfismo) ======

    /**
     * Obtiene el empleado mejor pagado
     */
    public Employee getHighestPaid() {
        if (employees.isEmpty()) return null;

        Employee highest = employees.get(0);
        for (Employee emp : employees) {
            // ¡POLIMORFISMO! Compara salarios calculados de diferentes tipos
            if (emp.calculateSalary() > highest.calculateSalary()) {
                highest = emp;
            }
        }
        return highest;
    }

    /**
     * Obtiene empleados por tipo
     */
    public ArrayList<Employee> getEmployeesByType(String typeName) {
        ArrayList<Employee> results = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getClass().getSimpleName().equalsIgnoreCase(typeName)) {
                results.add(emp);
            }
        }

        return results;
    }

    /**
     * Calcula estadísticas por tipo
     */
    public void showStatisticsByType() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║         ESTADÍSTICAS POR TIPO                  ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        // Contar por tipo
        int designers = 0, illustrators = 0, freelancers = 0;
        double designersSalary = 0, illustratorsSalary = 0, freelancersSalary = 0;

        for (Employee emp : employees) {
            String type = emp.getClass().getSimpleName();
            double salary = emp.calculateSalary();

            if (type.equals("GraphicDesigner")) {
                designers++;
                designersSalary += salary;
            } else if (type.equals("Illustrator")) {
                illustrators++;
                illustratorsSalary += salary;
            } else if (type.equals("FreelanceDesigner")) {
                freelancers++;
                freelancersSalary += salary;
            }
        }

        System.out.println("\nGraphic Designers:");
        System.out.println("  Cantidad: " + designers);
        if (designers > 0) {
            System.out.println("  Nómina total: $" + String.format("%,.2f", designersSalary));
            System.out.println("  Promedio: $" + String.format("%,.2f", designersSalary / designers));
        }

        System.out.println("\nIllustrators:");
        System.out.println("  Cantidad: " + illustrators);
        if (illustrators > 0) {
            System.out.println("  Nómina total: $" + String.format("%,.2f", illustratorsSalary));
            System.out.println("  Promedio: $" + String.format("%,.2f", illustratorsSalary / illustrators));
        }

        System.out.println("\nFreelance Designers:");
        System.out.println("  Cantidad: " + freelancers);
        if (freelancers > 0) {
            System.out.println("  Nómina total: $" + String.format("%,.2f", freelancersSalary));
            System.out.println("  Promedio: $" + String.format("%,.2f", freelancersSalary / freelancers));
        }
    }

    // ====== Getters ======
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public int getEmployeeCount() {
        return employees.size();
    }

    public double getTotalPayroll() {
        return totalPayroll;
    }

    public String getCompanyName() {
        return companyName;
    }
}