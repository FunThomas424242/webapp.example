<%-- Eine Tag Definitionsdatei --%>
<%@ tag %>
<%-- Viele Attribute, ̈ahnlich page --%>
<%@ attribute name="message" required="true" %>
<%@ attribute name="style" required="true" %>
<%-- Notwendiges Attribut für das Tag --%>

<p class="${style}">
  ${message}
</p>

<jsp:doBody/>
<%-- Hier wird der Rumpf des Tag eingef ̈ugt --%>
