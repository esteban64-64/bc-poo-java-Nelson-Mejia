package co.edu.sena.DesignProject.semana2;

import co.edu.sena.DesignProject.semana1.DesignProject;
import co.edu.sena.DesignProject.semana1.Client;
import co.edu.sena.DesignProject.semana2.AgencyManager;
import co.edu.sena.DesignProject.semana2.Designer;
import co.edu.sena.DesignProject.semana2.Material;
import co.edu.sena.DesignProject.semana2.ProjectAssignment;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   PIXEL CREATIVO - SEMANA 02                  ║");
        System.out.println("║   Sistema de Gestión con ArrayList            ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ====== CREAR GESTOR DE AGENCIA ======
        AgencyManager agency = new AgencyManager("Pixel Creativo");

        // ====== CREAR Y AGREGAR CLIENTES ======
        System.out.println("--- REGISTRANDO CLIENTES ---");
        Client client1 = new Client("C001", "Juan Pérez", "juanperez@email.com");
        Client client2 = new Client("C002", "María López", "marialopez@email.com");
        Client client3 = new Client("C003", "Carlos Ruiz", "carlos@email.com");

        agency.addClient(client1);
        agency.addClient(client2);
        agency.addClient(client3);

        // ====== CREAR Y AGREGAR PROYECTOS ======
        System.out.println("\n--- CREANDO PROYECTOS ---");
        DesignProject project1 = new DesignProject("P001", "Logo Design", "Juan Pérez", 1200000, 10);
        DesignProject project2 = new DesignProject("P002", "Web Design", "María López", 2500000, 20);
        DesignProject project3 = new DesignProject("P003", "Packaging Design", "Carlos Ruiz", 1800000, 15);

        agency.addProject(project1);
        agency.addProject(project2);
        agency.addProject(project3);

        // Aprobar proyectos
        project2.setApproved(true);
        project3.setApproved(true);

        // ====== CREAR Y AGREGAR DISEÑADORES ======
        System.out.println("\n--- REGISTRANDO DISEÑADORES ---");
        Designer designer1 = new Designer("D001", "Ana García", "Branding");
        Designer designer2 = new Designer("D002", "Pedro Martínez", "Web Design");
        Designer designer3 = new Designer("D003", "Laura Sánchez", "Packaging");

        agency.addDesigner(designer1);
        agency.addDesigner(designer2);
        agency.addDesigner(designer3);

        // ====== CREAR MATERIALES ======
        System.out.println("\n--- CREANDO MATERIALES ---");
        Material material1 = new Material("M001", "Digital Assets", 50000, 100);
        Material material2 = new Material("M002", "Print Materials", 80000, 50);
        Material material3 = new Material("M003", "Packaging Samples", 120000, 30);

        // ====== CREAR ASIGNACIONES (RELACIONES) ======
        System.out.println("\n--- ASIGNANDO PROYECTOS ---");
        ProjectAssignment assignment1 = new ProjectAssignment(project1, designer1, material1, "2025-11-01");
        ProjectAssignment assignment2 = new ProjectAssignment(project2, designer2, material1, "2025-11-05");
        ProjectAssignment assignment3 = new ProjectAssignment(project3, designer3, material3, "2025-11-10");

        agency.addAssignment(assignment1);
        agency.addAssignment(assignment2);
        agency.addAssignment(assignment3);

        // ====== COMPLETAR ASIGNACIONES ======
        System.out.println("\n--- COMPLETANDO PROYECTOS ---");
        assignment1.completeAssignment(4.5);
        assignment2.completeAssignment(4.8);
        assignment3.completeAssignment(4.2);

        // ====== ACTUALIZAR INFORMACIÓN DE CLIENTES ======
        System.out.println("\n--- ACTUALIZANDO CLIENTES ---");
        client1.addProject(project1.calculateFinalCost());
        client2.addProject(project2.calculateFinalCost());
        client3.addProject(project3.calculateFinalCost());

        // ====== MOSTRAR INFORMACIÓN USANDO ARRAYLISTS ======
        agency.showAllClients();
        agency.showAllProjects();
        agency.showAllDesigners();
        agency.showAllAssignments();

        // ====== ESTADÍSTICAS GENERALES ======
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           ESTADÍSTICAS GENERALES               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Total Clients: " + agency.countClients());
        System.out.println("Total Projects: " + agency.countProjects());
        System.out.println("Total Revenue: $" + agency.calculateTotalRevenue());

        Designer topDesigner = agency.findTopDesigner();
        if (topDesigner != null) {
            System.out.println("Top Designer: " + topDesigner.getName() +
                    " (Rating: " + topDesigner.getRating() + ")");
        }

        // ====== VERIFICAR CLIENTES FRECUENTES ======
        System.out.println("\n--- ANÁLISIS DE CLIENTES ---");
        System.out.println("¿" + client1.getName() + " es cliente frecuente?: " +
                (client1.isFrequentClient() ? "Sí" : "No"));
        System.out.println("¿" + client2.getName() + " es cliente frecuente?: " +
                (client2.isFrequentClient() ? "Sí" : "No"));
        System.out.println("¿" + client3.getName() + " es cliente frecuente?: " +
                (client3.isFrequentClient() ? "Sí" : "No"));

        System.out.println("\n════════════════════════════════════════════════");
        System.out.println("     Sistema completado exitosamente ✓");
        System.out.println("════════════════════════════════════════════════\n");
    }
}
