 package co.edu.sena.DesignProject.semana5;

import co.edu.sena.DesignProject.semana4.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Subclase 3: FreelanceDesigner (Diseñador Freelance)
 * Hereda de Employee
 * Semana 4: Herencia
 */
public class FreelanceDesigner extends Employee {
    // ====== Atributos Específicos ======
    private int contractMonths;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private double hourlyRate;
    private int hoursWorked;
    private boolean isRenewable;
    private int projectsDelivered;

    // ====== Constantes ======
    private static final double MIN_HOURLY_RATE = 15000.0;
    private static final double ON_TIME_BONUS = 300000.0;
    private static final int HOURS_PER_MONTH = 160;

    // ====== Constructor Completo ======
    public FreelanceDesigner(String employeeCode, String name, String email,
                             double hourlyRate, int contractMonths,
                             LocalDate startDate, boolean isRenewable) {
        super(employeeCode, name, email, hourlyRate * HOURS_PER_MONTH, "Freelance", 0);
        this.hourlyRate = Math.max(hourlyRate, MIN_HOURLY_RATE);
        this.contractMonths = contractMonths;
        this.contractStartDate = startDate;
        this.contractEndDate = startDate.plusMonths(contractMonths);
        this.isRenewable = isRenewable;
        this.hoursWorked = 0;
        this.projectsDelivered = 0;

        // El salario base se calcula de forma diferente para freelancers
        this.baseSalary = this.hourlyRate * HOURS_PER_MONTH;
    }

    // ====== Constructor Básico ======
    public FreelanceDesigner(String name, String email, double hourlyRate, int contractMonths) {
        this(generateEmployeeCode(name), name, email, hourlyRate,
                contractMonths, LocalDate.now(), false);
    }

