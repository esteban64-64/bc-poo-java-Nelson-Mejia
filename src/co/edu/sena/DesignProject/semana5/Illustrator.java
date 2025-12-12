package co.edu.sena.DesignProject.semana5;

import co.edu.sena.DesignProject.semana4.Employee;

/**
 * Subclase 2: Illustrator (Ilustrador Especializado)
 * Hereda de Employee
 * Semana 4: Herencia
 */
public class Illustrator extends Employee {
    // ====== Atributos Específicos ======
    private String illustrationStyle; // Digital, Traditional, 3D, Character Design
    private int portfolioPieces;
    private boolean hasTablet;
    private double creativityScore; // 0.0 - 10.0
    private int commissionsCompleted;

    // ====== Constantes ======
    private static final double CREATIVITY_BONUS_RATE = 100000.0; // Por punto de creatividad
    private static final double COMMISSION_BONUS = 75000.0; // Por comisión
    private static final double EQUIPMENT_BONUS = 200000.0; // Si tiene tablet profesional

    // ====== Constructor Completo ======
    public Illustrator(String employeeCode, String name, String email,
                       double baseSalary, int yearsOfExperience,
                       String illustrationStyle, boolean hasTablet) {
        super(employeeCode, name, email, baseSalary, "Ilustración", yearsOfExperience);
        this.illustrationStyle = illustrationStyle;
        this.hasTablet = hasTablet;
        this.portfolioPieces = 0;
        this.creativityScore = 5.0; // Creatividad por defecto
        this.commissionsCompleted = 0;
    }

    // ====== Constructor Básico ======
    public Illustrator(String name, String email, double baseSalary, String illustrationStyle) {
        super(name, email, baseSalary);
        this.department = "Ilustración";
        this.illustrationStyle = illustrationStyle;
        this.hasTablet = false;
        this.portfolioPieces = 0;
        this.creativityScore = 5.0;
        this.commissionsCompleted = 0;
    }

    // ====== Método Sobrescrito: Información ======
    @Override
    public void showEmployeeInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      ILLUSTRATOR INFORMATION           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + employeeCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Illustration Style: " + illustrationStyle);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Portfolio Pieces: " + portfolioPieces);
        System.out.println("Commissions Completed: " + commissionsCompleted);
        System.out.println("Creativity Score: " + String.format("%.1f", creativityScore) + "/10.0");
        System.out.println("Has Professional Tablet: " + (hasTablet ? "YES ✓" : "NO ✗"));
        System.out.println("Performance Rating: " + String.format("%.1f", performanceRating) + "/5.0");
        System.out.println("Base Salary: $" + String.format("%.2f", baseSalary));
        System.out.println("Total Salary: $" + String.format("%.2f", calculateSalary()));
    }

    // ====== Método Sobrescrito: Calcular Salario ======
    @Override
    public double calculateSalary() {
        // Salario base + bono por desempeño (de la clase padre)
        double totalSalary = super.calculateSalary();

        // Bono por creatividad: $100,000 por cada punto de creatividad
        double creativityBonus = creativityScore * CREATIVITY_BONUS_RATE;

        // Bono por comisiones completadas
        double commissionBonus = commissionsCompleted * COMMISSION_BONUS;

        // Bono por experiencia: 5% por año (mayor que diseñadores)
        double experienceBonus = baseSalary * 0.05 * yearsOfExperience;

        // Bono por equipo profesional
        double equipmentBonus = hasTablet ? EQUIPMENT_BONUS : 0;

        // Bono por portfolio extenso (más de 50 piezas)
        double portfolioBonus = portfolioPieces > 50 ? (baseSalary * 0.10) : 0;

        return totalSalary + creativityBonus + commissionBonus +
                experienceBonus + equipmentBonus + portfolioBonus;
    }

    // ====== Métodos Específicos ======

    /**
     * Completa una comisión
     */
    public void completeCommission(double creativityRating) {
        commissionsCompleted++;

        // Actualizar promedio de creatividad
        if (commissionsCompleted == 1) {
            creativityScore = creativityRating;
        } else {
            creativityScore = ((creativityScore * (commissionsCompleted - 1)) + creativityRating)
                    / commissionsCompleted;
        }

        System.out.println("✓ Comisión completada por " + name);
        System.out.println("  Total comisiones: " + commissionsCompleted);
        System.out.println("  Calificación de creatividad: " + String.format("%.1f", creativityRating));
        System.out.println("  Score promedio: " + String.format("%.1f", creativityScore) + "/10.0");
    }

    /**
     * Agrega una pieza al portfolio
     */
    public void addToPortfolio(String pieceName) {
        portfolioPieces++;
        System.out.println("✓ Pieza agregada al portfolio: " + pieceName);
        System.out.println("  Total piezas: " + portfolioPieces);

        if (portfolioPieces == 50) {
            System.out.println("🎨 ¡Portfolio excepcional alcanzado! Bono desbloqueado.");
        }
    }

    /**
     * Actualiza el equipo (compra de tablet)
     */
    public void upgradeEquipment() {
        if (!hasTablet) {
            hasTablet = true;
            System.out.println("✓ Tablet profesional adquirida para " + name);
            System.out.println("  Bono mensual agregado: $" + String.format("%.2f", EQUIPMENT_BONUS));
        } else {
            System.out.println("✓ " + name + " ya cuenta con tablet profesional");
        }
    }

    /**
     * Cambia el estilo de ilustración
     */
    public void changeStyle(String newStyle) {
        String oldStyle = this.illustrationStyle;
        this.illustrationStyle = newStyle;
        System.out.println("✓ Estilo de ilustración actualizado: " + oldStyle + " → " + newStyle);
    }

    /**
     * Obtiene el nivel de creatividad
     */
    public String getCreativityLevel() {
        if (creativityScore >= 9.0) return "EXCEPCIONAL ⭐⭐⭐";
        if (creativityScore >= 7.5) return "EXCELENTE ⭐⭐";
        if (creativityScore >= 6.0) return "MUY BUENO ⭐";
        if (creativityScore >= 4.5) return "BUENO";
        return "EN DESARROLLO";
    }

    /**
     * Verifica si es ilustrador maestro (más de 100 comisiones y creatividad alta)
     */
    public boolean isMasterIllustrator() {
        return commissionsCompleted >= 100 && creativityScore >= 8.5;
    }

    // ====== Getters Específicos ======
    public String getIllustrationStyle() {
        return illustrationStyle;
    }

    public int getPortfolioPieces() {
        return portfolioPieces;
    }

    public boolean hasTablet() {
        return hasTablet;
    }

    public double getCreativityScore() {
        return creativityScore;
    }

    public int getCommissionsCompleted() {
        return commissionsCompleted;
    }

    // ====== toString Sobrescrito ======
    @Override
    public String toString() {
        return String.format("Illustrator[%s - %s - %s - %d comisiones - $%.2f]",
                employeeCode, name, illustrationStyle, commissionsCompleted, calculateSalary());
    }
}