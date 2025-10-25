## ⚙️ Configuración del Entorno de Pruebas

Para ejecutar las pruebas, es necesario proveer un archivo de credenciales.

### 1. Ruta del Archivo

Crea la siguiente estructura de carpetas y el archivo JSON:

`/src/resources/dataResources/datosPrueba.json`

### 2. Estructura de `datosPrueba.json`

El archivo debe ser un *array* de objetos JSON. Los scripts usarán el `user` para encontrar la `url` y el `pass` correspondientes e iniciar la sesión con Selenium.

**Ejemplo:**
```json
[
  { 
    "urlComunidadFeliz": "[https://qa.ejemplo.cl/login](https://qa.ejemplo.cl/login)", 
    "user": "usuario_qa_1", 
    "pass": "clave_qa_1" 
  },
  { 
    "urlComunidadFeliz": "[https://staging.ejemplo.cl/login](https://staging.ejemplo.cl/login)", 
    "user": "usuario_staging", 
    "pass": "clave_staging" 
  }
]
