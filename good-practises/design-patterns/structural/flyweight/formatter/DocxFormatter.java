package structural.flyweight.formatter;

import structural.flyweight.Document;

class DocxFormatter implements DocumentFormatter {

    DocxFormatter() {
        // assume that creating formatter from scratch takes some time
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e ) {

        }

        System.out.println("Created new instance of Docx Formatter");
    }

    @Override
    public void format(Document document) {
        System.out.println("Creating *.docx document...");
    }

}
