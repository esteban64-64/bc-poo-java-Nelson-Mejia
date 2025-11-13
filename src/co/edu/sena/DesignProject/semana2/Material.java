package co.edu.sena.DesignProject.semana2;

public class Material {
    // ====== Atributos ======
    private String materialCode;     // Código del material
    private String materialType;     // Tipo (digital, impreso, packaging)
    private double unitCost;         // Costo por unidad
    private int quantity;            // Cantidad disponible

    // ====== Constructor ======
    public Material(String code, String type, double cost, int quantity) {
        this.materialCode = code;
        this.materialType = type;
        this.unitCost = cost;
        this.quantity = quantity;
    }

    // ====== Método 1: Mostrar información ======
    public void showMaterialInfo() {
        System.out.println("=== MATERIAL INFORMATION ===");
        System.out.println("Code: " + materialCode);
        System.out.println("Type: " + materialType);
        System.out.println("Unit Cost: $" + unitCost);
        System.out.println("Available Quantity: " + quantity);
    }

    // ====== Método de negocio: Calcular costo total ======
    public double calculateTotalCost(int requestedQuantity) {
        if (requestedQuantity <= quantity) {
            return unitCost * requestedQuantity;
        } else {
            System.out.println("Insufficient quantity available!");
            return 0.0;
        }
    }

    // ====== Método de negocio: Usar material ======
    public boolean useMaterial(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            System.out.println(amount + " units of " + materialType + " used. Remaining: " + quantity);
            return true;
        } else {
            System.out.println("Not enough " + materialType + " in stock!");
            return false;
        }
    }

    // ====== Método de negocio: Reabastecer ======
    public void restock(int amount) {
        quantity += amount;
        System.out.println("Restocked " + amount + " units. New quantity: " + quantity);
    }

    // ====== Getters ======
    public String getMaterialType() {
        return materialType;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    // ====== Setters ======
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
}