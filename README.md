
# App web BCRP
TEST2
Es una aplicación para la Intranet de Posición de cambio BCRP - BBVA.

Migración de web a JBoss EAP 7.2 (java 8).

## Tech Stack

**Frontend:** Angular 8, node 14 (v14.19.1), npm 6 (v6.14.16)

**Backend:** Java 8, Spring Boot 4, Maven, database Oracle 12c, driver database ojdbc8.jar

**Deploy:** bcrp.war (backend), bcrp-ui.war (frontend)

## Repositorios Frontend

#### Repositorio 'master':
```http
https://globaldevtools.bbva.com/bitbucket/projects/DS_IBIS_GMS_MER/repos/alcon-
bcrp-ui/browse
```

#### Sonar 'master':
```http
https://globaldevtools.bbva.com/sonar/dashboard?id=DS_IBIS_GMS_MER%3Aalcon-
bcrp-ui%3Amaster
```

#### Repositorio 'release':
```http
https://globaldevtools.bbva.com/bitbucket/projects/DS_IBIS_GMS_MER/repos/alcon-bcrp-ui/commits?until=refs%2Fheads%2Frelease%2F1.20.0_forwardAmericano
```

#### Sonar 'release':
```http
https://globaldevtools.bbva.com/sonar-lts/dashboard?id=DS_IBIS_GMS_MER%3Aalcon-bcrp-ui%3Arelease%2F1.20.0_forwardAmericano
```

#### Artifactory:
```http
https://globaldevtools.bbva.com/artifactory-api/devops-pe-mvn-releases/devops-pe-mvn/alcon-bcrp-ui/master/10/artifactsToDeployment.tar
```

## Repositorios Backend

#### Repositorio 'master':
```http
https://globaldevtools.bbva.com/bitbucket/projects/DS_IBIS_GMS_MER/repos/alcon-
bcrp/browse
```

#### Sonar 'master':
```http
https://globaldevtools.bbva.com/sonar/dashboard?id=DS_IBIS_GMS_MER%3Aalcon-
bcrp%3Amaster
```

#### Repositorio 'release':
```http
https://globaldevtools.bbva.com/bitbucket/projects/DS_IBIS_GMS_MER/repos/alcon-bcrp/commits?until=refs%2Fheads%2Frelease%2F1.20.0_forwardAmericano 
```

#### Sonar 'release':
```http
https://globaldevtools.bbva.com/sonar-lts/dashboard?id=DS_IBIS_GMS_MER%3Aalcon-bcrp%3Arelease%2F1.20.0_forwardAmericano 
```

#### Artifactory:
```http
https://globaldevtools.bbva.com/artifactory-api/devops-pe-mvn-releases/devops-pe-mvn/alcon-bcrp/master/15/artifactsToDeployment.tar 
```

#### Git:

* Download code from master
```bash
git clone {ssh-git}
{ssh-git} = ssh://git@globaldevtools.bbva.com:7999/k8ab/alcon-bcrp.git
```

* Download code from branch
```bash
git clone -b {branch} --single-branch {ssh-git}
```

* Upload code

```bash
  git status
  git add .
  git commit -m "message"
  git push
```

## TEST

#### App URL (frontend):
https://de-espper.peru.igrupobbva/tlvjboss72app/bcrp-ui/# 

https://de-espper.peru.igrupobbva/tlvjboss72app/bcrp-ui/#/Mantenimiento/Clientes/clientes-registrados

http://118.180.188.144:8180/bcrp

Nateada = https://172.30.9.44/tlvjboss72app/bcrp-ui/

    User = p027968
	Password = perutst2

#### Deploy:
    Server group = sg_servicios01

#### App URL (backend, service):
http://118.180.188.143:8180/bcrp 

Nateada = http://172.30.10.158:8180/bcrp

#### Balanceador de Carga backend:

http://118.180.45.39/bcrp/swagger-ui/index.html?url=/bcrp/v3/api-docs
http://localhost:8080/bcrp/v3/api-docs/

url: open-api ui

https://petstore.swagger.io/

#### Server Jboss EAP 7.2:

* #### Console
http://118.180.188.146:9990/console/index.html#deployments 

Nateada: http://172.30.10.166:9990/console/index.html#deployments 

    User = p009536 (antes p00600)
    Password = j2pooqseg (antes pooqgoo)

    ó:
    User = p027968
    Password = pos7pg8

#### Datasource (backend):
JNDI = java:jboss/datasources/APP_PCBCRP

#### Logs App:
http://118.180.188.144:88/logs/PCBCRP/logs/

http://118.180.188.145:88/logs/PCBCRP/logs/

