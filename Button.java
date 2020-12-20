public class Button extends Things{
    private Boolean buttonCondition;
    Button(String name, String description) {
        super(name, description);
        this.buttonCondition = false;
    }
    public Boolean getButtonCondition() {
        return this.buttonCondition;
    }
    public void changeButtonCondition() {
        if (this.buttonCondition == true) {
            this.buttonCondition = false;
        } else {
            this.buttonCondition = true;
        }
    }
}