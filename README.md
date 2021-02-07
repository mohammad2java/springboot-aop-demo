# SpringBoot AOP DEMO NOTES
-------------------------------------
Basic history:

	Spring AOP is impl from Spring for AOP.original aop impl is AspectJ.
	Spring AOP only support apply aop on method execution only.

Setup with Spring Boot
-------------------------
	1) need to add following dependency into existing springboot project.
		<dependency>
	    <groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>

	2) make sure SpringBootApplicatio class also annotated with EnableAspectJAutoProxy.
		like 
		@EnableAspectJAutoProxy
		@SpringBootApplication
			
	3) make sure AOP impl class Having following two annotation at class level.
	@Aspect
	@Component
			


AOP Jargon words & Basic Concept.
----------------------------------
	Aspect - > logic of AOP apart from business code(target method) like logging,stopwatch impl.
	
	Advice -> when to apply aspect on target method  
	(@Before,@After,@AfterReturnning,@AfterThrowing,@Around)
	
	Pointcut -> an expression which match the JoinPoint(targetMethod);
	
	Notes: Target object must be Spring bean (Controller is also a spring bean object).
	
	
	
Advice Types with use.
------------------------------
	
@Before

	This advice is used when you want to add aspect(aop code) just before target method.
	This always execute in case of exception also.

@After

	This advice is used when you want to add aspect(aop code) just after target method.
	This always execute in case of exception also.

@AfterReturnning

	This advice is used when you want to add aspect(aop code) just after target method.
	This is not executed in case of  exception occurred.
	this also can be used to modify/process output only.
	
	example:
		@AfterReturning( pointcut="",returning="retVal")
	  public Object doAccessCheck(Object retVal) {
	    // ...
	  }


@AfterThrowing

	This advice is used when you want to execute aspect(aop code) in case of RE(exception occurred).

@Around

	This advice is used when you want to add aspect(aop code) just before & after target method.
	and if you want to modify the input & output  of target method.
	This having high priority compare to before & after.
	This having aop method argument type ,ProceedingJoinPoint instead of JoinPoint
	This is not executed in case of  exception occurred.





Method Signature of AOP class.
------------------------------------

	@AdviceName("Pointcut" or "MethodName of Pointcut")
	public void methodName(JoinPoint/ProceedingJoinPoint args)
	 
	example 1:
	
	@Pointcut("execution(* com.amir.springbootaopdemo.TestController.*(..))")
	public void applyForTestController() {		
		}
		
		Note: you can combine pointcut also
		like
		@Pointcut("repositoryMethods() && firstLongParamMethods()")
			public void entityCreationMethods() {}
		
		3 valid combined operator (&&, || , !)
		
		
	@Before("applyForTestController()")   //this is method name of pointcut.
	public void beforeTestMethod(JoinPoint joinpoint) {
     // aop code that u want to execute. 
   	}
	
	
	example 2:
	
	@Before("execution(* com.amir.springbootaopdemo.TestController.*(..))") 
	public void beforeTestMethod(JoinPoint joinpoint) {
     // aop code that u want to execute. 
   	}
   	
   	
   	
How to write Pointcut expression.
----------------------------------------
 
1) first/original way is in syntax. using execution command
-------------------------------
	 1.1) This complete method signature with full class name.
	 "execution(public String com.amir.springbootaopdemo.TestController.ping(String)"
	 1.2) we can used wildcard(*,..) for pattern matching.
	 "execution(* com.amir.springbootaopdemo.TestController.*(..))"
	   first * means any modifier/return type
	   second * means anymethod name.
	   .. means zero or more agrument.
	   
2) apart from execution command.
----------------------------------

	 2.1 ) within 	
		for all method of TestController
		"within(com.amir.springbootaopdemo.TestController)"
	
		We could also match any type within the com.amir package or a sub-package.
		"within(com.amir..*)"
		
		2.2) @annotation
		"@annotation(com.amir.Loggable)"
		
		2.3) bean 
		apply bean which end with Manager. 
		bean(*Manager)
		
 
 
	=> to know about more please visit.
	 https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html
 
 
 
 
	


	
	
	