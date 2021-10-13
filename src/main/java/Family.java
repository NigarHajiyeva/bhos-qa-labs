import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Family family;


    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Family(Human mother, Human father, List<Human> children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {

        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }


    public boolean addChild(Family family, Human child) {
        family.getChildren().add(child);
        return true;
    }

    public int familyMembers(Family family) {
        return 2 + (getChildren().size());
    }


    public boolean deleteChild(Family family, Human child) {
        if (family.getChildren().contains(child)) {
            family.getChildren().remove(child);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Family{" + '\n' +
                "mother=" + mother + '\n' +
                ", father=" + father + '\n' +
                ", children=" + children + '\n' +
                '}';
    }


}
