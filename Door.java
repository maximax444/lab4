public class Door extends Things{
    private Boolean doorCondition;
    Door(String name, String description) {
        super(name, description);
        this.doorCondition = false;
    }
    public Boolean getDoorCondition() {
        return this.doorCondition;
    }
    public void openDoor() {
        this.doorCondition = true;
    }
}
