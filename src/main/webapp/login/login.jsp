<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<title>Login</title>
</head>
<body>

 <h1 id="welcome">Anmeldung</h1>
 
 <tag:meldung message="${loginBean.meldung}" style="fehler" />
 
 

 <form action="${pageContext.request.contextPath}/action/login" method="post">
  <fieldset>
   <ul>
    <li class="text">Bitte geben Sie Ihre Zugangsdaten ein.</li>
    <li><label for="user">Nutzername:</label> <input type="text"
     name="user" id="user" class="text" /></li>
    <li><label for="passwort">Passwort:</label> <input
     type="password" name="password" id="password" class="text" /></li>
    <li class="submit">
     <button id="ok" type="submit" class="submit">Anmelden</button>
    </li>
   </ul>
  </fieldset>
 </form>


</body>
</html>