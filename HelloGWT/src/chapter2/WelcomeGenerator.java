package chapter2;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.PropertyOracle;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;

public class WelcomeGenerator extends Generator {

	@Override
	public String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
		if (typeName.equals("chapter2.client.WelcomeImpl")) {
			PropertyOracle propOracle = context.getPropertyOracle();
			String userAgent = "ie6"; 
//					propOracle.getConfigurationProperty("user.agent").getValues().get(0); 
//					propOracle.getPropertyValue(logger, "user.agent");
			
			if (userAgent.equals("ie6")) {
				return "chapter2.client.WelcomeImplIE";
			}
			else if (userAgent.equals("gecko") || userAgent.equals("gecko1_8")) {
				return "chapter2.client.WelcomeImplFirefox";
			}
			else {
				return "chapter2.client.WelcomeImpl";
			}
		}
		else {
			throw new UnableToCompleteException();
		}
	}

}
