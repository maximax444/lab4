abstract class Things {
    protected String name;
    protected String description;
    Things(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
