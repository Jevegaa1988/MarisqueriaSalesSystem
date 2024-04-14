@echo off
REM Establecer la ruta del archivo CSV como variable de entorno
set CSV_FILE_PATH=C:\Users\jesus\eclipse-workspace\MarisqueriaSalesSystem\ventas_marisqueria.csv

REM Ejecutar la aplicación Java
java -jar C:\Users\jesus\eclipse-workspace\MarisqueriaSalesSystem\target\MarisqueriaSalesSystem-0.0.1-SNAPSHOT.jar

REM Pausa el script para ver cualquier mensaje de salida antes de cerrar la ventana de la consola
pause