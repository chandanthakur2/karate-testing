import com.intuit.karate.junit5.Karate;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5.class)
class TestRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features").relativeTo(getClass());
    }
}