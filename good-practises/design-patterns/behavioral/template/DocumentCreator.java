package behavioral.template;

public abstract class DocumentCreator {

    private String header;
    private String body;

    public DocumentCreator(String header, String body) {
        this.header = header;
        this.body = body;
    }

    protected abstract void attachHeader();
    protected abstract void attachBody();

    // final method to ensure that no subclass change its implementation
    public final void createDocument() {
        attachHeader();
        attachBody();
    }

}
