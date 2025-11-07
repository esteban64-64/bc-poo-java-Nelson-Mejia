package co.edu.sena.DesignProject;
public class DesignProject {
    // ====== Atributos ======
    private String projectCode;      // Código del proyecto
    private String designType;       // Tipo de diseño (logo, web, packaging, etc.)
    private String client;           // Cliente asociado
    private double projectCost;      // Costo del proyecto
    private int deliveryDays;        // Días estimados de entrega
    private boolean approved;        // Estado de aprobación del cliente

    // ====== Constructor ======
    public DesignProject(String code, String type, String client, double cost, int days) {
        this.projectCode = code;
        this.designType = type;
        this.client = client;
        this.projectCost = cost;
        this.deliveryDays = days;
        this.approved = false; // Por defecto el proyecto no está aprobado
    }

    // ====== Método void (imprime información) ======
    public void showProjectInfo() {
        System.out.println("=== DESIGN PROJECT ===");
        System.out.println("Code: " + projectCode);
        System.out.println("Type: " + designType);
        System.out.println("Client: " + client);
        System.out.println("Cost: $" + projectCost);
        System.out.println("Delivery Time: " + deliveryDays + " days");
        System.out.println("Approved: " + (approved ? "YES" : "NO"));
    }

    // ====== Método que retorna un valor calculado ======
    public double calculateFinalCost() {
        // Si el proyecto está aprobado, se aplica un 10% adicional por urgencia
        if (approved) {
            return projectCost * 1.10;
        } else {
            return projectCost;
        }
    }

    // ====== Getter ======
    public String getProjectCode() {
        return projectCode;
    }

    // ====== Setter ======
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
