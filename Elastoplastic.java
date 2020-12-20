public class Elastoplastic extends Things {
    private Boolean elastoplasticCond;
    private Place elastoplasticLocation;
    Elastoplastic(String name, String description, Place p) {
        super(name, description);
        this.elastoplasticCond = true;
        this.elastoplasticLocation = p;
    }
    public Place getElastoplasticLocation() {
        return this.elastoplasticLocation;
    }
}