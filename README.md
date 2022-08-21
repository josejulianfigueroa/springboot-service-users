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
autenticado por Jwt

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
"token": "",
"isactive": false
},
"codigo": "201 CREATED"
}
2. ../financeable_elements/${info.version}                      GET     : Provee método para obtener los elementos financiables
3. ../financeable_elements/${info.version}/action               POST   : Actualiza elemento financiable segun Accion
4. ../financeable_elements/${info.version}/action-list          POST   : Actualiza elemento financiable por lista segun Accion
5. ../financeable_elements/${info.version}/element              POST   : Guarda 1 elemento financiable
6. ../financeable_elements/${info.version}/list                 POST   : Guarda listado de elementos financiables e inserta en tabla log
7. ../financeable_elements/${info.version}/valid-list           POST   : Guarda una lista de elementos realizando la validacion antes del insert cuando son KIA
8. ../financeable_elements/${info.version}/selected_elements    POST   : Obtiene Elementos Seleccionados




#### POST /financeable_elements/v1/statusChange

JSON entrada - Header

	lIdtplUsuario = String

JSON entrada - Body

	financeable_elements/v1/statusChange
	
	{ 
	   "ListadoElementos":[ 
	      { 
	         "Accion":"E",
	         "IdElemenAdicional":"101975",
	         "Operacion":"1834229951",
	         "NumeroContrato":"",
	         "RutCliente":"175574042",
	         "Valor":"",
	         "Estado":"",
	         "Patente":"",
	         "VIN":"",
	         "Modelo":"",
	         "NombreModelo":"",
	         "Marca":"",
	         "NombreMarca":"",
	         "IdSucursal":"",
	         "NombreSucursal":"",
	         "IdDistribuidor":"",
	         "NombreDistribuidor":"",
	         "Version":"",
	         "NombreVersion":"",
	         "RutPago":"",
	         "NombrePago":"",
	         "EstadoVehiculo":"",
	         "FechaInicioVigencia":"",
	         "FechaTerminoVigencia":"2019-12-06",
	         "numBien":"",
	         "UsuarioCreacion":"179",
	         "UsuarioModificacion":""
	      }
	   ]
	}

