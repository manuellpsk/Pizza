<%-- 
    Document   : index
    Created on : 26-03-2018, 22:39:41
    Author     : Notebook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzas</title>
    </head>
    <body>
        <h1><center>Pizza!</center></h1>
        <br><br>
        <form method="post" action="Controlador">
            Tamaño de Pizza:
            <select name="cboxtam">
                <option value="Personal  1000">Personal 1000</option>
                <option value="Mediana  2000">Mediana 2000</option>
                <option value="Grande  3000">Grande 3000</option>
            </select>
            <br>
            <br>
            Tipo de Masa:
            <select name="cboxmasa">
                <option value="A  1000">A 1000</option>
                <option value="B  1500">B 1500</option>
                
            </select>
            <br>
            <br>
            Agregados:
            <br>
            <input type="checkbox" name="agre" value="1">Queso 1000<br>
            <input  type="checkbox"  name="agre" value="2">Champi 1500<br>
            <input type="checkbox"  name="agre" value="3">Papas Fritas 800<br>
                
            
            <br>
            
            Bebida:
            <select name="cboxbebida">
                <option value="Coca-Cola  800">Coca-Cola 800</option>
                <option value="Pepsi  700">Pepsi 700</option>
                <option value="Sprite  750">Sprite 750</option>
            </select>   
            <br>           
            <BR>
            <input name="aceptar" type="submit" value="ACEPTAR">
        </form>
        
        
    </body>
</html>
