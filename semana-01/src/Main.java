public class Main {
    public static void main(String[] args) {

    System.out.println("                                                      ");
    System.out.println("                   PIXEL CREATIVO                     ");
    System.out.println("             Agencia de Diseño Gráfico                ");
    System.out.println("                                                      ");
    System.out.println();
    System.out.println("------------------------------------------------------");
    System.out.println();

    // Objeto 1
    DesignProject project1 = new DesignProject(
            "DES-001",
            "Identidad Corporativa Completa",
            "Café Origen - Chapinero"
    );

    // Objeto 2
    DesignProject project2 = new DesignProject(
            "DES-002",
            "Diseño Web Responsive",
            "Restaurante La Candelaria"
    );

    // Objeto 3
    DesignProject project3 = new DesignProject(
            "DES-003",
            "Diseño de Packaging Premium",
            "Chocolates Andinos"
    );

    // Objeto 4
    DesignProject project4 = new DesignProject(
            "DES-004",
            "Campaña Publicitaria Digital",
            "Boutique Moda Norte"
    );

    // Objeto 5
    DesignProject project5 = new DesignProject(
            "DES-005",
            "Branding y Material POP",
            "Clínica Dental Sonrisas - Usaquén"
    );

        // cliente 1
        client client1 = new client(
                "Maria Valencia"
                "1023456951"
                "3205976431"
        );

        // cliente 2
        client client2 = new client(
                "Oscar Gomez"
                "1023435671"
                "3178930519"
        );
        // cliente 3
        client client3 = new client(
                "Juan Ardila"
                "1649355671"
                "3108997519"
        );

        // cliente 4
        client client4 = new client(
                "Sebastian Cota"
                "53149763"
                "3229783156"
        );

        // cliente 5
        client client5 = new client(
                "Laura Mendez"
                "79846359"
                "3502197832"
        );

        // INSTRUCCIÓN 3: Llamar showInfo() para cada objeto

    System.out.println(" PROYECTO 1:");
    project1.showInfo();

    System.out.println(" PROYECTO 2:");
    project2.showInfo();

    System.out.println(" PROYECTO 3:");
    project3.showInfo();

    System.out.println(" PROYECTO 4:");
    project4.showInfo();

    System.out.println(" PROYECTO 5:");
    project5.showInfo();

        System.out.println(" CLIENTE 1:");
        client1.showInfo();

        System.out.println(" CLIENTE 2:");
        client2.showInfo();

        System.out.println(" CLIENTE 3:");
        client3.showInfo();

        System.out.println(" CLIENTE 4:");
        client4.showInfo();

        System.out.println(" CLIENTE 5:");
        client5.showInfo();
}
}