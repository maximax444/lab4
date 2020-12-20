
import java.util.Objects;
public class Human implements Actions, Condition {
    private String name;
    private Place place;
    private int condition;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", place=" + place +
                ", condition=" + condition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return condition == human.condition &&
                Objects.equals(name, human.name) &&
                place == human.place;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, condition);
    }

    Human(String name, Place place){
        this.name = name;
        this.place = place;
        this.condition = 100;
        System.out.println("Человек создан - " + this.name + ". Место нахождения: " + place);
    }

    Human(String name, Place place, int condition){
        this.name = name;
        this.place = place;
        this.condition = condition;
        System.out.println("Человек создан - " + this.name + ". Место нахождения: " + place + ". Состояние: " + condition + "/100");
    }

    public void tryToOpenTheDoor(Button b, Door d) {
        if (b.getButtonCondition()) {
            System.out.println(name + " открыл дверь в отсек!");
            d.openDoor();
        } else {
            System.out.println("Чтобы дверь открылась нужно нажать на кнопку!");
        }
    }

    public void pressTheButton (Button b) {
        if (b.getButtonCondition()) {
            System.out.println(this.name + " нажал кнопку. Теперь дверь заперта! Нажмите кнопку ещё раз, чтобы открыть её!");
        } else {
            System.out.println(this.name + " нажал кнопку. Теперь можно открывать дверь!");
        }
        b.changeButtonCondition();
    }
    public void goToBeforeSection(Place place) {
        this.place = place;
        System.out.println(name + " перешёл в другую часть корабля - " + place);
    }
    public void activateElevator(Human[] people) throws ElevatorException{
        if (this.place != Place.ELEVATOR) {
            throw new ElevatorException("Вы должны находиться в лифте, чтобы поехать!");
        } else {
            this.place = Place.HALL;
            System.out.println("Пассажиры уехали на лифте и попали в " + place);
        }

    }
    public void goTo(Place place, Door d, Elastoplastic e) throws DoorToSectionException {
        Place oldLocation = this.place;
        if (d.getDoorCondition()) {
            this.place = place;
            System.out.println(name + " перешёл в другую часть корабля - " + place);
            if ((place == Place.LADDER) & (this.condition >= 60)) {
                if (oldLocation == Place.OUTOFSECTION) {
                    this.place = Place.SECTION;
                    System.out.println(name + ", пройдя по лестнице, попадает в " + this.place);
                } else {
                    this.place = Place.OUTOFSECTION;
                    System.out.println(name + ", пройдя по лестнице, попадает в " + this.place);
                }
            } else if ((place == Place.LADDER) & (this.condition < 60)) {
                this.place = Place.SECTION;
                System.out.println(name + " не важно себя чуствует и скатывается кубарем по лестнице, его текущее место расположения - " + this.place);

                if (e.getElastoplasticLocation() == Place.SECTION){
                    System.out.println(name + ": Всё в порядке тут эластопласмасса! Я не ушибся");
                } else {
                    System.out.println(name + ": AAAAAAAAAAAAAAAAA!");
                    this.setCondition(10);
                }
            }
        } else {
            throw new DoorToSectionException(name + " пытается перейти в другой отсек корабля (" + place + "), но это весьма сложно сделать через закрытую дверь");
        }
    }
    public void switchLamp(Switch sw, Human[] people) {
        if (sw.getSwitchCondition()) {
            System.out.println(this.name + " нажал кнопку выключателя. Теперь света нет!");
        } else {
            System.out.println(this.name + " нажал кнопку выключателя. Теперь светло!");
        }
        sw.switchOn();
        for (Human hum: people ){
            hum.setCondition(100);
        }
    }

    public void sayCondition() {
        System.out.println(this.name + ": Я в порядке на " + condition + "%");
    }
    public int getCondition() {return condition;}
    public void setCondition(int cond) {
        this.condition = cond;
        System.out.println(this.name + ": Теперь я в порядке на " + condition + "%");
    }
    /*Статический внутренний класс*/
    public static class StartInspection{
        private int neznaikaC;
        private int ponchikC;
        StartInspection(Human n, Human p) {
            this.neznaikaC = n.getCondition();
            this.ponchikC = p.getCondition();
        }
        public void startInsp(){
            if (neznaikaC>=ponchikC) {
                System.out.println("Незнайка начал осмотр секции!");
            } else {
                System.out.println("Пончик начал осмотр секции!");
            }
        }
    }
}
