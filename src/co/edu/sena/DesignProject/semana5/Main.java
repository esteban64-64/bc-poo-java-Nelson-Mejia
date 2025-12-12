package co.edu.sena.DesignProject.semana5;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase Main - Demostración Completa de Polimorfismo
 * Semana 5: Polimorfismo (Overloading y Overriding)
 */
public class Main {
    public static void main(String[] args) {
        printHeader("PIXEL CREATIVO - SEMANA 05");
        printHeader("Polimorfismo: Sobrecarga y Sobrescritura");

        // ====== CREAR SISTEMA DE RRHH ======
        HRSystem hrSystem = new HRSystem("Pixel Creativo");

        // ====== DEMOSTRACIÓN 1: SOBRESCRITURA (@Override) ======
        printSection("1. SOBRESCRITURA DE MÉTODOS (@Override)");

        System.out.println("\n--- Creando empleados de diferentes tipos ---");

        GraphicDesigner designer1 = new GraphicDesigner(
                "GD001", "Ana García", "ana.garcia@pixelcreativo.com",
                2500000, 5, "Branding"
        );

        GraphicDesigner designer2 = new GraphicDesigner(
                "GD002", "Pedro Martínez", "pedro.martinez@pixelcreativo.com",
                2200000, 3, "Web Design"
        );

        Illustrator illustrator1 = new Illustrator(
                "IL001", "Laura Sánchez", "laura.sanchez@pixelcreativo.com",
                2800000, 7, "Digital Art", true
        );

        Illustrator illustrator2 = new Illustrator(
                "IL002", "María Rojas", "maria.rojas@pixelcreativo.com",
                2300000, 4, "Character Design", false
        );

        FreelanceDesigner freelancer1 = new FreelanceDesigner(
                "FL001", "Carlos López", "carlos.lopez@freelance.com",
                25000, 6, LocalDate.now(), true
        );

        FreelanceDesigner freelancer2 = new FreelanceDesigner(
                "FL002", "Diana Torres", "diana.torres@freelance.com",
                22000, 3, LocalDate.now(), false
        );

        // Agregar empleados al sistema
        hrSystem.addEmployee(designer1, designer2, illustrator1,
                illustrator2, freelancer1, freelancer2);

        System.out.println("\n--- Demostración: calculateSalary() sobrescrito ---");
        System.out.println("Cada tipo calcula su salario de forma diferente:\n");

        System.out.println("GraphicDesigner (Ana):");
        System.out.println("  Base: $" + String.format("%,.2f", designer1.getBaseSalary()));
        System.out.println("  Total (con bonos): $" + String.format("%,.2f", designer1.calculateSalary()));
        System.out.println("  Fórmula: Base + Antigüedad + Proyectos + Senior + Satisfacción");

        System.out.println("\nIllustrator (Laura):");
        System.out.println("  Base: $" + String.format("%,.2f", illustrator1.getBaseSalary()));
        System.out.println("  Total (con bonos): $" + String.format("%,.2f", illustrator1.calculateSalary()));
        System.out.println("  Fórmula: Base + Creatividad + Comisiones + Experiencia + Equipo");

        System.out.println("\nFreelanceDesigner (Carlos):");
        freelancer1.logHours(40);
        System.out.println("  Tarifa/hora: $" + String.format("%,.2f", freelancer1.getHourlyRate()));
        System.out.println("  Total: $" + String.format("%,.2f", freelancer1.calculateSalary()));
        System.out.println("  Fórmula: Horas × Tarifa + Bonos - Penalizaciones");

        // ====== DEMOSTRACIÓN 2: SOBRECARGA (Overloading) ======
        printSection("2. SOBRECARGA DE MÉTODOS (Overloading)");

        System.out.println("\n--- Método searchEmployee() sobrecargado (3 versiones) ---\n");

        System.out.println("1️⃣ Buscar por código:");
        Employee found1 = hrSystem.searchEmployee("GD001");
        if (found1 != null) {
            System.out.println("   Encontrado: " + found1.getName());
        }

        System.out.println("\n2️⃣ Buscar por nombre:");
        ArrayList<Employee> found2 = hrSystem.searchEmployee("Ana", "García");

        System.out.println("\n3️⃣ Buscar por rango salarial ($2M - $3M):");
        ArrayList<Employee> found3 = hrSystem.searchEmployee(2000000, 3000000);
        for (Employee emp : found3) {
            System.out.println("   - " + emp.getName() + ": $"
                    + String.format("%,.2f", emp.calculateSalary()));
        }

        System.out.println("\n--- Método calculateBonus() sobrecargado (3 versiones) ---\n");

        System.out.println("1️⃣ Bono porcentual (10%):");
        hrSystem.calculateBonus(designer1, 10);

        System.out.println("\n2️⃣ Bono fijo:");
        hrSystem.calculateBonus(illustrator1);

        System.out.println("\n3️⃣ Bono por desempeño y proyectos:");
        hrSystem.calculateBonus(designer2, 4.5, 8);

        // ====== DEMOSTRACIÓN 3: ARRAYLIST POLIMÓRFICO ======
        printSection("3. ARRAYLIST POLIMÓRFICO");

        System.out.println("\n--- ArrayList<Employee> contiene diferentes subclases ---\n");

        ArrayList<Employee> allEmployees = hrSystem.getEmployees();

        System.out.println("Tipo del ArrayList: ArrayList<Employee>");
        System.out.println("Elementos almacenados: " + allEmployees.size());
        System.out.println("\nContenido:");

        for (int i = 0; i < allEmployees.size(); i++) {
            Employee emp = allEmployees.get(i);
            System.out.printf("%d. Tipo de referencia: Employee | Tipo real: %s | Nombre: %s%n",
                    (i + 1), emp.getClass().getSimpleName(), emp.getName());
        }

        // ====== DEMOSTRACIÓN 4: POLIMORFISMO DINÁMICO (Dynamic Binding) ======
        printSection("4. POLIMORFISMO DINÁMICO (Dynamic Binding)");

        System.out.println("\n--- Mismo método, comportamiento diferente ---\n");
        System.out.println("Llamando a showEmployeeInfo() en cada objeto:\n");

        // La referencia es Employee, pero el objeto real determina qué método se ejecuta
        Employee emp1 = designer1;    // GraphicDesigner
        Employee emp2 = illustrator1; // Illustrator
        Employee emp3 = freelancer1;  // FreelanceDesigner

        System.out.println("1️⃣ emp1 (referencia Employee, objeto GraphicDesigner):");
        emp1.showEmployeeInfo();

        System.out.println("\n2️⃣ emp2 (referencia Employee, objeto Illustrator):");
        emp2.showEmployeeInfo();

        System.out.println("\n3️⃣ emp3 (referencia Employee, objeto FreelanceDesigner):");
        emp3.showEmployeeInfo();

        // ====== DEMOSTRACIÓN 5: MÉTODOS POLIMÓRFICOS ======
        printSection("5. MÉTODOS POLIMÓRFICOS");

        System.out.println("\n--- processPayroll() acepta cualquier Employee ---\n");

        hrSystem.processPayroll(designer1);
        System.out.println();
        hrSystem.processPayroll(illustrator1);
        System.out.println();
        hrSystem.processPayroll(freelancer1);

        // ====== DEMOSTRACIÓN 6: NÓMINA COMPLETA (Polimorfismo en bucle) ======
        printSection("6. NÓMINA COMPLETA - POLIMORFISMO EN BUCLE");

        // Simular actividad laboral primero
        System.out.println("\n--- Simulando actividad laboral ---");
        designer1.assignProject();
        designer1.completeProject(4.8);
        designer2.assignProject();
        designer2.completeProject(4.5);

        illustrator1.completeCommission(9.1);
        illustrator2.completeCommission(8.3);
        illustrator2.upgradeEquipment();

        freelancer1.logHours(120);
        freelancer1.deliverProject(true);
        freelancer2.logHours(80);

        // Procesar nómina
        hrSystem.processCompletePayroll();

        // ====== DEMOSTRACIÓN 7: BUCLE POLIMÓRFICO COMPLETO ======
        printSection("7. DEMOSTRACIÓN COMPLETA DE POLIMORFISMO");

        System.out.println("\n--- Recorriendo ArrayList con polimorfismo ---\n");

        for (Employee emp : allEmployees) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.printf("║  %-36s  ║%n", emp.getName());
            System.out.println("╚════════════════════════════════════════╝");

            // Información polimórfica
            System.out.println("Tipo de referencia: Employee");
            System.out.println("Tipo real: " + emp.getClass().getSimpleName());
            System.out.println("Departamento: " + emp.getDepartment());

            // ¡POLIMORFISMO! Cada objeto ejecuta su versión
            double salary = emp.calculateSalary();
            System.out.println("Salario (calculateSalary): $" + String.format("%,.2f", salary));

            // toString() también es polimórfico
            System.out.println("toString(): " + emp.toString());

            // Nivel de desempeño (heredado de Employee)
            System.out.println("Desempeño: " + emp.getPerformanceLevel());
            System.out.println();
        }

