package behavioral.template;

public class PDFCreator extends DocumentCreator {

    public PDFCreator(String header, String body) {
        super(header, body);
    }

    // cannot override createDocument() method as it's final

//    @Override
//    public void createDocument() {
//        attachBody();
//        doSth();
//        attachHeader();
//    }

    @Override
    protected void attachHeader() {
        System.out.println("Attached header to *.pdf document");
    }

    @Override
    protected void attachBody() {
        System.out.println("Attached body to *.pdf document");
    }

}
