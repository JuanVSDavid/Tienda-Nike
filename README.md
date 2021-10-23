# Tienda-Nike
Para usar la app desde el codigo fuente debe:

*   clonar el repositorio
*   crear un archivo llamado application.properties en la carpeta src\main\resources y agregar la configuracion pertinente para la conexion con la base de datos, ya sea para local con mysql o para servicios aws con mariadb (En el caso de que quiera utilizar la base de datos aws, tiene que agregar la dependencia en el pom)
    <!-- https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <version>3.0.2-rc</version>
</dependency>    
*   para realizar el login la primera vez debe crear un usuario en la base de datos generada y usar una contraseña encriptada con bcrypt
*   https://bcrypt-generator.com/ (Con este Link genera la contraseña)
*   la app cuenta con 6 modulos:

*   Usuarios (solo disponible como usuario ADMIN) otorga un CRUD de usuarios
*   Clientes (solo disponible como usuario ADMIN) otorga un CRUD de clientes
*   Proveedores (solo disponible como usuario ADMIN) otorga un CRUD de proveedores
*   Productos acepta un archivo .csv con la siguiente estructura

*   nombre_producto;nitproveedor(de un proveedor existente);precio_compra;ivacompra;precio_venta

*   Ventas (crea una nueva venta y un detalle de venta) Tiene relacion con todos los demas modulos de la app directa o indirectamente
*   Reportes (genera una lista de usuarios clientes y ventas por cliente)

