# Semana 02 - Pixel Creativo

## 📋 Descripción
Sistema expandido de gestión para agencia de diseño gráfico que incluye:
- Gestión de clientes y proyectos
- Asignación de diseñadores
- Control de materiales
- Uso de ArrayList para colecciones

## 🏗️ Estructura de Clases

### Clases Existentes (Semana 01)
- **Client**: Gestión de clientes
- **DesignProject**: Proyectos de diseño

### Nuevas Clases (Semana 02)
- **Designer**: Gestión de diseñadores (30 pts)
- **Material**: Control de materiales (30 pts)
- **ProjectAssignment**: Relación entre proyectos, diseñadores y materiales (25 pts)
- **AgencyManager**: Clase gestora con ArrayList (20 pts)

## 🔄 Relaciones Implementadas
- Un **ProjectAssignment** relaciona: DesignProject + Designer + Material
- **AgencyManager** gestiona colecciones de: Clients, Projects, Designers, Assignments

## 🚀 Cómo Ejecutar
```bash
javac co/edu/sena/DesignProject/*.java
java co.edu.sena.DesignProject.Main
```

## ✅ Requisitos Cumplidos
- ✓ 2 nuevas clases con mínimo 3 atributos cada una
- ✓ Constructores completos
- ✓ Getters y setters
- ✓ Métodos de negocio
- ✓ Relaciones entre objetos (composición)
- ✓ Uso de ArrayList en clase gestora
- ✓ Main completo con demostración funcional

## 👨‍💻 Autor
NELSON MEJIA - Ficha 3228973A