package co.edu.sena.DesignProject.semana4;

import java.time.LocalDate;

// Si las clases están en el mismo package, no necesitas imports
// Pero si están en diferentes packages, usa estos:
// import co.edu.sena.DesignProject.semana4.Employee;
// import co.edu.sena.DesignProject.semana4.GraphicDesigner;
// import co.edu.sena.DesignProject.semana4.Illustrator;
// import co.edu.sena.DesignProject.semana4.FreelanceDesigner;

/**
 * Clase Main - Demostración de Herencia y Polimorfismo
 * Semana 4: Herencia
 */
public class Main {
    public static void main(String[] args) {
        printHeader("PIXEL CREATIVO - SEMANA 04");
        printHeader("Herencia y Polimorfismo");

        // ====== DEMOSTRACIÓN 1: CREACIÓN DE OBJETOS CON HERENCIA ======
        printSection("1. CREACIÓN DE EMPLEADOS (HERENCIA)");

        System.out.println("\n--- GraphicDesigners (Diseñadores de Planta) ---");
        GraphicDesigner designer1 = new GraphicDesigner(
                "GD001", "Ana García", "ana.garcia@pixelcreativo.com",
                2500000, 5, "Branding"
        );

        GraphicDesigner designer2 = new GraphicDesigner(
                "GD002", "Pedro Martínez", "pedro.martinez@pixelcreativo.com",
                2200000, 3, "Web Design"
        );

        System.out.println("✓ " + designer1);
        System.out.println("✓ " + designer2);

        System.out.println("\n--- Illustrators (Ilustradores) ---");
        Illustrator illustrator1 = new Illustrator(
                "IL001", "Laura Sánchez", "laura.sanchez@pixelcreativo.com",
                2800000, 7, "Digital Art", true
        );

        Illustrator illustrator2 = new Illustrator(
                "María Rojas", "maria.rojas@pixelcreativo.com",
                2300000, "Character Design"
        );

        System.out.println("✓ " + illustrator1);
        System.out.println("✓ " + illustrator2);

        System.out.println("\n--- FreelanceDesigners (Freelancers) ---");
        FreelanceDesigner freelancer1 = new FreelanceDesigner(
                "FL001", "Carlos López", "carlos.lopez@freelance.com",
                25000, 6, LocalDate.now(), true
        );

        FreelanceDesigner freelancer2 = new FreelanceDesigner(
                "Diana Torres", "diana.torres@freelance.com",
                22000, 3
        );

        System.out.println("✓ " + freelancer1);
        System.out.println("✓ " + freelancer2);

        // ====== DEMOSTRACIÓN 2: ARRAY POLIMÓRFICO ======
        printSection("2. POLIMORFISMO - ARRAY DE EMPLEADOS");

        // ¡Este es el concepto clave de polimorfismo!
        // Un array de tipo Employee puede contener cualquier subclase
        Employee[] employees = new Employee[6];

        employees[0] = designer1;
        employees[1] = designer2;
        employees[2] = illustrator1;
        employees[3] = illustrator2;
        employees[4] = freelancer1;
        employees[5] = freelancer2;

        System.out.println("\n--- Todos los empleados (polimorfismo) ---");
        for (int i = 0; i < employees.length; i++) {
            System.out.println((i + 1) + ". " + employees[i]);
        }

        // ====== DEMOSTRACIÓN 3: MÉTODOS SOBRESCRITOS ======
        printSection("3. MÉTODOS SOBRESCRITOS (@Override)");

        System.out.println("\n--- Información de cada tipo de empleado ---");

        System.out.println("\n1️⃣ GRAPHIC DESIGNER:");
        designer1.showEmployeeInfo();

        System.out.println("\n2️⃣ ILLUSTRATOR:");
        illustrator1.showEmployeeInfo();

        System.out.println("\n3️⃣ FREELANCE DESIGNER:");
        freelancer1.showEmployeeInfo();

        // ====== DEMOSTRACIÓN 4: CÁLCULO POLIMÓRFICO DE SALARIOS ======
        printSection("4. CÁLCULO POLIMÓRFICO DE SALARIOS");

        System.out.println("\n--- Nómina Total (polimorfismo en acción) ---");
        double totalPayroll = 0;

        for (Employee emp : employees) {
            double salary = emp.calculateSalary(); // ¡Polimorfismo!
            totalPayroll += salary;

            System.out.printf("%-20s | %-25s | $%,15.2f%n",
                    emp.getClass().getSimpleName(),
                    emp.getName(),
                    salary
            );
        }

        System.out.println("─".repeat(70));
        System.out.printf("%-20s | %-25s | $%,15.2f%n",
                "TOTAL NÓMINA", "", totalPayroll);

        // ====== DEMOSTRACIÓN 5: SIMULACIÓN DE TRABAJO ======
        printSection("5. SIMULACIÓN DE ACTIVIDADES LABORALES");

        System.out.println("\n--- Actividades de Diseñadores Gráficos ---");
        designer1.assignProject();
        designer1.completeProject(4.8);
        designer1.assignProject();
        designer1.completeProject(4.5);

        designer2.assignProject();
        designer2.assignProject();
        designer2.completeProject(4.2);

        System.out.println("\n--- Actividades de Ilustradores ---");
        illustrator1.completeCommission(9.2);
        illustrator1.addToPortfolio("Dragon Illustration");
        illustrator1.addToPortfolio("Fantasy Landscape");
        illustrator1.completeCommission(8.8);

        illustrator2.upgradeEquipment(); // Comprar tablet
        illustrator2.completeCommission(7.5);
        illustrator2.addToPortfolio("Character Design - Hero");

        System.out.println("\n--- Actividades de Freelancers ---");
        freelancer1.logHours(8);
        freelancer1.logHours(6);
        freelancer1.logHours(8);
        freelancer1.deliverProject(true); // A tiempo
        freelancer1.logHours(7);

        freelancer2.logHours(5);
        freelancer2.logHours(8);
        freelancer2.deliverProject(false); // Tarde

        // ====== DEMOSTRACIÓN 6: ACTUALIZACIONES Y BONOS ======
        printSection("6. ACTUALIZACIONES DE DESEMPEÑO Y SALARIO");

        System.out.println("\n--- Actualizar Performance Ratings ---");
        designer1.updatePerformanceRating(4.7);
        illustrator1.updatePerformanceRating(4.9);
        freelancer1.updatePerformanceRating(4.5);

        System.out.println("\n--- Aumentos Salariales ---");
        designer1.applySalaryIncrease(10); // 10% de aumento
        illustrator1.applySalaryIncrease(12); // 12% de aumento
        freelancer1.increaseHourlyRate(15); // 15% en tarifa por hora

        // ====== DEMOSTRACIÓN 7: MÉTODO POLIMÓRFICO EN BUCLE ======
        printSection("7. POLIMORFISMO - MÉTODO showEmployeeInfo()");

        System.out.println("\n--- Información de todos los empleados ---");
        System.out.println("(Cada subclase muestra su propia versión)");

        for (Employee emp : employees) {
            System.out.println();
            emp.showEmployeeInfo(); // ¡Polimorfismo! Cada clase llama a su propia versión
        }

        // ====== DEMOSTRACIÓN 8: VERIFICACIÓN DE INSTANCIAS ======
        printSection("8. VERIFICACIÓN DE TIPOS (instanceof)");

        System.out.println("\n--- Conteo por tipo de empleado ---");
        int designerCount = 0;
        int illustratorCount = 0;
        int freelanceCount = 0;

        for (Employee emp : employees) {
            if (emp instanceof FreelanceDesigner) {
                freelanceCount++;
            } else if (emp instanceof Illustrator) {
                illustratorCount++;
            } else if (emp instanceof GraphicDesigner) {
                designerCount++;
            }
        }

        System.out.println("Diseñadores Gráficos: " + designerCount);
        System.out.println("Ilustradores: " + illustratorCount);
        System.out.println("Freelancers: " + freelanceCount);
        System.out.println("TOTAL: " + employees.length);

        // ====== DEMOSTRACIÓN 9: MÉTODOS ESPECÍFICOS (DOWNCASTING) ======
        printSection("9. ACCESO A MÉTODOS ESPECÍFICOS (Downcasting)");

        System.out.println("\n--- Accediendo a métodos específicos de cada tipo ---");

        for (Employee emp : employees) {
            if (emp instanceof GraphicDesigner) {
                GraphicDesigner gd = (GraphicDesigner) emp;
                System.out.println(gd.getName() + " - Especialidad: " + gd.getSpecialty()
                        + " - Proyectos: " + gd.getCompletedProjects());
            }
            else if (emp instanceof Illustrator) {
                Illustrator ill = (Illustrator) emp;
                System.out.println(ill.getName() + " - Estilo: " + ill.getIllustrationStyle()
                        + " - Nivel: " + ill.getCreativityLevel());
            }
            else if (emp instanceof FreelanceDesigner) {
                FreelanceDesigner fl = (FreelanceDesigner) emp;
                System.out.println(fl.getName() + " - Tarifa: $" + fl.getHourlyRate()
                        + "/hr - Días restantes: " + fl.getDaysRemaining());
            }
        }

        // ====== DEMOSTRACIÓN 10: ESTADÍSTICAS FINALES ======
        printSection("10. ESTADÍSTICAS FINALES");

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║         RESUMEN DE RECURSOS HUMANOS           ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        double avgSalary = totalPayroll / employees.length;
        Employee highestPaid = employees[0];
        Employee bestRated = employees[0];

        for (Employee emp : employees) {
            if (emp.calculateSalary() > highestPaid.calculateSalary()) {
                highestPaid = emp;
            }
            if (emp.getPerformanceRating() > bestRated.getPerformanceRating()) {
                bestRated = emp;
            }
        }

        System.out.println("\n📊 ESTADÍSTICAS:");
        System.out.println("Total de Empleados: " + employees.length);
        System.out.println("Nómina Total: $" + String.format("%,.2f", totalPayroll));
        System.out.println("Salario Promedio: $" + String.format("%,.2f", avgSalary));
        System.out.println("\n🏆 RECONOCIMIENTOS:");
        System.out.println("Mejor Pagado: " + highestPaid.getName()
                + " (" + highestPaid.getClass().getSimpleName() + ") - $"
                + String.format("%,.2f", highestPaid.calculateSalary()));
        System.out.println("Mejor Rating: " + bestRated.getName()
                + " - " + String.format("%.1f", bestRated.getPerformanceRating()) + "/5.0");

        System.out.println("\n📈 POR DEPARTAMENTO:");
        System.out.println("Diseño Gráfico: " + designerCount + " empleados");
        System.out.println("Ilustración: " + illustratorCount + " empleados");
        System.out.println("Freelance: " + freelanceCount + " empleados");

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
        System.out.println("║     Herencia y Polimorfismo demostrados        ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
    }
}