package co.edu.sena.DesignProject.semana3;

/**
 * Clase Main - Demostración de Encapsulación y Constructores
 * Semana 3: Encapsulación y Constructores
 */
public class Main {
    public static void main(String[] args) {
        printHeader("PIXEL CREATIVO - SEMANA 03");
        printHeader("Encapsulación y Constructores");

        try {
            // ====== DEMOSTRACIÓN 1: CONSTRUCTORES SOBRECARGADOS ======
            printSection("1. CONSTRUCTORES SOBRECARGADOS");

            System.out.println("\n--- CLIENTES (3 constructores diferentes) ---");

            // Constructor completo
            Client client1 = null;
            try {
                client1 = new Client("C001", "Juan Pérez", "juan.perez@email.com",
                        "3001234567", "Calle 45 #12-34, Bogotá");
                System.out.println("✓ Cliente 1 creado: " + client1);
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error al crear cliente 1: " + e.getMessage());
                // Crear con constructor básico como respaldo
                client1 = new Client("C001", "Juan Pérez", "juan.perez@email.com");
                System.out.println("✓ Cliente 1 creado con constructor básico: " + client1);
            }

            // Constructor básico
            Client client2 = new Client("C002", "María López", "maria.lopez@email.com");
            System.out.println("✓ Cliente 2 creado: " + client2);

            // Constructor mínimo
            Client client3 = new Client("Carlos Ruiz", "carlos.ruiz@email.com");
            System.out.println("✓ Cliente 3 creado: " + client3);

            System.out.println("\n--- PROYECTOS (3 constructores diferentes) ---");

            // Constructor completo
            DesignProject project1 = new DesignProject("P001", "Logo Design",
                    "Juan Pérez", 1200000, 10, false);

            // Constructor básico
            DesignProject project2 = new DesignProject("P002", "Web Design",
                    "María López", 2500000, 20);

            // Constructor mínimo
            DesignProject project3 = new DesignProject("Packaging Design",
                    "Carlos Ruiz", 1800000);

            System.out.println("✓ " + project1);
            System.out.println("✓ " + project2);
            System.out.println("✓ " + project3);

            System.out.println("\n--- DISEÑADORES (3 constructores diferentes) ---");

            // Constructor completo
            Designer designer1 = new Designer("D001", "Ana García", "Branding",
                    2500000, "ana.garcia@pixelcreativo.com");

            // Constructor básico
            Designer designer2 = new Designer("D002", "Pedro Martínez", "Web Design");

            // Constructor mínimo
            Designer designer3 = new Designer("Laura Sánchez", "Packaging");

            System.out.println("✓ " + designer1);
            System.out.println("✓ " + designer2);
            System.out.println("✓ " + designer3);

            // ====== DEMOSTRACIÓN 2: VALIDACIONES EN SETTERS ======
            printSection("2. VALIDACIONES EN SETTERS");

            System.out.println("\n--- Validación de Email ---");
            try {
                client1.setEmail("email_invalido");
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error capturado: " + e.getMessage());
            }

            client1.setEmail("nuevo.email@valid.com");
            System.out.println("✓ Email actualizado correctamente: " + client1.getEmail());

            System.out.println("\n--- Validación de Costo de Proyecto ---");
            try {
                project1.setProjectCost(50000); // Menor al mínimo
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error capturado: " + e.getMessage());
            }

            project1.setProjectCost(1500000);
            System.out.println("✓ Costo actualizado correctamente: $" + project1.getProjectCost());

            System.out.println("\n--- Validación de Días de Entrega ---");
            try {
                project2.setDeliveryDays(200); // Fuera de rango
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error capturado: " + e.getMessage());
            }

            project2.setDeliveryDays(5); // Urgente
            System.out.println("✓ Días actualizados: " + project2.getDeliveryDays());
            System.out.println("  Tarifa de urgencia: $" + project2.getUrgencyFee());

            System.out.println("\n--- Validación de Salario ---");
            try {
                designer1.setSalary(500000); // Menor al mínimo legal
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error capturado: " + e.getMessage());
            }

            designer1.increaseSalary(10); // Aumento del 10%

            // ====== DEMOSTRACIÓN 3: MATERIALES ======
            printSection("3. MATERIALES CON VALIDACIONES");

            Material material1 = new Material("M001", "Digital Assets", 50000, 100, 20, "TechSupply");
            Material material2 = new Material("Print Materials", 80000, 15); // Bajo stock

            material1.showMaterialInfo();
            System.out.println();
            material2.showMaterialInfo();

            System.out.println("\n--- Uso de Materiales ---");
            material1.useMaterial(30);
            material2.useMaterial(10); // Activará alerta de bajo stock

            System.out.println("\n--- Reabastecimiento ---");
            if (material2.needsRestock()) {
                int suggestion = material2.getRestockSuggestion();
                material2.restock(suggestion);
            }

            // ====== DEMOSTRACIÓN 4: FLUJO COMPLETO DE NEGOCIO ======
            printSection("4. FLUJO COMPLETO DE NEGOCIO");

            System.out.println("\n--- Información Inicial ---");
            client1.showClientInfo();
            System.out.println();
            project1.showProjectInfo();
            System.out.println();
            designer1.showDesignerInfo();

            System.out.println("\n--- Asignar y Ejecutar Proyecto ---");
            designer1.assignProject();
            project1.setApproved(true);
            client1.addProject(project1.calculateFinalCost());

            System.out.println("\n--- Completar Proyecto ---");
            designer1.completeProject(4.7); // Calificación 4.7/5.0
            project1.completeProject();

            System.out.println("\n--- Información Final ---");
            client1.showClientInfo();
            System.out.println();
            project1.showProjectInfo();
            System.out.println();
            designer1.showDesignerInfo();

            // ====== DEMOSTRACIÓN 5: MÚLTIPLES PROYECTOS ======
            printSection("5. GESTIÓN DE MÚLTIPLES PROYECTOS");

            System.out.println("\n--- Asignando múltiples proyectos a María ---");
            project2.setApproved(true);
            project3.setApproved(true);

            client2.addProject(project2.calculateFinalCost());
            client3.addProject(project3.calculateFinalCost());

            designer2.assignProject();
            designer3.assignProject();

            System.out.println("\n--- Completando proyectos ---");
            designer2.completeProject(4.9);
            designer3.completeProject(4.3);

            project2.completeProject();
            project3.completeProject();

            // ====== RESUMEN FINAL ======
            printSection("6. RESUMEN FINAL");

            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║           ESTADÍSTICAS FINALES                 ║");
            System.out.println("╚════════════════════════════════════════════════╝");

            System.out.println("\n--- CLIENTES ---");
            System.out.println(client1.getName() + " - Total invertido: $" +
                    String.format("%.2f", client1.getTotalSpent()) +
                    " - " + (client1.isFrequentClient() ? "FRECUENTE ⭐" : "Regular"));
            System.out.println(client2.getName() + " - Total invertido: $" +
                    String.format("%.2f", client2.getTotalSpent()) +
                    " - " + (client2.isFrequentClient() ? "FRECUENTE ⭐" : "Regular"));
            System.out.println(client3.getName() + " - Total invertido: $" +
                    String.format("%.2f", client3.getTotalSpent()) +
                    " - " + (client3.isFrequentClient() ? "FRECUENTE ⭐" : "Regular"));

            System.out.println("\n--- DISEÑADORES ---");
            System.out.println(designer1.getName() + " - Rating: " +
                    String.format("%.2f", designer1.getRating()) +
                    " - " + designer1.getPerformanceLevel());
            System.out.println(designer2.getName() + " - Rating: " +
                    String.format("%.2f", designer2.getRating()) +
                    " - " + designer2.getPerformanceLevel());
            System.out.println(designer3.getName() + " - Rating: " +
                    String.format("%.2f", designer3.getRating()) +
                    " - " + designer3.getPerformanceLevel());

            System.out.println("\n--- PROYECTOS ---");
            System.out.println(project1.getProjectCode() + " - " + project1.getStatus() +
                    " - $" + String.format("%.2f", project1.calculateFinalCost()));
            System.out.println(project2.getProjectCode() + " - " + project2.getStatus() +
                    " - $" + String.format("%.2f", project2.calculateFinalCost()));
            System.out.println(project3.getProjectCode() + " - " + project3.getStatus() +
                    " - $" + String.format("%.2f", project3.calculateFinalCost()));

            printFooter();

        } catch (Exception e) {
            System.err.println("\n✗ ERROR GENERAL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ====== Métodos Auxiliares para Formateo ======
    private static void printHeader(String title) {
        System.out.println("\n╔" + "═".repeat(title.length() + 2) + "╗");
        System.out.println("║ " + title + " ║");
        System.out.println("╚" + "═".repeat(title.length() + 2) + "╝");
    }

    private static void printSection(String section) {
        System.out.println("\n\n" + "═".repeat(50));
        System.out.println(section);
        System.out.println("═".repeat(50));
    }

    private static void printFooter() {
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║     Sistema completado exitosamente ✓          ║");
        System.out.println("║     Encapsulación y Constructores aplicados    ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
    }
}