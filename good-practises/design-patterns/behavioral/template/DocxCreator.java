package behavioral.template;

public class DocxCreator extends DocumentCreator {

    public DocxCreator(String header, String body) {
        super(header, body);
    }

    // cannot override createDocument() method as it's final

//    @Override
//    public void createDocument() {
//        attachBody();
//        attachHeader();
//    }

    @Override
    protected void attachHeader() {
        System.out.println("Attached header to *.docx document");
    }

    @Override
    protected void attachBody() {
        System.out.println("Attached body to *.docx document");
    }

}
