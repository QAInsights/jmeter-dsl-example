import static org.assertj.core.api.Assertions.assertThat;
import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

import java.io.IOException;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() throws IOException {

        TestPlanStats helloWorld = testPlan(
                threadGroup(1,1,
                        httpSampler("https://example.com")
                                .children(
                                        responseAssertion().containsSubstrings("Example Domain")
                                )
                ),
                jtlWriter("HelloWorld" + Instant.now().toString().replace(":","-") + ".jtl")
        ).run();

        // Save As JMX
        testPlan(
                threadGroup(1,1,
                        httpSampler("https://example.com")
                                .children(
                                        responseAssertion().containsSubstrings("Example Domain")
                                )
                ),
                jtlWriter("HelloWorld" + Instant.now().toString().replace(":","-") + ".jtl")
        ).saveAsJmx("HelloWorld.jmx");

        // Display GUI
        testPlan(
                threadGroup(1,1,
                        httpSampler("https://example.com")
                                .children(
                                        responseAssertion().containsSubstrings("Example Domain")
                                )
                ),
                jtlWriter("HelloWorld" + Instant.now().toString().replace(":","-") + ".jtl")
        ).showInGui();


    }
}
