package com.learnjbehave;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.jbehave.core.*;
import org.junit.Test;

import com.learnjbehave.steps.customercarecheck;
import com.learnjbehave.steps.Common_actions;





import com.learnjbehave.steps.samplecheck;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;  
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;



public class TestRunnerStories extends JUnitStories  {
   
	 public TestRunnerStories() {
		 super();  
	    }
	
	
	@Override  
	   public Configuration configuration() {  
		 Class<? extends Embeddable> embeddableClass = this.getClass();
	
		 /* Properties viewResources = new Properties();
	        viewResources.put("decorateNonHtml", "true");
	        // Start from default ParameterConverters instance
	        ParameterConverters parameterConverters = new ParameterConverters();
	        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
	        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
	        // add custom converters
	        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
	                new ExamplesTableConverter(examplesTableFactory));
	        return new MostUsefulConfiguration()
	        
	            .useStoryLoader(new LoadFromClasspath(embeddableClass))
	            .useStoryParser(new RegexStoryParser(examplesTableFactory)) 
	            .useStoryReporterBuilder(new StoryReporterBuilder()
	                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
	                .withDefaultFormats()
	                .withFormats(CONSOLE, TXT, HTML, XML))
	            .useParameterConverters(parameterConverters);*/
		return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder()
        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
        .withDefaultFormats()
        .withFormats(CONSOLE, TXT, HTML, XML));
	        
	}  
	
	// Here we specify the steps classes  
	   @Override  
	   public InjectableStepsFactory stepsFactory() {  
	     
			return new InstanceStepsFactory(configuration(),new Common_actions(),new customercarecheck());
		
	   }  
 
	 
	   @Override
	    protected List<String> storyPaths() {
	        List<String> storiesToRun = new ArrayList<String>();
	        String storyProperty = System.getProperty("story");

	        if (storyProperty == null || storyProperty.isEmpty()) {
	           throw new RuntimeException("Please specify which stories to run");
	        }

	        String[] storyNames = storyProperty.split(",");
	        StoryFinder sf = new StoryFinder();
	        URL baseUrl = CodeLocations.codeLocationFromClass(this.getClass());
	        System.out.println("&^&^&^&^&"+baseUrl);

	        for (String storyName : storyNames) {
	           storiesToRun.addAll(sf.findPaths(baseUrl, storyName, ""));
	        }

	        return storiesToRun;
	    }
	    
	   
	   //Command to run selective tests
	   //mvn clean test -Dwebdriver.firefox.bin="C:\Program Files\Mozilla\Firefox\firefox.exe" -Dstory=myStory.story  

	   
	 //  @Override
	  //  protected List<String> storyPaths() {
	 //       return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/customercare.story", "**/excluded*.story");
	 //  }

	   
   
}
