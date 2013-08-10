<%-- 
    Document   : registrodatos
    Created on : 11-Jun-2013, 08:57:02
    Author     : Jorge Garcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            #DatosPersonales table td{
                height:40px;
            }
        </style>
    </head>
    <body>
        <h1>Datos Personales</h1>
        <div>
  <p>&nbsp;</p>
  <form action="ServletPersona" method="post" name="DatosPersonales" id="DatosPersonales">
    <table width="572" border="0">
      <tr>
        <td width="169"><p><strong>Cedula</strong></p></td>
        <td width="363"><label for="cedula"></label>
        <input type="text" name="cedula" id="cedula"></td>
        <td width="26">&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Nombres</strong></p></td>
        <td><label for="nombres"></label>
        <input type="text" name="nombres" id="nombres"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Apellidos</strong></p></td>
        <td><label for="apellidos"></label>
        <input type="text" name="apellidos" id="apellidos"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Fecha de Nacimiento</strong></p></td>
        <td><label for="fechaNacimiento"></label>
        <input type="date" name="fechaNacimiento" id="fechaNacimiento"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Sexo</strong></p></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Direccion</strong></p></td>
        <td><label for="direccion"></label>
        <input type="text" name="direccion" id="direccion"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Ciudad</strong></p></td>
        <td><label for="ciudad"></label>
        <input type="text" name="ciudad" id="ciudad">          <label for="telefono"></label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Telefono</strong></p></td>
        <td><label for="celular">
          <input type="text" name="telefono" id="telefono">
        </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Celular</strong></p></td>
        <td><label for="email">
          <input type="text" name="celular" id="celular">
        </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p><strong>Correo Electronico</strong></p></td>
        <td><input type="email" name="email" id="email"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p>&nbsp;</p></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><p>&nbsp;</p></td>
        <td><input type="submit" value="Enviar"/></td>
        <td>&nbsp;</td>
      </tr>
    </table>
  </form>
</div>

        
    </body>
</html>
