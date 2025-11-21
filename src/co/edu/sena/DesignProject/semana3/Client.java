package co.edu.sena.DesignProject.semana3;

import java.util.regex.Pattern;

/**
 * Clase Client refactorizada con encapsulación completa
 * Semana 3: Encapsulación y Constructores
 */
public class Client {
    // ====== Atributos PRIVATE ======
    private String clientCode;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int activeProjects;
    private double totalSpent;

    // ====== Constantes ======
    private static final double FREQUENT_CLIENT_THRESHOLD = 2000000.0;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    // ====== Constructor Completo ======
    public Client(String clientCode, String name, String email, String phone, String address) {
        setClientCode(clientCode);
        setName(name);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
        this.activeProjects = 0;
        this.totalSpent = 0.0;
    }

    // ====== Constructor Básico (llama al completo) ======
    public Client(String clientCode, String name, String email) {
        this(clientCode, name, email, "Sin teléfono", "Sin dirección");
    }

    // ====== Constructor Mínimo ======
    public Client(String name, String email) {
        this(generateClientCode(name), name, email);
    }

    // ====== Getters (todos los atributos) ======
    public String getClientCode() {
        return clientCode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    // ====== Setters CON VALIDACIONES ======
    public void setClientCode(String clientCode) {
        if (!isValidCode(clientCode)) {
            throw new IllegalArgumentException("Código de cliente inválido. Debe tener al menos 3 caracteres.");
        }
        this.clientCode = clientCode;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido. Debe contener @ y un formato válido");
        }
        this.email = email.toLowerCase().trim();
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty() || phone.equalsIgnoreCase("sin teléfono")) {
            this.phone = "Sin teléfono";
        } else {
            String cleanPhone = phone.replaceAll("[^0-9]", "");
            if (cleanPhone.length() >= 7 && cleanPhone.length() <= 15) {
                this.phone = phone.trim();
            } else {
                throw new IllegalArgumentException("Teléfono debe tener entre 7 y 15 dígitos. Recibido: " + cleanPhone.length() + " dígitos");
            }
        }
    }

    public void setAddress(String address) {
        this.address = (address == null || address.trim().isEmpty()) ? "Sin dirección" : address.trim();
    }

    // ====== Métodos de Negocio ======
    public void showClientInfo() {
        System.out.println("=== CLIENT INFORMATION ===");
        System.out.println("Code: " + clientCode);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Active Projects: " + activeProjects);
        System.out.println("Total Spent: $" + String.format("%.2f", totalSpent));
        System.out.println("Status: " + (isFrequentClient() ? "FREQUENT CLIENT ⭐" : "Regular Client"));
    }

    public void addProject(double projectCost) {
        if (projectCost <= 0) {
            throw new IllegalArgumentException("El costo del proyecto debe ser positivo");
        }
        activeProjects++;
        totalSpent += projectCost;
        System.out.println("Proyecto agregado. Total invertido: $" + String.format("%.2f", totalSpent));
    }

    public boolean isFrequentClient() {
        return totalSpent >= FREQUENT_CLIENT_THRESHOLD;
    }

    public void completeProject() {
        if (activeProjects > 0) {
            activeProjects--;
            System.out.println("Proyecto completado. Proyectos activos: " + activeProjects);
        } else {
            System.out.println("No hay proyectos activos para completar");
        }
    }

    // ====== Métodos Auxiliares PRIVADOS ======
    private boolean isValidCode(String code) {
        return code != null && code.trim().length() >= 3;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static String generateClientCode(String name) {
        if (name == null || name.length() < 3) {
            return "C000";
        }
        String prefix = name.substring(0, Math.min(3, name.length())).toUpperCase();
        int random = (int) (Math.random() * 1000);
        return prefix + String.format("%03d", random);
    }

    // ====== toString para debugging ======
    @Override
    public String toString() {
        return String.format("Client[%s - %s - %s]", clientCode, name, email);
    }
}