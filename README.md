# HealthSport

HealthSport es una aplicación que permite a los componentes de un equipo deportivo (tanto deportistas como entrenadores) coordinarse, monitorizar resultados y demás puntos clave en actividades deportivas.


## DIAGRAMAS DE LA APLICACIÓN

### Diagrama UML
![DiagramaUML](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/UML_Fase3.jpeg)

### Diagrama Entidad Relación
![DiagramaER](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/BaseDeDatos.jpeg)

### Diagrama de Navegación
![DiagramaNavegacion](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/DiagramaDeNavegacion.jpeg)


## PAGINAS PRINCIPALES

### INDEX
Pagina principal desde la que se presenta la aplicación y en la que encontramos los enlaces a las paginas principales.

![Index](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/Index.jpg)

### LOGIN
Página de inicio de sesion, en la cual iniciaran sesion tanto los deportistas como los entrenadores.

![Login](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/Login.jpg)

### REGISTRO GENERAL
Página de registro en la cual los usuarios seleccionan si querran registrarse como deportistas o como entrenadores.

![RegistroGeneral](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/RegistroGeneral.jpg)

### REGISTRO DEPORTISTA
Página de registro en la cual los deportistas rellenan sus datos, obtienen sus credenciales y son registrados en la Base de Datos.

![RegistroDeportista](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/RegistroDeportista.jpg)

### REGISTRO ENTRENADOR
Página de registro en la cual los entrenadores rellenan sus datos y los del equipo que quieren formar, obtienen sus credenciales y son registrados en la Base de Datos.

![RegistroEntrenador](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/RegistroEntrenador.jpg)

### DEPORTISTA
Página donde el deportista puede consultar sus datos y sus ultimas estadisticas.

![Deportista](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/Deportista.jpg)

### ENTRENADOR
Página donde el entrenador podra consultar sus datos y registrar a su equipo en nuevos eventos.

![Entrenador](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/Entrenador.jpg)

### EQUIPO
Página donde tanto el deportista como el entrenador pueden consultar los datos del equipo al que pertenecen. El entrenador, además, puede añadir nuevos componentes a su equipo.

![EquipoEntrenador](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/EquipoEntrenador.jpg)

### QUIENES SOMOS
Página donde se presenta al equipo de HealthSport.

![QuienesSomos](https://github.com/a-aguadoma/HealthSport/blob/master/Imagenes/QuienesSomos.jpg)


## INSTRUCCIONES PARA DESPLEGAR LA APLICACIÓN:

#### Instalar Java 8:

sudo add-apt-repository ppa:openjdk-r/ppa

sudo apt-get update

sudo apt-get install openjdk-8-jre 


#### Instalar MySQL Server:

sudo apt-get update

sudo apt-get install -y mysql-server 


#### Crear un nuevo esquema:

sudo mysql -u root -p

mysql>CREATE DATABASE test;

mysql>exit


#### Ejecutar aplicación web:

java -jar HealthSport-0.0.1-SNAPSHOT.jar


#### Ejecutar servicio interno:

java -jar ServicioInterno-0.0.1-SNAPSHOT.jar --password=****


## Intrucciones de dockerización:

### Descarga e instalar Docker:

Sigueindo los paso de la web ofcial: https://docs.docker.com/install/linux/docker-ce/ubuntu/

### Descargar la imagen oficial de Haproxy:

La pagina de a imagen oficial de Haproxy ofrece una guia sobre como descargar e instalar: https://hub.docker.com/_/haproxy

### Dockerizar la aplicación y el servicio interno:

Una vez creados los .jar como se explicaba anteriormente, es necesario hacer un Dockerfile para cada uno de ellos y otro para la base de datos.

### Generar el compose y ejecutarlo:

Descargando el coprimido de HealthSport del repositorio, se deberá emplazar todo el contenido en una carpeta, que contendra el .jar de la aplicación con su Dockerfile, una carpeta con el .jar del servicio interno y su Dockerfile y dos carpetas proxy que contendran los archivos de configuracion .cfg del balanceador y sus respectivos Dockerfiles. La carpeta proxy del balanceador de la apliación contendrá también el certificado para que esta pueda ejecutarse con seguridad mediante HTTPS.
El docker-compose facilitado se encarga de conectar los distintos contenedores y hacer que se ejecuten controlando la ejecucion en base a las dependencias que tienen entre ellos.

Para levantar este compose que contiene dos instancias de la aplicación, su balanceador, la base de datos, y dos instancias del servicio interno, también con su balanceador se debe utiliza el comando: sudo docker-compose up --build


## Equipo de desarrollo:

#### Alberto Aguado Martínez - a-aguadoma - a.aguadomar@alumnos.urjc.es

#### Sandra Juan San Román - sandrajsr93 - s.juan@alumnos.urjc.es

#### Elena Garcia-Morato Piñan - elenagarciamorato - e.garciapi@alumnos.urjc.es

Para cooordinarse, el equipo utiliza la herrramienta Trello: https://trello.com/b/v0LyzdMs/healthsport 
