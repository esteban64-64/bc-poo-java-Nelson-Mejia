public class Client { // Atributos String projectCode; String designType; String client;

    // Constructor que inicializa los atributos
    public client(String name, String id, String cell) {
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