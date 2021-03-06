package mybatis.service.user.test;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.impl.UserDaoImpl11;
import mybatis.service.user.impl.UserServiceImpl12;

/*
 * FileName : MyBatisTestApp101.java
  */
public class MyBatisTestApp11 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
		
		//==> UserDaoImpl11 생성 및 sqlSession instance setter injection
		UserDaoImpl11 userDao = new UserDaoImpl11();
		userDao.setSqlSession(sqlSession);
		System.out.println("\n");
		
		UserServiceImpl12 userService = new  UserServiceImpl12();
		
		System.out.println("\n");
		
		//==> Test 용 User instance 생성  
		User user = new User("user30","박성원","user04","1","","","","",new Date(20/10/06));
		
		//1. UserMapper10.addUser Test  :: users table age/grade/redDate 입력값 확인할것 : OK 
		System.out.println(":: 1. addUser(INSERT)  ? ");
		System.out.println(":: "+ userDao.addUser(user));
		System.out.println("\n");
		
		//2. UserMapper10.getUser Test :: 주몽 inert 확인 
		System.out.println(":: 2. getUser(SELECT)  ? ");
		System.out.println(":: "+userDao.getUser(user.getUserId()));
		System.out.println("\n");
		
		//3. UserMapper10.uadateUser Test  :: users table age/grade/redDate 입력값 확인할것 : OK
		//                                                    :: 주몽 ==> 온달 수정
		user.setUserName("온달");
		//user.setGrade(777);
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ userDao.updateUser(user));
		System.out.println("\n");
		
		//4. UserMapper10.getUserList Test  :: Dynamic Query 확인 id=user04/name=온달 검색
		System.out.println(":: 4. getUser(SELECT)  ? ");
		Search search = new Search();
		ArrayList<String> arrayList = new ArrayList<String>();
		search.setSearchCondition("userId");
		arrayList.add("user04");
		search.setUserId(arrayList);
		//System.out.println(":: "+userDao.getUserList(search);
		System.out.println("\n");
		
		//5. UserMapper10.removeUser Test
		System.out.println(":: 5. Use10.removeUser (DELETE)  ? ");
		System.out.println(":: "+userDao.removeUser(user.getUserId()) );
		System.out.println("\n");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n");
		
		//==> Test 용 Search instance 생성 
		//Search search = new Search();
		
		//1. UserMapper10.getUserList Test 
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		System.out.println( userDao.getUserList(search) );
		
		//2. UserMapper10.getUserList Test 
		search.setSearchCondition("userId");
		//ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("user01");
		search.setUserId( arrayList );
		
		System.out.println(":: 2. getUserList01(SELECT)  ? ");
		System.out.println(userDao.getUserList(search));
		
		//3. UserMapper10.getUserList Test 
		

		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
		
	}//end of main
}//end of class