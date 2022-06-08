import lombok.Getter;

@Getter
public enum ItemType {
    WEAPON("WEAPON");

    private final String type;

    ItemType(String type){this.type = type;}
}