        // ====== DEMOSTRACIÓN 8: CONVERSIÓN DE TIPOS (instanceof y casting) ======
        printSection("8. CONVERSIÓN DE TIPOS (instanceof y Downcasting)");

        System.out.println("\n--- Accediendo a métodos específicos de cada subclase ---\n");

        for (Employee emp : allEmployees) {
            System.out.print(emp.getName() + " (" + emp.getClass().getSimpleName() + "): ");

            if (emp instanceof GraphicDesigner) {
                GraphicDesigner gd = (GraphicDesigner) emp;
                System.out.println("Especialidad: " + gd.getSpecialty()
                        + ", Proyectos: " + gd.getCompletedProjects());

            } else if (emp instanceof Illustrator) {
                Illustrator ill = (Illustrator) emp;
                System.out.println("Estilo: " + ill.getIllustrationStyle()
                        + ", Portfolio: " + ill.getPortfolioPieces() + " piezas");

            } else if (emp instanceof FreelanceDesigner) {
                FreelanceDesigner fl = (FreelanceDesigner) emp;
                System.out.println("Tarifa: $" + fl.getHourlyRate()
                        + "/hr, Días restantes: " + fl.getDaysRemaining());
            }
        }

        // ====== DEMOSTRACIÓN 9: ESTADÍSTICAS ======
        printSection("9. ESTADÍSTICAS Y ANÁLISIS");

