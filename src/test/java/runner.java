
        import io.cucumber.java.Before;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.apache.logging.log4j.ThreadContext;
        import org.junit.runner.RunWith;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.BeforeTest;

        import java.net.MalformedURLException;

        import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
//                , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"
        }
        ,features = {"src/test/resources/feature/test.feature"}
        ,glue = {"org.example.stepdef"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true
//        ,tags = "@test"

)
public class runner {


}

