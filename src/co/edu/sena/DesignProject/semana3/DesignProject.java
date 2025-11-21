package co.edu.sena.DesignProject.semana3;

/**
 * Clase DesignProject refactorizada con encapsulación completa
 * Semana 3: Encapsulación y Constructores
 */
public class DesignProject {
    // ====== Atributos PRIVATE ======
    private String projectCode;
    private String designType;
    private String clientName;
    private double projectCost;
    private int deliveryDays;
    private boolean approved;
    private String status;
    private double urgencyFee;

    // ====== Constantes ======
    private static final double URGENCY_MULTIPLIER = 1.10;
    private static final int MIN_DELIVERY_DAYS = 1;
    private static final int MAX_DELIVERY_DAYS = 180;
    private static final double MIN_PROJECT_COST = 100000.0;

    // ====== Constructor Completo ======
    public DesignProject(String projectCode, String designType, String clientName,
                         double projectCost, int deliveryDays, boolean approved) {
        setProjectCode(projectCode);
        setDesignType(designType);
        setClientName(clientName);
        setProjectCost(projectCost);
        setDeliveryDays(deliveryDays);
        this.approved = approved;
        this.status = "En Proceso";
        this.urgencyFee = 0.0;
    }

    // ====== Constructor Básico (sin aprobación) ======
    public DesignProject(String projectCode, String designType, String clientName,
                         double projectCost, int deliveryDays) {
        this(projectCode, designType, clientName, projectCost, deliveryDays, false);
    }

    // ====== Constructor Mínimo (valores por defecto) ======
    public DesignProject(String designType, String clientName, double projectCost) {
        this(generateProjectCode(), designType, clientName, projectCost, 14, false);
    }

    // ====== Getters ======
    public String getProjectCode() {
        return projectCode;
    }

    public String getDesignType() {
        return designType;
    }

    public String getClientName() {
        return clientName;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public int getDeliveryDays() {
        return deliveryDays;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getStatus() {
        return status;
    }

    public double getUrgencyFee() {
        return urgencyFee;
    }

    // ====== Setters CON VALIDACIONES ======
    public void setProjectCode(String projectCode) {
        if (!isValidProjectCode(projectCode)) {
            throw new IllegalArgumentException("Código de proyecto inválido. Debe tener al menos 3 caracteres.");
        }
        this.projectCode = projectCode;
    }

    public void setDesignType(String designType) {
        if (designType == null || designType.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de diseño no puede estar vacío");
        }
        if (!isValidDesignType(designType)) {
            throw new IllegalArgumentException("Tipo de diseño no válido. Opciones: Logo, Web, Packaging, Branding, Publicidad");
        }
        this.designType = designType.trim();
    }

    public void setClientName(String clientName) {
        if (clientName == null || clientName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        this.clientName = clientName.trim();
    }

    public void setProjectCost(double projectCost) {
        if (projectCost < MIN_PROJECT_COST) {
            throw new IllegalArgumentException("El costo mínimo del proyecto es $" + MIN_PROJECT_COST);
        }
        this.projectCost = projectCost;
    }

    public void setDeliveryDays(int deliveryDays) {
        if (deliveryDays < MIN_DELIVERY_DAYS || deliveryDays > MAX_DELIVERY_DAYS) {
            throw new IllegalArgumentException("Los días de entrega deben estar entre "
                    + MIN_DELIVERY_DAYS + " y " + MAX_DELIVERY_DAYS);
        }
        this.deliveryDays = deliveryDays;

        // Calcular tarifa de urgencia si es necesario
        if (deliveryDays <= 7) {
            this.urgencyFee = projectCost * 0.20; // 20% de recargo por urgencia
        } else if (deliveryDays <= 14) {
            this.urgencyFee = projectCost * 0.10; // 10% de recargo
        } else {
            this.urgencyFee = 0.0;
        }
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
        if (approved) {
            this.status = "Aprobado";
            System.out.println("✓ Proyecto " + projectCode + " APROBADO");
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status.trim();
        }
    }

    // ====== Métodos de Negocio ======
    public void showProjectInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      DESIGN PROJECT INFORMATION        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + projectCode);
        System.out.println("Type: " + designType);
        System.out.println("Client: " + clientName);
        System.out.println("Base Cost: $" + String.format("%.2f", projectCost));
        System.out.println("Urgency Fee: $" + String.format("%.2f", urgencyFee));
        System.out.println("Final Cost: $" + String.format("%.2f", calculateFinalCost()));
        System.out.println("Delivery Time: " + deliveryDays + " days");
        System.out.println("Status: " + status);
        System.out.println("Approved: " + (approved ? "YES ✓" : "NO ✗"));
    }

    public double calculateFinalCost() {
        double finalCost = projectCost + urgencyFee;

        // Si está aprobado, se aplica un 10% adicional
        if (approved) {
            finalCost *= URGENCY_MULTIPLIER;
        }

        return finalCost;
    }

    public void completeProject() {
        if (approved) {
            this.status = "Completado";
            System.out.println("✓ Proyecto " + projectCode + " COMPLETADO exitosamente");
        } else {
            System.out.println("✗ No se puede completar un proyecto sin aprobación");
        }
    }

    public void cancelProject() {
        this.status = "Cancelado";
        this.approved = false;
        System.out.println("✗ Proyecto " + projectCode + " CANCELADO");
    }

    public boolean isUrgent() {
        return deliveryDays <= 7;
    }

    // ====== Métodos Auxiliares PRIVADOS ======
    private boolean isValidProjectCode(String code) {
        return code != null && code.trim().length() >= 3;
    }

    private boolean isValidDesignType(String type) {
        String normalized = type.toLowerCase().trim();
        return normalized.contains("logo") ||
                normalized.contains("web") ||
                normalized.contains("packaging") ||
                normalized.contains("branding") ||
                normalized.contains("publicidad");
    }

    private static String generateProjectCode() {
        return "P" + String.format("%04d", (int)(Math.random() * 10000));
    }

    // ====== toString ======
    @Override
    public String toString() {
        return String.format("Project[%s - %s - $%.2f]", projectCode, designType, calculateFinalCost());
    }
}