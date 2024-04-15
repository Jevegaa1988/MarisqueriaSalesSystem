1.	Resumen Ejecutivo

Descripción

•	El proyecto Marisquería Sales System es una aplicación diseñada para facilitar el registro y seguimiento de ventas de productos marinos. Permite a los usuarios registrar ventas, ver informes de ventas por fecha.

Problema Identificado

•	Las marisquerías enfrentan desafíos en la gestión eficiente de registro de ventas, lo que puede llevar a pérdidas de ingresos y productos no contabilizados.

Solución

•	Implementar un sistema automatizado que permite registrar cada venta, calcular total de ventas, y revisar historiales de venta, todo centralizado en una sola herramienta accesible.

Arquitectura

•	La aplicación está desarrollada en Java y se distribuye como un archivo JAR ejecutable, simplificando su despliegue y ejecución en cualquier sistema con Java instalado. La información se almacena localmente en archivos CSV, lo que facilita su mantenimiento sin necesidad de bases de datos complejas.

•	Tabla de Contenidos
•	Requerimientos
•	Instalación
•	Configuración
•	Uso
•	Contribución
•	Roadmap

2. Requerimientos

Servidores y Bases de Datos

•	No se requieren servidores de aplicación o web.
•	Toda la información se gestiona localmente usando archivos CSV.



Paquetes Adicionales

•	Java Development Kit (JDK) versión 11.
•	Apache Maven para la gestión de dependencias y construcción del proyecto.

Versión de Java

•	Java 11

3.	. Instalación

¿Cómo instalar el ambiente de desarrollo?

Para instalar y configurar el ambiente de desarrollo para Marisqueria Sales System, sigue estos pasos:

Descargar e instalar Java:

•	Asegúrate de tener Java 11 instalado en tu sistema. Puedes descargarlo desde el sitio oficial de Oracle.
•	Java Archive Downloads - Java SE 11 (oracle.com)
•	Sigue las instrucciones de instalación específicas para tu sistema operativo.

•	Establecer la variable de entorno JAVA_HOME:

•	Configura la variable de entorno JAVA_HOME para que apunte al directorio donde se instaló Java.

•	En Windows, esto se puede hacer desde el Panel de Control → Sistema y Seguridad → Sistema → Configuración avanzada del sistema → Variables de entorno.

Clonar el repositorio:

•	Obtén el código fuente clonando el repositorio del proyecto:

•	git clone https://github.com/Jevegaa1988/MarisqueriaSalesSystem.git

•	Navega a la carpeta del proyecto clonado.

¿Cómo ejecutar pruebas manualmente?

Para ejecutar las pruebas unitarias del proyecto manualmente, utiliza Maven desde la línea de comandos en la carpeta del proyecto:

•	mvn test


¿Cómo implementar la solución en producción en un ambiente local o en la nube como Heroku?

Para implementar Marisqueria Sales System en producción, sigue estos pasos:

Acceder a la carpeta Releases:

•	En el repositorio de GitHub, navega a la sección Releases donde encontrarás los archivos necesarios para la ejecución del sistema, incluyendo el archivo ejecutable .jar, el archivo de datos .csv y el archivo .bat para la ejecución en Windows.

Descargar los archivos de la versión más reciente:

•	Descarga los tres archivos mencionados y guárdalos en el mismo directorio en tu computadora local.

Ejecutar el archivo .bat:

•	Haz doble clic en el archivo EjecutarMarisqueria.bat para iniciar la aplicación. Este archivo se encarga de ejecutar el sistema sin necesidad de comandos adicionales, facilitando su uso a usuarios finales.

Manual de Instalación:

•	Se incluye un manual detallado dentro de la carpeta Releases que explica cómo configurar y ejecutar la aplicación, asegurando que los usuarios puedan comenzar a utilizar el sistema sin complicaciones.

Implementación en Producción

•	Ejecutar el JAR generado con: java -jar target/MarisqueriaSalesSystem-0.0.1-SNAPSHOT.jar.

4.	 Configuración

Configuración del Producto

•	Configurar la ruta del archivo CSV en las variables de entorno del sistema para permitir la personalización del almacenamiento de datos.

•	Variable de Entorno para la Ruta del CSV: Configura la variable de entorno CSV_PATH para definir la ruta donde se almacenará y leerá el archivo CSV. Esto se puede hacer en Windows desde el Panel de Control → Sistema y Seguridad → Sistema → Configuración avanzada del sistema → Variables de entorno. Agrega una nueva variable de entorno llamada CSV_PATH y asigna la ruta del archivo CSV como su valor.

Configuración de los Requerimientos

•	Asegurarse de que Java y Maven están correctamente instalados y configurados.

5.  Uso

Usuario Final

•	Abrir el archivo EjecutarMarisqueria.bat para iniciar la aplicación y seguir las instrucciones en pantalla para registrar o consultar ventas.

Administrador

•	Mantenimiento mediante el archivo CSV.

6. Contribución

Guía de Contribución para Usuarios

Si estás interesado en contribuir al proyecto Marisqueria Sales System, sigue estos pasos para empezar:

a)	Clonar el Repositorio:

•	Visita el repositorio en GitHub: Marisqueria Sales System
•	Clona el repositorio en tu máquina local usando el comando:

git clone https://github.com/Jevegaa1988/MarisqueriaSalesSystem.git

•	Navega a la carpeta del proyecto:

cd MarisqueriaSalesSystem

b)	Crear un Nuevo Branch:

•	Antes de hacer cualquier cambio, crea un nuevo branch para tus modificaciones. Esto ayuda a mantener el orden y la organización en el desarrollo:

git checkout -b nombre-del-branch

•	Sustituye nombre-del-branch con un nombre que describa brevemente la característica o corrección que estás trabajando.

c)	Realizar Cambios:

•	Realiza los cambios necesarios en tu código. Asegúrate de seguir las convenciones de código del proyecto y de realizar pruebas locales para asegurar que todo funcione correctamente.

d)	Comprometer los Cambios:

•	Después de realizar tus cambios, añádelos al index de Git y realiza un commit:

git add .
git commit -m "Descripción breve de los cambios realizados"

e)	Enviar el Pull Request:

•	Sube tu branch al repositorio remoto:

git push origin nombre-del-branch

•	Ve al repositorio en GitHub y haz clic en 'New pull request'.
•	Selecciona tu branch y asegúrate de que el branch base es el correcto (por ejemplo, develop).
•	Describe los cambios realizados y cualquier otra información relevante para los revisores.
•	Envía el pull request.

f)	Esperar Revisión:

•	Otros miembros del proyecto revisarán tu contribución, podrán solicitar cambios o mejoras antes de integrar tu código al proyecto principal.
•	Mantente al tanto de cualquier comentario o solicitud de cambio en tu pull request.

7. Roadmap

Futuras Implementaciones

•	Implementación de seguridad y control de accesos por roles.

•	Desarrollo de una interfaz gráfica de usuario (GUI): Considerar la creación de una versión de la aplicación con interfaz gráfica para mejorar la experiencia del usuario y facilitar la gestión de ventas y productos.