#### Database: Oracle 12C:

SCHEMA = PCBCRP

Name = ?

HOST = TLBDFORACLE.pe.igrupobbva (antes TLBDFORA12.pe.igrupobbva, IP = 118.180.35.45 1521)
	
Nateada = 172.30.12.128

PORT = 1521

NAME SERVICE = TST12C

USER = PCBCRP

PASSWORD = rkpuaNFqVbRMmUS

Connection string = APP_PCBCRP@//172.30.12.128:1521/TST12C

Test App Externos:
    Url = 172.30.12.128
    USER = APP_PCBCRP
    PASSWORD = iixzLcHjAbHFeFI

* #### Base de datos antigua Sql Server

ip = 118.185.8.36

user = UsrMercadosglobales

password = M3rcad0s9

## CALIDAD

#### App URL (frontend):
https://cal-espper.peru.igrupobbva/clvjboss72app/bcrp-ui/#/

https://cal-espper.peru.igrupobbva/clvjboss72svr

118.180.188.152

    User = P027197
	Password = perucal3 (antes perucal2)

#### Deploy:
    Server group = sg_servicios01

#### Server Jboss EAP 7.2:

Referencias:

KT-Posicion de Cambio BCRP

https://teamspaces.bbva.com/teamspaces/global-markets-systems-2/files/9_-reliability/circular-bcrp

http://172.30.10.158:8180/tlvjboss72app/bcrp-ui/#/ 

http://172.30.10.158:8180/tlvjboss72svr/bcrp/saldocontable?draw=1&start=0&length=10&fecha=03/16/2021 

http://172.30.10.158:8180/tlvjboss72app/bcrp-ui/#/Mantenimiento/tasas-interes/listar-tasas-interes 

#### Logs App:
http://118.180.188.152:88/logs/PCBCRP/logs/  

http://118.180.188.153:88/logs/PCBCRP/logs/

#### Base de datos antigua Sql Server:

ip = 118.185.8.37

user = UsrMercadosglobales

password = M3rcad0s

## PRODUCCION

#### App URL (frontend):

#### App URL (backend):

#### Logs App:

https://plvapacheweb01.pe.igrupobbva/pcbcrp/ 

    user = P009536
    password = 4M1_9pz.Rds

#### Web:
118.185.16.73:88/logs

118.185.16.74:88/logs

#### Servicios:
118.185.16.75:88/logs

118.185.16.76:88/logs

Ruta en el servidor = /logs/PCBCRP/logs/

## Notas
https://teamspaces.bbva.com/teamspaces/global-markets-systems-2/files/9_-reliability/circular-bcrp/

Componente Maven: bbva-mantenimiento

El proyecto parent para la aplicacion web de SIGAL

URL TEST ANTIGUA = http://118.180.35.195:8083/BBVABCRP/Mantenimiento/TipoCambio.aspx

URL TEST ANTIGUA POR VPN - CANVIA = http://172.30.10.222:8083/BBVABCRP/Principal.aspx

URL PRODUCCION ANTIGUA = http://118.180.61.110:8083/BBVABCRP/Principal.aspx

#### Instalar:

* #### Generar bcrp.war del backend (carpeta alcon-bcrp):

1. Install library Lombok.jar v1.18.24, esto sirve para automatizar los get y set: https://projectlombok.org/download 
	
	Solo se debe ejecutar el .jar.
	
2. Compilar código con:

    mvn clean install

* #### Generar bcrp-ui.war del frontend (carpeta alcon-bcrp-ui):

1. Ingresar a la carpeta del proyecto alcon-bcrp-ui\BCRP-webapp:

2. Desde ahi abrir CMD, para abrir con Visual Studio Code, escribir:
    code .

3. Abrir terminal y ejecutar:
    npm install
    ng serve -o
	
#### Pruebas:

* #### En el frontend, cambiar la uri que apunta al backend en:
	environment.ts
	//uri: 'http://172.30.10.203/bcrp/',  // BANCO VPN
	uri: 'http://localhost:8080/bcrp/',

#### Herramientas Recomendadas:
Desarrollo:

Eclipse ,  STS (Spring tootls)

Base de Datos:

SQl DEVELOPER (ORACLE)
SQL SERVER STUDIO (SQL SERVER)
DBBEAVER (ORACLE,SQL SERVER)

Docker ( Oracle 12c)

OTRAS HERRAMIENTAS:

NODEJS (npm,ng)
MAVEN
JAVA 8>
GIT
VISUAL STUDIO CODE

WEB:
ANGULAR 6
MATERIAL DESIGN UI
