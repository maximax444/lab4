public interface Actions {
    void tryToOpenTheDoor (Button b, Door d);
    void pressTheButton(Button b);
    void goTo(Place place, Door d, Elastoplastic e) throws DoorToSectionException;
    void switchLamp(Switch sw, Human[] people);
    public void goToBeforeSection(Place place);
}
