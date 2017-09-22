package project.mc.commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut {
	private static Logger log = LoggerFactory.getLogger(NameMatchClassMethodPointcut.class);
	public void setMappedClassName(String mappedClassName) {
		this.setClassFilter(new SimpleClassFilter(mappedClassName));
	}
	
	static class SimpleClassFilter implements ClassFilter{
		String mappedName;
		private SimpleClassFilter(String mappedName) {
			this.mappedName = mappedName;
		}
		@Override
		public boolean matches(Class<?> clazz) {
			log.debug("1.pointcut mappedName: "+mappedName);
			log.debug("2.pointcut clazz.getSimpleName(): "+clazz.getSimpleName());
			return PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName());
		}
		
	}
}