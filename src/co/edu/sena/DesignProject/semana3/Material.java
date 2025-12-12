package co.edu.sena.DesignProject.semana3;

/**
 * Clase Material refactorizada con encapsulación completa
 * Semana 3: Encapsulación y Constructores
 */
public class Material {
    // ====== Atributos PRIVATE ======
    private String materialCode;
    private String materialType;
    private double unitCost;
    private int quantity;
    private int minStockLevel;
    private String supplier;

    // ====== Constantes ======
    private static final int DEFAULT_MIN_STOCK = 10;
    private static final double MIN_UNIT_COST = 0.0;
    private static final int MIN_QUANTITY = 0;

    // ====== Constructor Completo ======
    public Material(String materialCode, String materialType, double unitCost,
                    int quantity, int minStockLevel, String supplier) {
        setMaterialCode(materialCode);
        setMaterialType(materialType);
        setUnitCost(unitCost);
        setQuantity(quantity);
        setMinStockLevel(minStockLevel);
        setSupplier(supplier);
    }

    // ====== Constructor Básico (sin mínimo ni proveedor) ======
    public Material(String materialCode, String materialType, double unitCost, int quantity) {
        this(materialCode, materialType, unitCost, quantity, DEFAULT_MIN_STOCK, "Proveedor General");
    }

    // ====== Constructor Mínimo (código auto-generado) ======
    public Material(String materialType, double unitCost, int quantity) {
        this(generateMaterialCode(materialType), materialType, unitCost, quantity);
    }

    // ====== Getters ======
    public String getMaterialCode() {
        return materialCode;
    }

    public String getMaterialType() {
        return materialType;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinStockLevel() {
        return minStockLevel;
    }

    public String getSupplier() {
        return supplier;
    }

    // ====== Setters CON VALIDACIONES ======
    public void setMaterialCode(String materialCode) {
        if (!isValidCode(materialCode)) {
            throw new IllegalArgumentException("Código de material inválido. Debe tener al menos 3 caracteres.");
        }
        this.materialCode = materialCode;
    }

    public void setMaterialType(String materialType) {
        if (materialType == null || materialType.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de material no puede estar vacío");
        }
        if (!isValidMaterialType(materialType)) {
            throw new IllegalArgumentException("Tipo de material no válido. Opciones: Digital, Print, Packaging, Illustration");
        }
        this.materialType = materialType.trim();
    }

    public void setUnitCost(double unitCost) {
        if (unitCost < MIN_UNIT_COST) {
            throw new IllegalArgumentException("El costo unitario no puede ser negativo");
        }
        this.unitCost = unitCost;
    }

    public void setQuantity(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.quantity = quantity;

        // Verificar nivel de stock
        checkStockLevel();
    }

    public void setMinStockLevel(int minStockLevel) {
        if (minStockLevel < 0) {
            throw new IllegalArgumentException("El nivel mínimo de stock no puede ser negativo");
        }
        this.minStockLevel = minStockLevel;

        // Verificar nivel de stock después de actualizar el mínimo
        checkStockLevel();
    }

    public void setSupplier(String supplier) {
        if (supplier == null || supplier.trim().isEmpty()) {
            this.supplier = "Proveedor General";
        } else {
            this.supplier = supplier.trim();
        }
    }

    // ====== Métodos de Negocio ======
    public void showMaterialInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      MATERIAL INFORMATION              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + materialCode);
        System.out.println("Type: " + materialType);
        System.out.println("Supplier: " + supplier);
        System.out.println("Unit Cost: $" + String.format("%.2f", unitCost));
        System.out.println("Available Quantity: " + quantity + " units");
        System.out.println("Min Stock Level: " + minStockLevel + " units");
        System.out.println("Stock Status: " + getStockStatus());
    }

    public double calculateTotalCost(int requestedQuantity) {
        if (requestedQuantity <= 0) {
            throw new IllegalArgumentException("La cantidad solicitada debe ser positiva");
        }

        if (requestedQuantity > quantity) {
            throw new IllegalStateException("Stock insuficiente. Disponible: " + quantity + ", Solicitado: " + requestedQuantity);
        }

        return unitCost * requestedQuantity;
    }

    public boolean useMaterial(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad a usar debe ser positiva");
        }

        if (amount > quantity) {
            System.out.println("✗ Stock insuficiente de " + materialType);
            System.out.println("  Disponible: " + quantity + " | Solicitado: " + amount);
            return false;
        }

        quantity -= amount;
        System.out.println("✓ " + amount + " unidades de " + materialType + " utilizadas");
        System.out.println("  Stock restante: " + quantity);

        checkStockLevel();
        return true;
    }

    public void restock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad a reabastecer debe ser positiva");
        }

        int previousQuantity = quantity;
        quantity += amount;

        System.out.println("✓ Reabastecimiento exitoso");
        System.out.println("  Material: " + materialType);
        System.out.println("  Cantidad anterior: " + previousQuantity);
        System.out.println("  Cantidad agregada: " + amount);
        System.out.println("  Nueva cantidad: " + quantity);
    }

    public boolean needsRestock() {
        return quantity <= minStockLevel;
    }

    public int getRestockSuggestion() {
        if (needsRestock()) {
            return (minStockLevel * 3) - quantity; // Sugerencia: llevar a 3x el mínimo
        }
        return 0;
    }

    public String getStockStatus() {
        if (quantity == 0) {
            return "SIN STOCK ⚠️";
        } else if (needsRestock()) {
            return "BAJO STOCK ⚠️ (Reabastecer: " + getRestockSuggestion() + " unidades)";
        } else if (quantity < minStockLevel * 2) {
            return "STOCK MODERADO ⚡";
        } else {
            return "STOCK SUFICIENTE ✓";
        }
    }

    public void applyDiscount(double percentage) {
        if (percentage <= 0 || percentage > 50) {
            throw new IllegalArgumentException("El descuento debe estar entre 0% y 50%");
        }

        double previousCost = unitCost;
        unitCost -= unitCost * (percentage / 100);

        System.out.println("✓ Descuento del " + percentage + "% aplicado");
        System.out.println("  Costo anterior: $" + String.format("%.2f", previousCost));
        System.out.println("  Nuevo costo: $" + String.format("%.2f", unitCost));
    }

    // ====== Métodos Auxiliares PRIVADOS ======
    private boolean isValidCode(String code) {
        return code != null && code.trim().length() >= 3;
    }

    private boolean isValidMaterialType(String type) {
        String normalized = type.toLowerCase().trim();
        return normalized.contains("digital") ||
                normalized.contains("print") ||
                normalized.contains("packaging") ||
                normalized.contains("illustr");
    }

    private void checkStockLevel() {
        if (needsRestock()) {
            System.out.println("⚠️ ALERTA: " + materialType + " necesita reabastecimiento");
            System.out.println("  Stock actual: " + quantity + " | Mínimo: " + minStockLevel);
        }
    }

    private static String generateMaterialCode(String type) {
        if (type == null || type.length() < 2) {
            return "M000";
        }
        String prefix = type.substring(0, Math.min(2, type.length())).toUpperCase();
        int random = (int) (Math.random() * 1000);
        return "M" + prefix + String.format("%03d", random);
    }

    // ====== toString ======
    @Override
    public String toString() {
        return String.format("Material[%s - %s - %d units - $%.2f]",
                materialCode, materialType, quantity, unitCost);
    }
} // fin

