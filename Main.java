public class Main {
    void startProgramm() {
        class StartProgramm {
            public void print() {
                System.out.println("Программа запущена и работает!");
            }
        }
        StartProgramm st = new StartProgramm();
        st.print();
    }
    public static void main(String[] args){
        Main outer = new Main();
        outer.startProgramm();
        Human neznaika = new Human("Незнайка", Place.OUTOFSECTION);
        Human ponchik = new Human("Пончик", Place.OUTOFSECTION, 40);
        Button button = new Button("Кнопка", "Большая красная кнопка, открывающая дверь в отсек");
        Door door = new Door("Дверь", "Открывается по нажатию кнопки рядом");
        Switch sw = new Switch("Выключатель", "Включает и выключает свет в отсеке");
        Elastoplastic el = new Elastoplastic("Эластопластмасса", "Позволяет не ушибиться при падении", Place.SECTION);
        Human[] people = new Human[2];
        people[0] = neznaika;
        people[1] = ponchik;
        System.out.println(neznaika.toString());
        System.out.println(ponchik.toString());
        ponchik.sayCondition();
        neznaika.sayCondition();
        neznaika.sayCondition();

        try {
            neznaika.activateElevator(people);
        } catch (ElevatorException ee){
            System.out.println(ee.getMessage());
        }
        neznaika.goToBeforeSection(Place.ELEVATOR);
        ponchik.goToBeforeSection(Place.ELEVATOR);
        try {
            neznaika.activateElevator(people);
        } catch (ElevatorException ee){
            System.out.println(ee.getMessage());
        }
        neznaika.goToBeforeSection(Place.OUTOFSECTION);
        ponchik.goToBeforeSection(Place.OUTOFSECTION);


        try{
            neznaika.goTo(Place.LADDER, door, el);
        } catch (DoorToSectionException e) {
            System.out.println(e.getMessage());
        }

        neznaika.tryToOpenTheDoor(button, door);
        neznaika.pressTheButton(button);
        neznaika.pressTheButton(button);
        neznaika.pressTheButton(button);
        neznaika.tryToOpenTheDoor(button, door);
        try{
            neznaika.goTo(Place.LADDER, door, el);
        } catch (DoorToSectionException e) {
            System.out.println(e.getMessage());
        }
        try{
            ponchik.goTo(Place.LADDER, door, el);
        } catch (DoorToSectionException e) {
            System.out.println(e.getMessage());
        }
        neznaika.switchLamp(sw, people);


        /*Получение инфы из нестатического внутреннего класса*/
        sw.getInfo();
        /*Инициализация статического внутреннего класса*/
        Human.StartInspection st = new Human.StartInspection(neznaika, ponchik);
        st.startInsp();

        /*Анонимные классы для осмотра разных частей секции*/
        InspectionSection inspectionFridge = new InspectionSection() {
            public void InspectionThings() {
                System.out.println("Осмотр холодильника! Найдены продукты!");
            }
        };
        InspectionSection inspectionWardrobe = new InspectionSection() {
            public void InspectionThings() {
                System.out.println("Осмотр шкафов!");
            }
        };

        InspectionSection inspectionButtons = new InspectionSection() {
            public void InspectionThings() {
                System.out.println("Осмотр кнопок в секции!");
            }
        };
        inspectionFridge.InspectionThings();
        inspectionWardrobe.InspectionThings();
        inspectionButtons.InspectionThings();
    }

}
