# springboot-service-users
Api para la gestion de usuarios

# Swagger
http://localhost:8050/swagger-ui.html
http://localhost:8050/v2/api-docs

Descripcion Api
====================

Api que permite insertar un usuario con telefonos anexos en la base de datos de forma persistente utilizando Jwt y Hsqldb

- - -

Listado de servicios de la Api
====================

1.  http://localhost:8050/api/v1/usuarios/insertar   => POST     
    ====================
## Descripción: 
Permite ingresar un usuario a la base de datos con un listado de telefonos,
además de indicar si su rol será "admin" ya que por defecto por la autenticación por Jwt se le coloca rol "user",
se ejecutan validaciones de entrada por el email y password. Una vez que se ejecuta este servicio el usuario está
autenticado por Jwt y se genera el token de acceso necesario para el resto de los endpoints

## JSON's con entradas y salidas de ejemplo
## Entrada (body):
{
"name": "julian",
"email": "julian@gmail.com",
"password": "Arrrr42",
"phones": [
{
"number": "87104600",
"citycode": "9",
"contrycode": "56"
},
{
"number": "5555",
"citycode": "9",
"contrycode": "56"
}
],
"roles": ["admin"]
}
## Salida
{
"usuario": {
"id": 1,
"name": "julian",
"email": "julian@gmail.com",
"password": "Arrrr42",
"created": "21/08/2022",
"modified": "21/08/2022",
"last_login": "21/08/2022",
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDQ1MDU5LCJleHAiOjE2NjEwODEwNTl9.6_V953o-JIAOOL376In-rqCY0oIqbtmancjDyIqSSSnSjH1erlUOPEeOGvQNXrg3ayiVssbDyuHdsGACzfsgNw",
"isactive": true
},
"codigo": "201 CREATED"
}



2.  http://localhost:8050/api/v1/auth/login   => POST (servicio opcional para el login, ya que al insertar el usuario este queda automáticamente logueado)
    ====================
## Descripción: 
Luego de haber ingresado el usuario previamente, para consumir los distintos endpoint en necesario realizar el login en Jwt,
esto con el fin de que se genere el token que se usará para el resto de los endpoints, para este caso el email va a ser el
nombre de usuario que aplique para el login en Jwt. Al hacer login se actualiza en la tabla de usuarios el token obtenido,
la fecha de login y se cambia el estado a activo dentro de la aplicación.

## JSON's con entradas y salidas de ejemplo
## Entrada (body):
{
"nombreUsuario": "julian@gmail.com", "password":"Arrrr42"
}
## Salida
{
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDQ1MDU5LCJleHAiOjE2NjEwODEwNTl9.6_V953o-JIAOOL376In-rqCY0oIqbtmancjDyIqSSSnSjH1erlUOPEeOGvQNXrg3ayiVssbDyuHdsGACzfsgNw",
"bearer": "Bearer",
"nombreUsuario": "julian@gmail.com",
"authorities": [
{
"authority": "ROLE_USER"
},
{
"authority": "ROLE_ADMIN"
}
]
}


3.  http://localhost:8050/api/v1/usuarios/listar   => GET
    ====================
## Descripción:
Este servicio nos permite listar los usuarios registrados en la base de datos, para consumirlo es necesario enviar por header,
el token conseguido en el login

## JSON's con entradas y salidas de ejemplo
## Entrada (header):

"Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDMwMDEzLCJleHAiOjE2NjEwNjYwMTN9.FFX3oQhdjRMdNVJlSikjSF_FtBU1DpKA79GWfQFc8uL-8IRBwBCFyy08k8UOLy263MHfR48fju02UbVPuzDgEw"

## Salida
{
"data": [
{
"id": 1,
"name": "julian",
"email": "julian@gmail.com",
"password": "Arrrr42",
"created": "20/08/2022",
"modified": "20/08/2022",
"last_login": "20/08/2022",
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDUzNTQ3LCJleHAiOjE2NjEwODk1NDd9.Doj7ER0XImY_cqopVeY4rVQFXi9Fu0xmkO5HnP5DgR_rrqRiPvXSn3x5NhCsyIxfmcNJaEQzmH1MQavzmilgsQ",
"isactive": true
}
],
"codigo": "200 OK"
}




4.  http://localhost:8050/api/v1/telefonos/listar   => GET
    ====================
## Descripción:
Este servicio nos permite listar los telefonos registrados en la base de datos, para consumirlo es necesario enviar por header,
el token conseguido en el login

## JSON's con entradas y salidas de ejemplo
## Entrada (header):

"Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDMwMDEzLCJleHAiOjE2NjEwNjYwMTN9.FFX3oQhdjRMdNVJlSikjSF_FtBU1DpKA79GWfQFc8uL-8IRBwBCFyy08k8UOLy263MHfR48fju02UbVPuzDgEw"

## Salida

{
"data": [
{
"id": 1,
"number": "87104600",
"citycode": "9",
"contrycode": "56",
"iduser": 1
},
{
"id": 2,
"number": "5555",
"citycode": "9",
"contrycode": "56",
"iduser": 1
}
],
"codigo": "200 OK"
}


5.  http://localhost:8050/api/v1/usuarios/ver/{email}  => GET
    ====================
## Descripción:
Este servicio nos permite visualizar el usuario registrado agregando el email port PathVariable, para consumirlo es necesario
enviar por header, el token conseguido en el login

## JSON's con entradas y salidas de ejemplo
## Entrada (header):

"Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDMwMDEzLCJleHAiOjE2NjEwNjYwMTN9.FFX3oQhdjRMdNVJlSikjSF_FtBU1DpKA79GWfQFc8uL-8IRBwBCFyy08k8UOLy263MHfR48fju02UbVPuzDgEw"

## Salida

{
    "usuario": {
        "id": 1,
        "name": "julian",
        "email": "julian@gmail.com",
        "password": "Arrrr42",
        "created": "20/08/2022",
        "modified": "20/08/2022",
        "last_login": "20/08/2022",
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDUzNTQ3LCJleHAiOjE2NjEwODk1NDd9.Doj7ER0XImY_cqopVeY4rVQFXi9Fu0xmkO5HnP5DgR_rrqRiPvXSn3x5NhCsyIxfmcNJaEQzmH1MQavzmilgsQ",
        "isactive": true
    },
    "codigo": "200 OK"
}





                                                                                                                                                                                                                        
6.  http://localhost:8050/api/v1/usuarios/auth/nuevo  => POST (De uso opcional)                                                                                                                                                           
    ====================                                                                                                                                                                                                
## Descripción:                                                                                                                                                                                                         
Este servicio nos permite ingresar o autenticar de forma directa un usuario a Jwt en caso de necesitarlo                                                                                                                                                                     
                                                                                                                                                                                                                           
## JSON's con entradas y salidas de ejemplo     
## Entrada (header):

"Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDMwMDEzLCJleHAiOjE2NjEwNjYwMTN9.FFX3oQhdjRMdNVJlSikjSF_FtBU1DpKA79GWfQFc8uL-8IRBwBCFyy08k8UOLy263MHfR48fju02UbVPuzDgEw"

## Entrada (body):   
{
    "nombre": "julian",
    "nombreUsuario": "julian",
    "email": "jj@gmail.com",                                                                                                                                                                                                                                                                                                                                                                                                         
    "password":"hola",
     "roles": ["admin"]
}
## Salida
 {
    "mensaje": "Usuario guardado con exito"
} 




7.  http://localhost:8050/api/v1/usuarios/update/1  => PUT
    ====================                                                                                                                                                                                                
## Descripción:
Este servicio nos permite actualizar los datos del usuario y sus telefonos asociados

## JSON's con entradas y salidas de ejemplo
## Entrada (header):

"Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDMwMDEzLCJleHAiOjE2NjEwNjYwMTN9.FFX3oQhdjRMdNVJlSikjSF_FtBU1DpKA79GWfQFc8uL-8IRBwBCFyy08k8UOLy263MHfR48fju02UbVPuzDgEw"

## Entrada (body):
{
"name": "julianSITO",
"email": "julian2@gmail.com",
"password": "Arrrr43",
"phones": [
{
"number": "9999999",
"citycode": "1",
"contrycode": "1",
"id": 1
},
{
"number": "88888888",
"citycode": "4",
"contrycode": "4",
"id": 2
}
]
}
## Salida
{
"codigo": "200 OK",
"mensaje": "Los datos han sido actualizados con éxito"
} 





8.  http://localhost:8050/api/v1/usuarios/delete/1  => DELETE
    ====================                                                                                                                                                                                                
## Descripción:
Este servicio nos permite eliminar los datos del usuario y sus telefonos asociados

## JSON's con entradas y salidas de ejemplo
## Entrada (header):

"Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWxpYW5AZ21haWwuY29tIiwiaWF0IjoxNjYxMDMwMDEzLCJleHAiOjE2NjEwNjYwMTN9.FFX3oQhdjRMdNVJlSikjSF_FtBU1DpKA79GWfQFc8uL-8IRBwBCFyy08k8UOLy263MHfR48fju02UbVPuzDgEw"

## Salida
{
"codigo": "200 OK",
"mensaje": "El usuario ha sido eliminado con éxito"
}