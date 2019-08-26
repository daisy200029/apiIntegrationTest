import org.junit.platform.runner.IncludeTags;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

public class apiIntegrationTestRunner {

    @RunWith(JUnitPlatform.class)
    @IncludeTags("ffLite")
    public class ffliteTestRunner
    {
    }
}
