package co.edu.sena.DesignProject;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN - PIXEL CREATIVO ===\n");

        // ====== CREACIÓN DE CLIENTES ======
        Client client1 = new Client("C001", "Juan Pérez", "juanperez@email.com");
        Client client2 = new Client("C002", "María López", "marialopez@email.com");

        System.out.println("--- CLIENTES REGISTRADOS ---");
        client1.showClientInfo();
        System.out.println();
        client2.showClientInfo();

        // ====== CREACIÓN DE PROYECTOS ======
        DesignProject project1 = new DesignProject("P001", "Logo Design", "Juan Pérez", 1200000, 10);
        DesignProject project2 = new DesignProject("P002", "Web Design", "María López", 2500000, 20);

        System.out.println("\n--- PROYECTOS CREADOS ---");
        project1.showProjectInfo();
        System.out.println();
        project2.showProjectInfo();

        // ====== DEMOSTRAR FUNCIONALIDAD ======
        System.out.println("\n--- CALCULAR COSTOS ---");
        System.out.println("Costo final del proyecto 1: $" + project1.calculateFinalCost());
        System.out.println("Costo final del proyecto 2: $" + project2.calculateFinalCost());

        // Aprobar el segundo proyecto y recalcular
        project2.setApproved(true);
        System.out.println("\n--- DESPUÉS DE APROBAR PROYECTO 2 ---");
        project2.showProjectInfo();
        System.out.println("Costo final del proyecto 2 (con incremento): $" + project2.calculateFinalCost());

        // ====== ACTUALIZAR INFORMACIÓN DE CLIENTES ======
        client1.addProject(project1.calculateFinalCost());
        client2.addProject(project2.calculateFinalCost());

        System.out.println("\n--- CLIENTES ACTUALIZADOS ---");
        client1.showClientInfo();
        System.out.println();
        client2.showClientInfo();

        // Verificar si son clientes frecuentes
        System.out.println("\n¿" + client1.getName() + " es cliente frecuente?: " + (client1.isFrequentClient() ? "Sí" : "No"));
        System.out.println("¿" + client2.getName() + " es cliente frecuente?: " + (client2.isFrequentClient() ? "Sí" : "No"));
    }
}
