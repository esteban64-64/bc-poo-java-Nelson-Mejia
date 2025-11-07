# Análisis Orientado a Objetos - Pixel Creativo

## 1. Identificación del Dominio

**Nombre del negocio:** Pixel Creativo  
**Tipo:** Agencia de Diseño Gráfico  
**Descripción:**  
Pixel Creativo es una agencia ubicada en Bogotá, especializada en diseño de marca, publicidad, diseño web y packaging. Atiende clientes que solicitan proyectos de diseño gráfico personalizados y gestiona múltiples proyectos simultáneamente para diferentes marcas.

---

## 2. Objetos Identificados

### Objeto Principal: DesignProject

**¿Qué es?:**  
Representa un proyecto de diseño realizado por la agencia. Cada proyecto tiene un tipo (por ejemplo, logo, web, packaging), un cliente asociado, un costo estimado y un estado de aprobación.

**Atributos identificados:**
- `projectCode`: String - Código único del proyecto.
- `designType`: String - Tipo de diseño (logo, web, packaging, etc.).
- `client`: String - Nombre del cliente asociado al proyecto.
- `projectCost`: double - Costo base del proyecto.
- `deliveryDays`: int - Días estimados para entregar el proyecto.
- `approved`: boolean - Indica si el cliente ha aprobado el proyecto.

**Métodos identificados:**
- `showProjectInfo()`: Imprime la información completa del proyecto.
- `calculateFinalCost()`: Calcula el costo final considerando un posible incremento si el proyecto está aprobado.
- `getProjectCode()`: Retorna el código del proyecto.
- `setApproved(boolean)`: Permite cambiar el estado de aprobación.

---

### Objeto Secundario: Client

**¿Qué es?:**  
Representa al cliente de la agencia que contrata proyectos de diseño. Permite registrar su información, el número de proyectos activos y el total de dinero invertido.

**Atributos identificados:**
- `clientCode`: String - Identificador único del cliente.
- `name`: String - Nombre del cliente.
- `email`: String - Correo electrónico del cliente.
- `activeProjects`: int - Cantidad de proyectos activos.
- `totalSpent`: double - Total de dinero invertido en la agencia.

**Métodos identificados:**
- `showClientInfo()`: Muestra en consola toda la información del cliente.
- `addProject(double)`: Registra un nuevo proyecto y acumula el gasto total.
- `isFrequentClient()`: Determina si el cliente es frecuente según el dinero invertido.

---

## 3. Relación entre Objetos

**Tipo de relación:** Asociación

**Descripción:**  
Un **Cliente** puede tener uno o varios **Proyectos de Diseño**.  
Cada proyecto conoce el nombre del cliente que lo solicita, y a su vez, el cliente acumula el costo total de sus proyectos realizados con la agencia.

**Ejemplo:**  
“Un cliente llamado Juan Pérez contrata un proyecto de diseño de logotipo. El objeto `DesignProject` guarda el nombre del cliente, y el objeto `Client` aumenta su contador de proyectos y el dinero invertido.”

---

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**  
Porque en el contexto de una agencia de diseño, los elementos principales son los **proyectos** que se realizan y los **clientes** que los solicitan. Ambos forman el núcleo del sistema de gestión.

**¿Por qué estos atributos son importantes?**
- Permiten identificar claramente cada entidad.
- Facilitan el seguimiento de proyectos activos y su estado.
- Registran información relevante para la gestión financiera y administrativa.

**¿Por qué estos métodos son necesarios?**
- `showProjectInfo()` y `showClientInfo()` permiten visualizar fácilmente la información.
- `calculateFinalCost()` agrega lógica de negocio al cálculo de precios.
- `addProject()` y `isFrequentClient()` ayudan a analizar la relación comercial con cada cliente.
- Los getters y setters mantienen la encapsulación y control de los datos.

---

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**  
El sistema tendría solo funciones y variables globales. Por ejemplo, habría listas de clientes y proyectos separadas, y se necesitarían múltiples funciones para buscar, actualizar o calcular costos, sin relación directa entre los datos.  
Esto aumentaría la complejidad y el riesgo de errores al manipular la información.

**Con POO:**  
Las clases permiten **organizar la información y la lógica** en entidades coherentes.  
Cada objeto maneja sus propios datos y comportamientos, lo que facilita el mantenimiento, la reutilización y la extensión del código.

**Ventajas específicas en mi dominio:**
1. **Encapsulación:** Cada proyecto y cliente maneja su propia información de forma independiente.
2. **Reutilización:** Se pueden crear más tipos de proyectos o extender las clases sin afectar el resto del sistema.
3. **Escalabilidad:** Permite manejar múltiples clientes y proyectos de forma ordenada y eficiente.

---

## 6. Diagrama de Clases 

```mermaid
classDiagram
    class Client {
        - String clientCode
        - String name
        - String email
        - int activeProjects
        - double totalSpent
        + showClientInfo()
        + addProject(double)
        + isFrequentClient()
    }

    class DesignProject {
        - String projectCode
        - String designType
        - String client
        - double projectCost
        - int deliveryDays
        - boolean approved
        + showProjectInfo()
        + calculateFinalCost()
        + getProjectCode()
        + setApproved(boolean)
    }

    Client "1" --> "*" DesignProject : realiza
