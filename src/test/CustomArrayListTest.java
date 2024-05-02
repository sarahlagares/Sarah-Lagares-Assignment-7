package test;

import main.CustomArrayList;
import main.CustomList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    //Request 1 : add new items
    @Test
    public void test_Add_One_Item() {
        CustomList<Integer> sut = new CustomArrayList<>();
        sut.add(1);
        assertEquals(1, sut.get(0));
        assertEquals(1, sut.getSize());
    }

    @Test
    public void test_Add_One_Hundred_Items() {
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        assertEquals(99, sut.get(99));
        assertEquals(100, sut.getSize());
    }

    //Request 2: add new items in the specified index
    @Test
    public void test_Add_New_Item_To_Specified_Index() {
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.add(59, 95);
        assertEquals(101, sut.getSize());
        assertEquals(95, sut.get(59));
    }
    @Test
    public void test_Add_New_Item_To_First_Index(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.add(0,95);
        assertEquals(101, sut.getSize());
        assertEquals(95, sut.get(0));
    }
    @Test
    public void test_Add_New_Item_To_Last_Index(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.add(99,95);
        assertEquals(101, sut.getSize());
        assertEquals(95, sut.get(99));
    }

    //Request 3: Throw Exception when index doesn't exist
    @Test
    public void test_Throw_Exception_When_Index_Does_Not_Exist(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        assertThrows(IndexOutOfBoundsException.class, ()-> sut.add(250,250));
        assertThrows(IndexOutOfBoundsException.class, ()-> sut.add(-2,250));

    }
    //Request 4: Remove items
    @Test
    public void test_Remove_One_Item_From_Middle_Of_List(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.remove(88);
        assertEquals(89, sut.get(88));
        assertEquals(99, sut.getSize());
        assertNull(sut.get(99));
    }
    @Test
    public void test_Remove_One_Item_From_Beginning_Of_List(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.remove(0);
        assertEquals(1, sut.get(0));
        assertEquals(99, sut.getSize());
        assertNull(sut.get(99));
    }
    @Test
    public void test_Remove_One_Item_From_End_Of_List(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.remove(99);
        assertEquals(98, sut.get(98));
        assertEquals(99, sut.getSize());
        assertNull(sut.get(99));
    }
    @Test
    public void test_Remove_Multiple_Items_From_List(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        sut.remove(0);
        sut.remove(59);
        sut.remove(97);
        assertEquals(1, sut.get(0));
        assertEquals(62, sut.get(60));
        assertEquals(97, sut.getSize());
        assertNull(sut.get(98));
    }

    @Test
    public void test_Throw_Exception_When_Remove__Index_Does_Not_Exist() {
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);

        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(250));
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(-2));
    }

    @Test
    public void test_Remove_One_Item_Returns_Removed_Item(){
        CustomList<Integer> sut = new CustomArrayList<>();
        generateOneHundredNumbers(sut);
        assertEquals(88, sut.remove(88));
    }
    //Method - Generate One Hundred Numbers for test
    private static void generateOneHundredNumbers(CustomList<Integer> sut) {
        for (int i = 0; i < 100; i++) {
            sut.add(i);
        }
    }

}