package structural.flyweight.formatter;

import structural.flyweight.Document;

class PDFFormatter implements DocumentFormatter {

    PDFFormatter() {
        // assume that creating formatter from scratch takes some time
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e ) {

        }
        System.out.println("Created new instance of PDF Formatter");
    }

    @Override
    public void format(Document document) {

    }
}
