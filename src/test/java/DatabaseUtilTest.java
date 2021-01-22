import com.gmail.artsiombaranau.utils.DatabaseUtil;
import org.junit.Assert;
import org.junit.Test;

public class DatabaseUtilTest {

    @Test
    public void connectionShouldBeRecieved() {
        Assert.assertNotNull(DatabaseUtil.getConnection());

    }

}
