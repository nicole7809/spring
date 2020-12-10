/*
 * package ch11.logon;
 * 
 * public interface LogonDBBeanService { public static final String
 * serverName="oracle.jdbc.driver.OracleDriver"; public static final String
 * user="scott"; public static final String pass="tiger"; public static final
 * String url="jdbc:oracle:thin:@masternull.iptime.org:1521:orcl";
 * 
 * 
 * id / passwd 필수항목 name - 인코딩처리 reg_date - 현재시간 age - 기본값 0 oracle 데이터베이스 활용
 * 
 * public void insertMember(LogonDataBean member)throws Exception;
 * 
 * 
 * 
 * 
 * 
 * public int userCheck(String id , String passwd)throws Exception; public int
 * confirmId(String id)throws Exception; public LogonDataBean getMember(String
 * id)throws Exception; public void updateMember(LogonDataBean member)throws
 * Exception; public int deleteMember(String id , String passwd) throws
 * Exception; }
 * 
 */