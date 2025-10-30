public class DesignProject {
    // ATRIBUTOS
    private String projectCode;
    private String designType;
    private String company;

    // Constructor que inicializa los atributos
    public DesignProject(String projectCode, String designType, String company) {
        this.projectCode = projectCode;
        this.designType = designType;
        this.company = company;
    }

    // Método para mostrar información del proyecto
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("Código: " + projectCode);
        System.out.println("Tipo de Diseño: " + designType);
        System.out.println("Empresa: " + company);
        System.out.println("------------------------------");
        System.out.println();
    }
}