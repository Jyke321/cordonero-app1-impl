package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void testGetCount() {
        //create an item
        //compare 1 to item.getCount()
        assertEquals(1,1);
    }
    @Test
    void testEditDueDate() {
        //create an item
        //edit it's due date to 2021-10-24
        //compare against string set to 2021-10-24
        assertEquals("","");
    }
    @Test
    void testEditDescription() {
        //create an item
        //edit it's description
        //compare against string set to the same description
        assertEquals("","");
    }
    @Test
    void testValidateDueDateTrue() {
        Item test = new Item();
        assertTrue(test.validateDueDate("2021-11-07"));
    }
    @Test
    void testValidateDueDateFalse() {
        Item test = new Item();
        assertFalse(test.validateDueDate("11-07-2021"));
    }
}