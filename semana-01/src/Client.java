public class Client { // Atributos String projectCode; String designType; String client;

    // ATRIBUTOS
    private String name;
    private int id;
    private int cell;


    // Constructor que inicializa los atributos
    public Client(String name, int id, int cell) {
        this.name = name;
        this.id = id;
        this.cell = cell;
    }

    // Método para mostrar información del proyecto
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("Nombre Cliente: " + name);
        System.out.println("Numero de identificacion: " + id);
        System.out.println("Numero de Telefono: " + cell);
        System.out.println("------------------------------");
        System.out.println();
    }
}