package bdd.posts;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static bdd.util.ReportUtil.generateCucumberReport;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersRunner {
    final static Logger looger = LoggerFactory.getLogger(UsersRunner.class);

    @Test
    void testUsers() {
        looger.info("Ejecutando nuestra prueba de API");
        Results results =
                Runner.path("classpath:bdd/posts")
                        .tags("@Authorization_1")
                        .outputCucumberJson(true)
                        .parallel(2);
        generateCucumberReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
