<%@ page contentType="text/html;charset=euc-kr"%>


<script>
	alert("���� �Ǿ����ϴ�~!!")
	window.location = "/spring/member/loginForm.do";
</script>



<%-- <%@ page import = "ch11.logon.LogonDBBean" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("euc-kr");%>

<jsp:useBean id="member" class="ch11.logon.LogonDataBean">
    <jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
    member.setReg_date(new Timestamp(System.currentTimeMillis()) );
    LogonDBBean manager = LogonDBBean.getInstance();
    manager.insertMember(member);

    response.sendRedirect("loginForm.jsp");
%> --%>