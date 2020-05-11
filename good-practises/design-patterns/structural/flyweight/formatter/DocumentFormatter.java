package structural.flyweight.formatter;

import structural.flyweight.Document;

import java.util.function.Supplier;

public interface DocumentFormatter {

    void format(Document document);

    enum Type {

        PDF(PDFFormatter::new),
        DOCX(DocxFormatter::new);

        private Supplier<DocumentFormatter> supplier;

        Type(Supplier<DocumentFormatter> supplier) {
            this.supplier = supplier;
        }

        Supplier<DocumentFormatter> getSupplier() {
            return supplier;
        }

    }

}
