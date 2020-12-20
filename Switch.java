public class Switch extends Things {
    private Boolean switchCondition;
    Switch(String name, String description) {
        super(name, description);
        this.switchCondition = false;
    }

    /*Внутренний нестатический класс*/
    private interface ThingsInfo {
        String getName();
        String getDescription();
    }
    class PerformanceInfo implements ThingsInfo{
        public String getName() {
            return Switch.this.name;
        }
        public String getDescription() {
            return Switch.this.description;
        }
    }
    void getInfo() {
        PerformanceInfo inner = new PerformanceInfo();
        System.out.println("Название: " + inner.getName() + ", описание: "+ inner.getDescription());
    }

    public Boolean getSwitchCondition() {
        return this.switchCondition;
    }
    public void switchOn() {
        this.switchCondition = true;
    }
}
