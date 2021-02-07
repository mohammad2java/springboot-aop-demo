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
	
	
	
	
