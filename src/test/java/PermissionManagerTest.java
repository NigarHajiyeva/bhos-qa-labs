import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class PermissionManagerTest {
    PermissionManager permissionManager = new PermissionManager();

    @Test
    @DisplayName("Unit Test for getPermissionLevel() method")
    void testGetPermissionLevel() {
        assertEquals("USER", permissionManager.getPermissionLevel());
    }

}
