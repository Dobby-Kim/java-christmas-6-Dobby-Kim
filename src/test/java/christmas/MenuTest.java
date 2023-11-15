package christmas;

import christmas.enums.Menu;
import christmas.enums.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuTest {

    @Test
    @DisplayName("String으로부터 Menu 생성")
    void testFromStringValid() {
        assertEquals(Menu.MUSHROOM_SOUP, Menu.fromString("양송이수프"));
        assertEquals(Menu.BBQ_RIBS, Menu.fromString("바비큐립"));
        assertEquals(Menu.CHAMPAGNE, Menu.fromString("샴페인"));
    }

    @Test
    @DisplayName("없는 메뉴 생성 안하는 것 검증")
    void testFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Menu.fromString("없는 메뉴");
        });
    }

    @Test
    @DisplayName("getName")
    void testGetName() {
        assertEquals("양송이수프", Menu.MUSHROOM_SOUP.getName());
        assertEquals("레드와인", Menu.RED_WINE.getName());
    }

    @Test
    @DisplayName("getPrice")
    void testGetPrice() {
        assertEquals(6000, Menu.MUSHROOM_SOUP.getPrice());
        assertEquals(60000, Menu.RED_WINE.getPrice());
    }

    @Test
    @DisplayName("getCategory")
    void testGetCategory() {
        assertEquals(MenuCategory.APPETIZER, Menu.MUSHROOM_SOUP.getCategory());
        assertEquals(MenuCategory.BEVERAGE, Menu.RED_WINE.getCategory());
    }
}