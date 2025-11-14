## 📝 Descripción

Durante esta semana se implementó el dominio **Pixel Creativo**, una agencia de diseño gráfico ubicada en Bogotá.  
Se desarrollaron dos clases orientadas a objetos (`DesignProject` y `Client`) para representar los proyectos de diseño y los clientes de la agencia, además de un programa principal que demuestra su interacción.  
También se documentó el análisis del diseño y la relación entre las clases en un archivo Markdown.

## 🎯 Objetivos Cumplidos

- [x] Implementar clase principal del dominio
- [x] Implementar clase secundaria relacionada
- [x] Crear programa de demostración
- [x] Documentar análisis del dominio

## 📂 Archivos Entregados

- `src/DesignProject.java` - Clase principal que representa un proyecto de diseño (código, tipo, cliente, costo, estado, etc.)
- `src/Client.java` - Clase secundaria que representa un cliente y sus proyectos contratados
- `src/Main.java` - Programa de demostración que crea objetos, llama métodos y muestra los resultados
- `docs/ANALISIS.md` - Documento con el análisis y diseño orientado a objetos del dominio Pixel Creativo

## 🚀 Instrucciones de Ejecución

```bash
cd src
javac *.java
java Main
```

-------------------------------------------------------------------------------------
```
## Salida Esperada
        
=== SISTEMA DE GESTIÓN - PIXEL CREATIVO ===

--- CLIENTES REGISTRADOS ---
=== CLIENT INFORMATION ===
Code: C001
Name: Juan Pérez
Email: juanperez@email.com
Active Projects: 0
Total Spent: $0.0

=== CLIENT INFORMATION ===
Code: C002
Name: María López
Email: marialopez@email.com
Active Projects: 0
Total Spent: $0.0

--- PROYECTOS CREADOS ---
=== DESIGN PROJECT ===
Code: P001
Type: Logo Design
Client: Juan Pérez
Cost: $1200000.0
Delivery Time: 10 days
Approved: NO

=== DESIGN PROJECT ===
Code: P002
Type: Web Design
Client: María López
Cost: $2500000.0
Delivery Time: 20 days
Approved: NO

--- CALCULAR COSTOS ---
Costo final del proyecto 1: $1200000.0
Costo final del proyecto 2: $2500000.0

--- DESPUÉS DE APROBAR PROYECTO 2 ---
=== DESIGN PROJECT ===
Code: P002
Type: Web Design
Client: María López
Cost: $2500000.0
Delivery Time: 20 days
Approved: YES
Costo final del proyecto 2 (con incremento): $2750000.0

--- CLIENTES ACTUALIZADOS ---
=== CLIENT INFORMATION ===
Code: C001
Name: Juan Pérez
Email: juanperez@email.com
Active Projects: 1
Total Spent: $1200000.0

=== CLIENT INFORMATION ===
Code: C002
Name: María López
Email: marialopez@email.com
Active Projects: 1
Total Spent: $2750000.0

¿Juan Pérez es cliente frecuente?: No
¿María López es cliente frecuente?: Sí

Process finished with exit code 0
```

## Conceptos Aplicados
- Clases y objetos en Java

- Atributos y métodos

- Instanciación de múltiples objetos

- Diferencias entre programación estructurada y orientada a objetos