        hrSystem.showStatisticsByType();

        System.out.println("\n--- Empleado mejor pagado ---");
        Employee highest = hrSystem.getHighestPaid();
        if (highest != null) {
            System.out.println("🏆 " + highest.getName()
                    + " (" + highest.getClass().getSimpleName() + ")");
            System.out.println("   Salario: $" + String.format("%,.2f", highest.calculateSalary()));
        }

        // ====== DEMOSTRACIÓN 10: REPORTE COMPLETO ======
        printSection("10. REPORTE COMPLETO DE EMPLEADOS");

        hrSystem.generateReport();

        // ====== RESUMEN FINAL ======
        printSection("RESUMEN DE POLIMORFISMO DEMOSTRADO");

        System.out.println("\n✅ CONCEPTOS DEMOSTRADOS:");
        System.out.println("\n1. SOBRECARGA (Overloading):");
        System.out.println("   - searchEmployee(String)");
        System.out.println("   - searchEmployee(String, String)");
        System.out.println("   - searchEmployee(double, double)");
        System.out.println("   - calculateBonus(Employee, double)");
        System.out.println("   - calculateBonus(Employee)");
        System.out.println("   - calculateBonus(Employee, double, int)");

        System.out.println("\n2. SOBRESCRITURA (Overriding):");
        System.out.println("   - calculateSalary() - Cada subclase tiene su fórmula");
        System.out.println("   - showEmployeeInfo() - Cada subclase muestra diferente info");
        System.out.println("   - toString() - Representación específica por tipo");

        System.out.println("\n3. POLIMORFISMO DINÁMICO:");
        System.out.println("   - ArrayList<Employee> almacena cualquier subclase");
        System.out.println("   - Métodos polimórficos (processPayroll, etc.)");
        System.out.println("   - Dynamic binding en tiempo de ejecución");

        System.out.println("\n4. VENTAJAS OBTENIDAS:");
        System.out.println("   ✓ Código flexible y extensible");
        System.out.println("   ✓ Mismo método, comportamiento diferente");
        System.out.println("   ✓ Fácil agregar nuevos tipos de empleados");
        System.out.println("   ✓ Colecciones heterogéneas");

        printFooter();
    }

    // ====== Métodos Auxiliares para Formateo ======
    private static void printHeader(String title) {
        System.out.println("\n╔" + "═".repeat(title.length() + 2) + "╗");
        System.out.println("║ " + title + " ║");
        System.out.println("╚" + "═".repeat(title.length() + 2) + "╝");
    }

    private static void printSection(String section) {
        System.out.println("\n\n" + "═".repeat(70));
        System.out.println(section);
        System.out.println("═".repeat(70));
    }

    private static void printFooter() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║     Sistema completado exitosamente ✓          ║");
        System.out.println("║     Polimorfismo completamente demostrado      ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
    }
}