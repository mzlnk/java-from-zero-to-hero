package structural.flyweight.documenttemplate;

import structural.flyweight.Document;

public class DocxTemplate implements DocumentTemplate {

    @Override
    public void create(Document document) {
        System.out.println("Creating *.docx document...");
    }

}