    // ====== Método Sobrescrito: Información ======
    @Override
    public void showEmployeeInfo() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    FREELANCE DESIGNER INFORMATION      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Code: " + employeeCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Contract Type: FREELANCE");
        System.out.println("Contract Duration: " + contractMonths + " months");
        System.out.println("Start Date: " + contractStartDate);
        System.out.println("End Date: " + contractEndDate);
        System.out.println("Days Remaining: " + getDaysRemaining());
        System.out.println("Renewable: " + (isRenewable ? "YES ✓" : "NO ✗"));
        System.out.println("Hourly Rate: $" + String.format("%.2f", hourlyRate));
        System.out.println("Hours Worked This Month: " + hoursWorked);
        System.out.println("Projects Delivered: " + projectsDelivered);
        System.out.println("Performance Rating: " + String.format("%.1f", performanceRating) + "/5.0");
        System.out.println("Estimated Monthly Salary: $" + String.format("%.2f", calculateSalary()));
    }

    // ====== Método Sobrescrito: Calcular Salario ======
    @Override
    public double calculateSalary() {
        // Para freelancers, el salario NO incluye el bono de desempeño de Employee
        // Se calcula basado en horas trabajadas

        double monthlySalary = hourlyRate * hoursWorked;

        // Bono por proyectos entregados a tiempo (si rating es bueno)
        double onTimeBonus = 0;
        if (performanceRating >= 4.0 && projectsDelivered >= 3) {
            onTimeBonus = ON_TIME_BONUS;
        }

        // Bono por renovación de contrato
        double renewalBonus = isRenewable ? (monthlySalary * 0.05) : 0;

        // Penalización si no cumple horas mínimas (menos de 120 horas)
        double penalty = 0;
        if (hoursWorked < 120) {
            penalty = monthlySalary * 0.10;
        }

        return monthlySalary + onTimeBonus + renewalBonus - penalty;
    }

    // ====== Métodos Específicos ======

    /**
     * Registra horas trabajadas
     */
    public void logHours(int hours) {
        if (hours <= 0 || hours > 24) {
            throw new IllegalArgumentException("Las horas deben estar entre 1 y 24");
        }

        hoursWorked += hours;
        System.out.println("✓ " + hours + " horas registradas para " + name);
        System.out.println("  Total del mes: " + hoursWorked + " horas");
        System.out.println("  Pago estimado: $" + String.format("%.2f", hourlyRate * hoursWorked));
    }

    /**
     * Entrega un proyecto
     */
    public void deliverProject(boolean onTime) {
        projectsDelivered++;

        if (onTime) {
            System.out.println("✓ Proyecto entregado A TIEMPO por " + name);
            // Mejora el rating si entrega a tiempo
            if (performanceRating < 5.0) {
                performanceRating = Math.min(5.0, performanceRating + 0.1);
            }
        } else {
            System.out.println("⚠️ Proyecto entregado TARDE por " + name);
            // Reduce el rating si entrega tarde
            performanceRating = Math.max(1.0, performanceRating - 0.2);
        }

        System.out.println("  Total proyectos: " + projectsDelivered);
        System.out.println("  Rating actual: " + String.format("%.1f", performanceRating));
    }

    /**
     * Renueva el contrato
     */
    public void renewContract(int additionalMonths) {
        if (!isRenewable) {
            System.out.println("✗ Este contrato no es renovable");
            return;
        }

        contractEndDate = contractEndDate.plusMonths(additionalMonths);
        contractMonths += additionalMonths;

        System.out.println("✓ Contrato renovado para " + name);
        System.out.println("  Meses adicionales: " + additionalMonths);
        System.out.println("  Nueva fecha de término: " + contractEndDate);
    }

    /**
     * Calcula días restantes de contrato
     */
    public long getDaysRemaining() {
        LocalDate now = LocalDate.now();
        if (now.isAfter(contractEndDate)) {
            return 0;
        }
        return ChronoUnit.DAYS.between(now, contractEndDate);
    }

    /**
     * Verifica si el contrato está por vencer (menos de 30 días)
     */
    public boolean isContractExpiringSoon() {
        return getDaysRemaining() > 0 && getDaysRemaining() <= 30;
    }

    /**
     * Verifica si el contrato ya expiró
     */
    public boolean isContractExpired() {
        return LocalDate.now().isAfter(contractEndDate);
    }

    /**
     * Aumenta la tarifa por hora
     */
    public void increaseHourlyRate(double percentage) {
        if (percentage <= 0 || percentage > 50) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 50");
        }

        double oldRate = hourlyRate;
        hourlyRate += hourlyRate * (percentage / 100);
        baseSalary = hourlyRate * HOURS_PER_MONTH;

        System.out.println("✓ Tarifa por hora incrementada para " + name);
        System.out.println("  Tarifa anterior: $" + String.format("%.2f", oldRate));
        System.out.println("  Nueva tarifa: $" + String.format("%.2f", hourlyRate));
    }

    /**
     * Resetea horas del mes (llamar al inicio de cada mes)
     */
    public void resetMonthlyHours() {
        System.out.println("📊 Resumen mensual para " + name);
        System.out.println("  Horas trabajadas: " + hoursWorked);
        System.out.println("  Pago total: $" + String.format("%.2f", calculateSalary()));

        hoursWorked = 0;
        System.out.println("✓ Horas reseteadas para nuevo mes");
    }

    // ====== Getters Específicos ======
    public int getContractMonths() {
        return contractMonths;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public boolean isRenewable() {
        return isRenewable;
    }

    public int getProjectsDelivered() {
        return projectsDelivered;
    }

    // ====== Setters ======
    public void setRenewable(boolean renewable) {
        this.isRenewable = renewable;
        System.out.println("✓ Estado de renovación actualizado: " + (renewable ? "RENOVABLE" : "NO RENOVABLE"));
    }

    // ====== toString Sobrescrito ======
    @Override
    public String toString() {
        return String.format("FreelanceDesigner[%s - %s - $%.2f/hr - %d días restantes]",
                employeeCode, name, hourlyRate, getDaysRemaining());
    }
}