Datos prueba:

    http://localhost:8406/api/financeable_elements/v1/statusChange
    
    { 
	   "ListadoElementos":[ 
	      { 
	         "Accion":"E",
	         "IdElemenAdicional":"101975",
	         "Operacion":"1834229951",
	         "NumeroContrato":"",
	         "RutCliente":"175574042",
	         "Valor":"",
	         "Estado":"",
	         "Patente":"",
	         "VIN":"",
	         "Modelo":"",
	         "NombreModelo":"",
	         "Marca":"",
	         "NombreMarca":"",
	         "IdSucursal":"",
	         "NombreSucursal":"",
	         "IdDistribuidor":"",
	         "NombreDistribuidor":"",
	         "Version":"",
	         "NombreVersion":"",
	         "RutPago":"",
	         "NombrePago":"",
	         "EstadoVehiculo":"",
	         "FechaInicioVigencia":"",
	         "FechaTerminoVigencia":"2019-12-06",
	         "numBien":"",
	         "UsuarioCreacion":"179",
	         "UsuarioModificacion":""
	      },
	      { 
	         "Accion":"E",
	         "IdElemenAdicional":"101977",
	         "Operacion":"1834229951",
	         "NumeroContrato":"",
	         "RutCliente":"175574042",
	         "Valor":"",
	         "Estado":"",
	         "Patente":"",
	         "VIN":"",
	         "Modelo":"",
	         "NombreModelo":"",
	         "Marca":"",
	         "NombreMarca":"",
	         "IdSucursal":"",
	         "NombreSucursal":"",
	         "IdDistribuidor":"",
	         "NombreDistribuidor":"",
	         "Version":"",
	         "NombreVersion":"",
	         "RutPago":"",
	         "NombrePago":"",
	         "EstadoVehiculo":"",
	         "FechaInicioVigencia":"",
	         "FechaTerminoVigencia":"2019-12-06",
	         "numBien":"",
	         "UsuarioCreacion":"179",
	         "UsuarioModificacion":""
	      },
	      { 
	         "Accion":"G",
	         "IdElemenAdicional":"101975",
	         "Operacion":"1834229951",
	         "NumeroContrato":"",
	         "RutCliente":"175574042",
	         "Valor":"159990",
	         "Estado":"I",
	         "Patente":"",
	         "VIN":"",
	         "Modelo":"886008857",
	         "NombreModelo":"NEW SENTRA",
	         "Marca":"119200842",
	         "NombreMarca":"NISSAN",
	         "IdSucursal":"36781117",
	         "NombreSucursal":"ALAMEDA NISSAN RANCAGUA",
	         "IdDistribuidor":"4",
	         "NombreDistribuidor":"ALAMEDA",
	         "Version":"886011702",
	         "NombreVersion":"ADVANCE CVT",
	         "RutPago":"",
	         "NombrePago":"",
	         "EstadoVehiculo":"N",
	         "FechaInicioVigencia":"2019-12-06",
	         "FechaTerminoVigencia":"",
	         "numBien":"1",
	         "UsuarioCreacion":"179",
	         "UsuarioModificacion":"179"
	      },
	      { 
	         "Accion":"G",
	         "IdElemenAdicional":"101977",
	         "Operacion":"1834229951",
	         "NumeroContrato":"",
	         "RutCliente":"175574042",
	         "Valor":"173990",
	         "Estado":"I",
	         "Patente":"",
	         "VIN":"",
	         "Modelo":"886008857",
	         "NombreModelo":"NEW SENTRA",
	         "Marca":"119200842",
	         "NombreMarca":"NISSAN",
	         "IdSucursal":"36781117",
	         "NombreSucursal":"ALAMEDA NISSAN RANCAGUA",
	         "IdDistribuidor":"4",
	         "NombreDistribuidor":"ALAMEDA",
	         "Version":"886011702",
	         "NombreVersion":"ADVANCE CVT",
	         "RutPago":"",
	         "NombrePago":"",
	         "EstadoVehiculo":"N",
	         "FechaInicioVigencia":"2019-12-06",
	         "FechaTerminoVigencia":"",
	         "numBien":"1",
	         "UsuarioCreacion":"179",
	         "UsuarioModificacion":"179"
	      }
	   ]
	}


#### GET /financeable_elements/v1/

Entrada - Headers

	lIdtplUsuario = String

Entrada - Param

	idMarca = Integer
	idModelo = Integer
	sucursal  = Integer
	distribuidor = Integer
	estadoVehiculo = String
	disponibleDesde = String
	disponibleHasta = String
	version = Integer

Datos prueba:

	http://localhost:8406/eaf/api/financeable_elements/v1?disponibleDesde=2010-10-10&disponibleHasta=2020-10-10&distribuidor=273109757&estadoVehiculo=N&idMarca=17&idModelo=549468865&sucursal=948826392&version=886012817
	
	{
        "success": true,
        "return": {
            "code": "200",
            "message": "Respuesta exitosa"
        },
        "body": {
            "elementosAdicionales": [
                {
                    "IdElementoAdicional": 11583,
                    "financiable": 1,
                    "administrable": 1,
                    "descripcion": "MANTE





2.  http://localhost:8050/api/v1/auth/login   => POST
    ====================
## Descripción:
Luego de haber ingresado el usuario previamente, para consumir los distintos endpoint en necesario realizar el login en Jwt,
esto con el fin de que se genere el token que se usará para el resto de los endpoints, para este caso el email va a ser el
nombre de usuario que aplique para el login en Jwt. LA hacer login se actualiza en la tabla de usuarios el token obtenido,
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





                                                                                                                                                                                                                        
6.  http://localhost:8050/api/v1/usuarios/auth/nuevo  => POST                                                                                                                                                           
    ====================                                                                                                                                                                                                
## Descripción:                                                                                                                                                                                                         
Este servicio nos permite ingresar o autenticar de forma directa un usuario a Jwt en caso de necesitarlo                                                                                                                                                                     
                                                                                                                                                                                                                           
## JSON's con entradas y salidas de ejemplo                                                                                                                                                                                
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