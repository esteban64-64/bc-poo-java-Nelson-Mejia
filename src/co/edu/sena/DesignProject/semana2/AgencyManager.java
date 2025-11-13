package co.edu.sena.DesignProject.semana2;

import java.util.ArrayList;

// IMPORTS QUE FALTAN
import co.edu.sena.DesignProject.semana1.Client;
import co.edu.sena.DesignProject.semana1.DesignProject;

import java.util.ArrayList;
public class AgencyManager {
    // ====== Atributos ======
    private String agencyName;
    private ArrayList<Client> clients;
    private ArrayList<DesignProject> projects;
    private ArrayList<Designer> designers;
    private ArrayList<ProjectAssignment> assignments;

    // ====== Constructor ======
    public AgencyManager(String agencyName) {
        this.agencyName = agencyName;
        this.clients = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.designers = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // ====== Métodos para Clientes ======
    public void addClient(Client client) {
        clients.add(client);
        System.out.println("Client added: " + client.getName());
    }

    public void showAllClients() {
        System.out.println("\n=== ALL CLIENTS ===");
        for (Client client : clients) {
            client.showClientInfo();
            System.out.println();
        }
    }

    public int countClients() {
        return clients.size();
    }

    // ====== Métodos para Proyectos ======
    public void addProject(DesignProject project) {
        projects.add(project);
        System.out.println("Project added: " + project.getProjectCode());
    }

    public void showAllProjects() {
        System.out.println("\n=== ALL PROJECTS ===");
        for (DesignProject project : projects) {
            project.showProjectInfo();
            System.out.println();
        }
    }

    public int countProjects() {
        return projects.size();
    }

    // ====== Métodos para Diseñadores ======
    public void addDesigner(Designer designer) {
        designers.add(designer);
        System.out.println("Designer added: " + designer.getName());
    }

    public void showAllDesigners() {
        System.out.println("\n=== ALL DESIGNERS ===");
        for (Designer designer : designers) {
            designer.showDesignerInfo();
            System.out.println();
        }
    }

    // ====== Métodos para Asignaciones ======
    public void addAssignment(ProjectAssignment assignment) {
        assignments.add(assignment);
        System.out.println("Assignment created successfully");
    }

    public void showAllAssignments() {
        System.out.println("\n=== ALL ASSIGNMENTS ===");
        for (ProjectAssignment assignment : assignments) {
            assignment.showAssignmentSummary();
            System.out.println();
        }
    }

    // ====== Método de negocio: Calcular ingresos totales ======
    public double calculateTotalRevenue() {
        double total = 0;
        for (Client client : clients) {
            total += client.getTotalSpent();
        }
        return total;
    }

    // ====== Método de negocio: Encontrar mejor diseñador ======
    public Designer findTopDesigner() {
        Designer topDesigner = null;
        double highestRating = 0;

        for (Designer designer : designers) {
            if (designer.getRating() > highestRating) {
                highestRating = designer.getRating();
                topDesigner = designer;
            }
        }
        return topDesigner;
    }

    // ====== Getter ======
    public String getAgencyName() {
        return agencyName;
    }
}
