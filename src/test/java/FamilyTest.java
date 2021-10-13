import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FamilyTest {
    Human mother = new Human("Anna", "Bell", 35);
    Human father = new Human("George", "Bell", 40);

    Human child = new Human("Mary", "Bell", 15);
    Human child2 = new Human("Maryam", "Bell", 10);
    Human child3 = new Human("John", "Bell", 7);


    @DisplayName("Check new child is added to family")
    @Test
    void addChild(){
        List<Human> children = new ArrayList<>();
        children.add(child);
        children.add(child2);
        Family family = new Family(mother, father, children);
        Assertions.assertTrue(family.addChild(family, child3));
    }

    @DisplayName("Check family size after deleting one of children")
    @Test
    void deleteChild(){
        List<Human> children = new ArrayList<>();
        children.add(child);
        children.add(child2);
        children.add(child3);
        Family family = new Family(mother, father, children);
        int count = family.familyMembers(family);
        family.deleteChild(family, child2);
        Assertions.assertEquals(count-1, family.familyMembers(family));
    }


}