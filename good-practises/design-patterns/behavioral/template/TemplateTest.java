public class TemplateTest {

    public static void main(String[] args) {
        DocumentCreator docxCreator = new DocxCreator("Some header", "Some body");
        DocumentCreator pdfCreator = new PDFCreator("Some header", "Some body");

        docxCreator.createDocument();
        pdfCreator.createDocument();
    }

}
